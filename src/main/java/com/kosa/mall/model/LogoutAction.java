package com.kosa.mall.model;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false); // 세션이 없으면 새로 생성하지 않음
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        
        response.sendRedirect("index.html"); // 로그아웃 후 index.html 페이지로 리다이렉트
    }
}
