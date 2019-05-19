package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.service.IOrderStaticService;
import com.java.service.impl.IOrderStaticServiceImpl;
import com.java.util.Page;

/**
 * Servlet implementation class OrderStaticServlet
 */
@WebServlet("/orderStaticServlet")
public class OrderStaticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     IOrderStaticService orderService=new IOrderStaticServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStaticServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		if(action.equals("findOrder")){
			findOrder(request,response);
		}
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	private void findOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String curPage=request.getParameter("curPage");
		int curpagestr=0;
		if(curPage==null||"".equals(curPage)){
			curpagestr=1;
		}else{
			curpagestr=Integer.parseInt(curPage);
		}
		//把当前页码赋值给Page的curpage属性
		Page page=new Page();
		page.setCurPage(curpagestr);
		//调用Service分页查询方法
		page=orderService.getOrderAll(page);
		//request绑定查询结果
		request.setAttribute("page", page);
		//请求转发
		request.getRequestDispatcher("/admin/order_statistic.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
