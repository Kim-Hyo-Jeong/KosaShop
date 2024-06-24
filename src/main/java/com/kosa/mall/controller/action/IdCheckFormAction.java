package com.kosa.mall.controller.action;

import java.io.IOException;

import com.kosa.mall.dao.MemberDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/idcheck.jsp";

		String id = request.getParameter("id").trim();

		MemberDAO memberDAO = MemberDAO.getInstance();
		int message = memberDAO.confirmID(id);

		request.setAttribute("message", message);
		request.setAttribute("id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
