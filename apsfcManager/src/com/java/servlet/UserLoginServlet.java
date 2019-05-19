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
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      IUserService userService=new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		if(action.equals("login")){
			login(request, response);
		}else if(action.equals("logout")){
			logout(request, response);
		}else if(action.equals("update")){
			updateUser(request,response);
		}


	}
	
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		User  users= (User) session.getAttribute("user");
		   int id=users.getId();
		   String name=users.getName();
		   String pwd=request.getParameter("pwd");
		   String realname=request.getParameter("realname");
		   String sex=request.getParameter("sex");
		   String age=request.getParameter("age");
		   String card=request.getParameter("card");
		   String address=request.getParameter("address");
		   String phone=request.getParameter("phone");
		   String email=request.getParameter("email");
		   String code=request.getParameter("code");
		   User user=new User(id, name, pwd, realname, sex, age, card, address, phone, email, code);
		   int result=userService.updateUser(user);
			   if(result==1){
					  out.write("<script>"
								+"alert('修改成功');"
								+"window.location.href='"+request.getContextPath()+"/qiantai/index.jsp';"
								+ "</script>");
				  }else{
					  if(result==-1){
						  out.write("<script>"
									+"alert('类别名已存在');"
									+"window.location.href='"+request.getContextPath()+"/qiantai/center.jsp';"
									+ "</script>");
					  }else{
						  out.write("<script>"
									+"alert('修改失败');"
									+"window.location.href='"+request.getContextPath()+"/qiantai/center.jsp';"
									+ "</script>");
					  }
				  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//登录
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//创建session
		HttpSession session=request.getSession();
		//清除session
		session.removeAttribute("user");
		//跳转到index页面
		out.write("<script>"
				+"alert('注销成功！');"
				+"window.parent.location.href='"
				+request.getContextPath()+"/qiantai/login.jsp';"
				+"</script>");
		} 

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		User user=userService.login(name, pwd);
		String mgs="";
		if(user!=null){
		 session.setAttribute("user", user);
		 out.print("<script>"
					+ "alert('登录成功！');"
					+ "window.location.href='" + request.getContextPath() + "/qiantai/index.jsp';"
					+ "</script>");
		}else{
			out.print("<script>"
					+ "alert('登录失败，请检查用户名或密码!');"
					+ "window.location.href='" + request.getContextPath() + "/qiantai/login.jsp';"
					+ "</script>");
		}	
	}
	
	
}
