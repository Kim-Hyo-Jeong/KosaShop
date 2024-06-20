package com.kosa.mall.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "ace";
	private static final String DB_PASSWORD = "me";

	public ProductDAO() throws ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
	}

	// 데이터베이스 연결을 위한 메서드
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	// 제품 리스트를 조회하는 메서드
	public ArrayList<Product> listNewProduct() {
		ArrayList<Product> productList = new ArrayList<>();
		String sql = "SELECT * FROM products";

		try (Connection conn = getConnection();
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
}