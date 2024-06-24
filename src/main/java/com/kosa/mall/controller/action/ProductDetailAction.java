package com.kosa.mall.controller.action;

import java.io.IOException;

import com.kosa.mall.model.Product;
import com.kosa.mall.model.ProductDAO;

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
		request.setAttribute("productVO", productVO);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
