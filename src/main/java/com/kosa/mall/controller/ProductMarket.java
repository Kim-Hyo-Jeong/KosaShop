package com.kosa.mall.controller;

import java.io.IOException;

import com.kosa.mall.model.Action;
import com.kosa.mall.model.IndexAction;
import com.kosa.mall.model.LoginAction;
import com.kosa.mall.model.LoginFormAction;
import com.kosa.mall.model.LogoutAction;
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
        } else if ("login_form".equals(command)) {
            action = new LoginFormAction();
        } else if ("login".equals(command)) {
            action = new LoginAction();
        } else if ("logout".equals(command)) { // 추가: 로그아웃 처리
            action = new LogoutAction();
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
