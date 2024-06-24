package com.kosa.mall.controller.action;

import java.io.IOException;

import com.kosa.mall.dao.MemberDAO;
import com.kosa.mall.dto.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegisterAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        MemberVO member = new MemberVO();

        member.setId(request.getParameter("id"));
        member.setPwd(request.getParameter("pwd"));
        member.setName(request.getParameter("name"));
        member.setEmail(request.getParameter("email"));
        member.setZipNum(request.getParameter("zipNum"));
        member.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));
        member.setPhone(request.getParameter("phone"));

        session.setAttribute("id", request.getParameter("id"));

        MemberDAO memberDAO = MemberDAO.getInstance();
        int result = memberDAO.insertMember(member);

        if (result == 1) {
            // 회원가입 성공 시 메인 페이지로 리다이렉션
            response.sendRedirect("index.jsp");
        } else {
            // 회원가입 실패 시 예외 처리
            response.sendRedirect("error.jsp");
        }
    }
}
