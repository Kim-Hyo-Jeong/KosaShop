package com.kosa.mall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBManager;

public class ProductDAO {

	// 페이지네이션이 추가된 제품 리스트를 조회하는 메서드
	public ArrayList<Product> listNewProduct(int page, int pageSize) {
		ArrayList<Product> productList = new ArrayList<>();
		String sql = "SELECT * FROM ( " + "SELECT p.*, ROWNUM rnum FROM ( " + "SELECT * FROM products ORDER BY prod_no "
				+ ") p WHERE ROWNUM <= ? " + ") WHERE rnum > ?";

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			int offset = (page - 1) * pageSize;
			int endRow = page * pageSize;
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, offset);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					int prodNo = rs.getInt("prod_no");
					String prodName = rs.getString("prod_name");
					double prodPrice = rs.getDouble("prod_price");
					String imageUrl = rs.getString("image_url");

					Product product = new Product(prodNo, prodName, prodPrice, imageUrl);
					productList.add(product);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	// 전체 제품 수를 가져오는 메서드
	public int getTotalProducts() {
		String sql = "SELECT COUNT(*) FROM products";
		int count = 0;

		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// 주어진 상품 번호(prodNo)에 해당하는 상품 정보를 데이터베이스에서 조회하여 Product 객체로 반환하는 메서드
	public Product getProduct(String prodNo) {
		Product product = null;
		String sql = "SELECT * FROM products WHERE prod_no = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setProdNo(rs.getInt("prod_no"));
				product.setProdName(rs.getString("prod_name"));
				product.setProdPrice(rs.getInt("prod_price"));
				product.setImageUrl(rs.getString("image_url"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return product;
	}

}