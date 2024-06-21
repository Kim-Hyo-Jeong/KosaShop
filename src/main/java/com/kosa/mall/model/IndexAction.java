package com.kosa.mall.model;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.jsp";
		int page = 1;
		int pageSize = 4;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}

		ProductDAO productDAO;
		productDAO = new ProductDAO();
		ArrayList<Product> prodList = productDAO.listNewProduct(page, pageSize);
		int totalProducts = productDAO.getTotalProducts();
		int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

		request.setAttribute("newProductList", prodList);
		request.setAttribute("currentPage", page);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalPages", totalPages);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}