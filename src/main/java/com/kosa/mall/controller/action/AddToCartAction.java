// AddToCartAction.java

package com.kosa.mall.controller.action;

import java.io.IOException;

import com.kosa.mall.dao.CartDAO;
import com.kosa.mall.dto.ProductVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.DBManager;

public class AddToCartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("loginUser") == null) {
	        // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
	        response.sendRedirect("ProductMarket?command=login_form");
	        return;
	    }

	    // 로그인된 경우에만 장바구니에 제품 추가 로직 수행
	    String prodNo = request.getParameter("prodNo");
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    ProductVO product = DBManager.getProductById(prodNo);

	    CartDAO cart = (CartDAO) session.getAttribute("cart");
	    if (cart == null) {
	        cart = new CartDAO();
	        session.setAttribute("cart", cart);
	    }

	    // Product에서 imageUrl을 가져와서 CartItem 생성
	    String imageUrl = product.getImageUrl();
	    cart.addProduct(prodNo, product.getProdName(), product.getProdPrice(), quantity, imageUrl);

	    // 장바구니 업데이트 후 장바구니 페이지로 이동
	    response.sendRedirect("ProductMarket?command=cart_list");
	}
}