package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kosa.mall.model.Product;

public class DBManager {

	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String uid = "ace";
	private static String pwd = "me";


	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Product getProductById(String prodNo) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rset = null;
	    Product product = null;

	    try {
	        conn = getConnection();
	        String sql = "SELECT * FROM Products WHERE prod_no = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, prodNo);
	        rset = pstmt.executeQuery();

	        if (rset.next()) {
	            int prodNoInt = rset.getInt("prod_no");
	            String prodName = rset.getString("prod_name");
	            double prodPrice = rset.getDouble("prod_price");
	            String imageUrl = rset.getString("image_url");

	            product = new Product(prodNoInt, prodName, prodPrice, imageUrl);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn, pstmt, rset);
	    }

	    return product;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rset) {
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt) {

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}