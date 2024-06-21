package com.kosa.mall.controller;

import java.io.IOException;

import com.kosa.mall.model.Action;
import com.kosa.mall.model.IndexAction;
import com.kosa.mall.model.ProductDetailAction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductMarket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");
		Action action = new IndexAction();

		if ("index".equals(command)) {
			action = new IndexAction();
		} else if ("product_detail".equals(command)) {
			action = new ProductDetailAction();
		}

		if (action != null) {
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
