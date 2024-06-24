package com.kosa.mall.controller;

import java.io.IOException;
import com.kosa.mall.model.Action;
import com.kosa.mall.model.AddToCartAction;
import com.kosa.mall.model.CartListAction;
import com.kosa.mall.model.IndexAction;
import com.kosa.mall.model.LoginAction;
import com.kosa.mall.model.LoginFormAction;
import com.kosa.mall.model.LogoutAction;
import com.kosa.mall.model.ProductDetailAction;
import com.kosa.mall.model.RemoveFromCartAction;
import com.kosa.mall.model.UpdateCartAction;

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
        } else if ("logout".equals(command)) {
            action = new LogoutAction();
        } else if ("product_detail".equals(command)) {
            action = new ProductDetailAction();
        } else if ("add_to_cart".equals(command)) {
            action = new AddToCartAction();
        } else if ("cart_list".equals(command)) {
            action = new CartListAction();
        } else if ("update_cart".equals(command)) {
            action = new UpdateCartAction();
        } else if ("remove_from_cart".equals(command)) {
            action = new RemoveFromCartAction();
        }

        if (action != null) {
            action.execute(request, response);
        }
        
        // 캐시 제어
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
