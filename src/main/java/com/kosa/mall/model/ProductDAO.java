package com.kosa.mall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBManager;

public class ProductDAO {

	// 제품 리스트를 조회하는 메서드
	public ArrayList<Product> listNewProduct() {
		ArrayList<Product> productList = new ArrayList<>();
		String sql = "SELECT * FROM products";

		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				int prodNo = rs.getInt("prod_no");
				String prodName = rs.getString("prod_name");
				double prodPrice = rs.getDouble("prod_price");
				String imageUrl = rs.getString("image_url");

				Product product = new Product(prodNo, prodName, prodPrice, imageUrl);
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productList;
	}

	// 주어진 상품 번호(prodNo)에 해당하는 상품 정보를 데이터베이스에서 조회하여 Product 객체로 반환하는 메서드
	public Product getProduct(String prodNo) {
	    Product product = null;
	    String sql = "SELECT * FROM products WHERE prod_no = ?";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, prodNo);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                product = new Product();
	                product.setProdNo(rs.getInt("prod_no"));
	                product.setProdName(rs.getString("prod_name"));
	                product.setProdPrice(rs.getDouble("prod_price"));
	                product.setImageUrl(rs.getString("image_url"));
	            } else {
	                System.out.println("Product not found for prodNo: " + prodNo);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return product;
	}
}
