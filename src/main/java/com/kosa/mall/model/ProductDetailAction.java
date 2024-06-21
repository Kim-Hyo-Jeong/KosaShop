package com.kosa.mall.model;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductDetailAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "product/productDetail.jsp";
        String pseq = request.getParameter("prod_no").trim();

        ProductDAO productDAO = new ProductDAO();
        Product productVO = productDAO.getProduct(pseq);
        if (productVO == null) {
            System.out.println("Product not found for prodNo: " + pseq);
            // Handle the case where the product is not found
            url = "product/notFound.jsp"; // or another appropriate page
        } else {
            request.setAttribute("productVO", productVO);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
