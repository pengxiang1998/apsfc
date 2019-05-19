package com.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.pojo.Description;
import com.java.pojo.Send;
import com.java.pojo.Types;
import com.java.service.IDescriptionService;

import com.java.service.impl.DescriptionServiceImpl;


/**
 * Servlet implementation class DescriptionServlet
 */
@WebServlet("/descriptionServlet")
public class DescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IDescriptionService desService =new  DescriptionServiceImpl();
	IDescriptionService sendService=new DescriptionServiceImpl();
   
    public DescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action =request.getParameter("action");
		if(action.equals("findDesAll")){
			findDesAll(request,response);
		}else if(action.equals("sendFindAll")){
			sendFindAll(request, response);
		}
		
	}
	//
	protected void sendFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Send> send=sendService.sendFindAll();
		request.setAttribute("send", send);
		request.getRequestDispatcher("/qiantai/carry.jsp").forward(request, response);
	}
     
    protected void findDesAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Description> des=desService.desFindAll();
		request.setAttribute("des", des);
		request.getRequestDispatcher("/qiantai/our.jsp").forward(request , response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
