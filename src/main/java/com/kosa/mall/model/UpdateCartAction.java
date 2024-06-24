package com.kosa.mall.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UpdateCartAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("cart") == null) {
            // 장바구니가 비어있거나 세션이 만료된 경우 처리
            response.sendRedirect("ProductMarket?command=cart_list");
            return;
        }

        String prodNo = request.getParameter("prodNo");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Cart cart = (Cart) session.getAttribute("cart");
        cart.updateQuantity(prodNo, quantity);

        // Send success response
        response.setStatus(HttpServletResponse.SC_OK);
    }
}