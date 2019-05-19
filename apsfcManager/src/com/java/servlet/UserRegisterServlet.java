package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.pojo.User;
import com.java.service.IUserService;
import com.java.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  IUserService userService=new UserServiceImpl();
    
    public UserRegisterServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String realname=request.getParameter("realname");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String card=request.getParameter("card");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String code=request.getParameter("code");
		
		
		User user=new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setRealname(realname);
		user.setSex(sex);
		user.setAge(age);
		user.setCard(card);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setCode(code);
		user.setType("1");
		int result=userService.register(user) ;
		
		if(result==1){
		 out.print("<script>"
					+ "alert('注册成功！');"
					+ "window.location.href='" + request.getContextPath() + "/qiantai/login.jsp';"
					+ "</script>");
		}else{
			out.print("<script>"
					+ "alert('注册失败，请重新注册!');"
					+ "window.location.href='" + request.getContextPath() + "/qiantai/reg.jsp';"
					+ "</script>");
		}	
	}
   
   
	
    	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
