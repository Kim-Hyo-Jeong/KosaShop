package com.kosa.mall.controller.action;

import java.io.IOException;
import java.util.Map;

import com.kosa.mall.dao.CartDAO;
import com.kosa.mall.dto.CartVO;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartListAction implements Action {

	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 세션에서 장바구니 정보 가져오기
        HttpSession session = request.getSession(false);
        if (session != null) {
            CartDAO cart = (CartDAO) session.getAttribute("cart");
            if (cart != null) {
                Map<String, CartVO> cartItems = cart.getItems();
                double totalAmount = calculateTotalAmount(cartItems); // 총 금액 계산
                
                request.setAttribute("cartItems", cartItems);
                request.setAttribute("totalAmount", totalAmount);
            }
        }
        
        // cart_list.jsp로 포워드
        request.getRequestDispatcher("/cart_list.jsp").forward(request, response);
    }
	
	private double calculateTotalAmount(Map<String, CartVO> cartItems) {
        double total = 0.0;

        for (CartVO item : cartItems.values()) {
            total += item.getProdPrice() * item.getQuantity();
        }

        return total;
    }
}