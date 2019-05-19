package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.pojo.Admin;
import com.java.service.IAdminService;
import com.java.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAdminService adminService=new AdminServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		PrintWriter out=response.getWriter();
		//System.out.println(action);
		//改变请求参数编码格式，tomcat的默认编码格式是ISO
		request.setCharacterEncoding("utf-8");
		//相应编码格式
		response.setContentType("text/html;charset=utf-8");
		//3获取action
		//4根据action的值判断调用相应方法
		if(action.equals("login")){
			//调用登录方法
			login(request,response);
		}else if (action.equals("logout")){
			logout(request,response);
		}else if (action.equals("update")){
			update(request,response);
		}
		
		
	}
	
	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		int id=Integer.parseInt(request.getParameter("id"));
		//获取用户名密码ID 为ADmin属性赋值
		Admin admin=new Admin();
		admin.setId(id);
		admin.setName(name);
		admin.setPwd(pwd);
		//调用修改方法
		int result=adminService.updateAdmin(admin);
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		
		//判断是否修改成功
		//若修改成功，注销session，跳转到登录界面
		if(result==1){
			
			session.removeAttribute("admin");
			out.write("<script>"+"alert('update successful');"
					+"window.parent.location.href='"+request.getContextPath()+"/admin/index.jsp'; "
						+"</script>");
		}
		//若果结果是-1，用户名已存在
		else if(result==-1){
			out.write("<script>"+"alert('the username alreadly existed;');"
					+"window.location.href='"+request.getContextPath()+"/admin/admin_update.jsp'; "
						+"</script>");
		}else{
			out.write("<script>"+"alert('update failedl');"
					+"window.location.href='"+request.getContextPath()+"/admin/admin_update.jsp'; "
						+"</script>");
		}
		//修改失败
		
		
		
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//清除session
		PrintWriter out=response.getWriter();
		//创建session
		HttpSession session=request.getSession();
		session.removeAttribute("admin");
		out.write("<script>"+"alert('logout successful');"
				+"window.parent.location.href='"+request.getContextPath()+"/admin/index.jsp'; "
					+"</script>");
	}
	
	
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.获取用户名及密码      2并与数据库信息3       比对判断是否登录成功
		//相应一个消息给前台
		PrintWriter out=response.getWriter();
		//创建session
		HttpSession session=request.getSession();
		System.out.println("login");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		
		Admin admin=adminService.login(name, pwd);
		out.print("");
		if(admin!=null){
			//把用户信息存在session中，让别的页面共享该数据
			session.setAttribute("admin", admin);
			out.print("<a href='request.getContextPath()'+'/admin/index.jsp'>main</a>");
			out.write("<script>"+"alert('success to login');"
					+"window.location.href='"+request.getContextPath()+"/admin/main.jsp'; "
						+"</script>");

			
		}else{
			out.write("<script>"+"alert('fail to login');"
					+"window.location.href='"+request.getContextPath()+"/admin/index.jsp'; "
						+"</script>");
		}
		
		
	}

}
