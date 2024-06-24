package com.kosa.mall.model;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RemoveFromCartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodNo = request.getParameter("prodNo");

		// 세션에서 장바구니 정보 가져오기
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		// RemoveFromCartAction.java에서 로그 추가
		if (cart != null) {
			// 장바구니에서 상품 삭제
			cart.removeProduct(prodNo);

			// 세션에 장바구니 정보 업데이트
			session.setAttribute("cart", cart);

			// 로그 추가
			System.out.println("장바구니에서 상품 " + prodNo + " 삭제됨");
		}

		// 장바구니 페이지로 리다이렉트
		response.sendRedirect(request.getContextPath() + "/ProductMarket?command=cart_list");
	}
}
