package com.kosa.mall.controller.action;

import com.kosa.mall.dao.CartDAO;
import com.kosa.mall.dto.CartVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

public class UpdateCartAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        CartDAO cart = (CartDAO) session.getAttribute("cart");

        if (cart == null) {
            cart = new CartDAO();
            session.setAttribute("cart", cart);
        }

        String prodNo = request.getParameter("prodNo");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        CartVO item = cart.getItems().get(prodNo);
        if (item != null) {
            item.setQuantity(quantity);
        }

        double newTotalPrice = item.getProdPrice() * quantity;
        double totalAmount = calculateTotalAmount(cart.getItems());

        // JSON으로 응답
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Map<String, Double> responseData = Map.of(
            "newTotalPrice", newTotalPrice,
            "totalAmount", totalAmount
        );

        Gson gson = new Gson();
        String jsonResponse = gson.toJson(responseData);
        response.getWriter().write(jsonResponse);
    }

    private double calculateTotalAmount(Map<String, CartVO> cartItems) {
        double total = 0.0;
        for (CartVO item : cartItems.values()) {
            total += item.getProdPrice() * item.getQuantity();
        }
        return total;
    }
}
