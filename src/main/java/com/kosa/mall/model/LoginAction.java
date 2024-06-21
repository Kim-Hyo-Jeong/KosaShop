package com.kosa.mall.model;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url="member/login_fail.jsp";
    HttpSession session=request.getSession();
  
    String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
    
    MemberDAO memberDAO=MemberDAO.getInstance();
      
    Member member=memberDAO.getMember(id);
    
    if(member!=null){
      if(member.getPwd().equals(pwd)){    
        session.removeAttribute("id");
        session.setAttribute("loginUser", member);
        url="ProductMarket?command=index";
      }
    }
    
    request.getRequestDispatcher(url).forward(request, response);  
  }
}