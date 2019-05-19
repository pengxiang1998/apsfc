package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.pojo.Orders;
import com.java.pojo.ShoppingCart;
import com.java.pojo.Types;
import com.java.pojo.User;
import com.java.service.IOrderService;
import com.java.service.impl.OrdersServiceImpl;
import com.java.util.Page;
import com.java.util.Page1;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/ordersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		if(action.equals("addOrder")){
			addOrder(request,response);
		}if(action.equals("findAll")){
			findOrdersAll(request,response);
		}if(action.equals("orderSearch")){
			orderSearch(request,response);
		}if(action.equals("orderSearch1")){
			orderSearch1(request,response);
		}if(action.equals("orderSearch2")){
			orderSearch2(request,response);
		}if(action.equals("orderSearch3")){
			orderSearch3(request,response);
		}if(action.equals("deleteOrder")){
			deleteOrder(request,response);
		}if(action.equals("updateDelivery")){
			updateDelivery(request,response);
		}
	}

	private void updateDelivery(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		Orders orders=new Orders();
		orders.setId(id);
		int result=orderService.updateDelivery(id);
		if(result==1){
			out.write("<script>"+"alert('update Delivery successful');"
					+"window.location.href='"+request.getContextPath()+"/ordersServlet?action=findAll'; "
						+"</script>");
		}else if(result==-1){
			out.write("<script>"+"alert('the type existed');"
					+"window.location.href='"+request.getContextPath()+"/ordersServlet?action=findAll'; "
						+"</script>");
		}else{
			out.write("<script>"+"alert('update failed');"
					+"window.location.href='"+request.getContextPath()+"/ordersServlet?action=findAll'; "
						+"</script>");
		}
		
	}

	private void deleteOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		Orders orders=new Orders();
		orders.setId(id);
		int result=orderService.deleteOrder(id);
		if(result==1){
			out.write("<script>"+"alert('delete successful');"
					+"window.location.href='"+request.getContextPath()+"/ordersServlet?action=findAll'; "
						+"</script>");
		}else if(result==0){
			out.write("<script>"+"alert('delete failed');"
					+"window.location.href='"+request.getContextPath()+"/ordersServlet?action=findAll'; "
						+"</script>");
		}
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	
	

	private void orderSearch3(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String curPage=request.getParameter("curPage");
		HttpSession session=request.getSession();
		String  username=request.getParameter("username");
		String menuname=request.getParameter("menuname");
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
		page=orderService.getOrderByMenuName(page, username, menuname);
		//request绑定查询结果
		request.setAttribute("page", page);
		//请求转发
		request.getRequestDispatcher("/qiantai/order.jsp").forward(request, response);
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	private void orderSearch2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String curPage=request.getParameter("curPage");
		HttpSession session=request.getSession();
		String  username=request.getParameter("username");
		
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
		page=orderService.getOrderByID(page, username);
		//request绑定查询结果
		request.setAttribute("page", page);
		//请求转发
		request.getRequestDispatcher("/admin/order_search.jsp").forward(request, response);
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	private void orderSearch1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String curPage=request.getParameter("curPage");
		HttpSession session=request.getSession();
		String  username=request.getParameter("username");
		
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
		page=orderService.getOrderByID(page, username);
		//request绑定查询结果
		request.setAttribute("page", page);
		//请求转发
		request.getRequestDispatcher("/qiantai/order.jsp").forward(request, response);
		
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	private void orderSearch(HttpServletRequest request,
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
		request.getRequestDispatcher("/admin/order_search.jsp").forward(request, response);
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	private void findOrdersAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			//获取当前页码
			String curPage=request.getParameter("curPage");
			int curpagestr=0;
			if(curPage==null||"".equals(curPage)){
				curpagestr=1;
			}else{
				curpagestr=Integer.parseInt(curPage);
			}
			//把当前页码赋值给Page的curpage属性
			Page1 page=new Page1();
			page.setCurPage(curpagestr);
			//调用Service分页查询方法
			page=orderService.getOrderAll1(page);
			//request绑定查询结果
			request.setAttribute("page", page);
			//请求转发
			request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	IOrderService orderService=new OrdersServiceImpl();
	private void addOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		User user=(User) session.getAttribute("user");
		if(user!=null){
			//用户登陆后才能获取购物车
			ArrayList<ShoppingCart> cartList=(ArrayList<ShoppingCart>) session.getAttribute("shoppingCart");
			boolean result;
			try {
				result=orderService.addOrders(cartList, user.getId());
				if(result){
					//此时已将购物车加入订单
					session.removeAttribute("shoppingCart");
					out.write("<script>"+"alert('下单成功,请在我的订单中查询！');"
							+"window.location.href='"+request.getContextPath()+"/qiantai/index.jsp;'"
								+"</script>");
					
				}else{
					out.write("<script>"+"alert('add order failed,check your account');"
							+"window.location.href='"+request.getContextPath()+"/qiantai/index.jsp;'"
								+"</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			out.write("<script>"+"alert('please login your account');"
					+"window.location.href='"+request.getContextPath()+"/qiantai/login.jsp;'"
						+"</script>");
		}
		
	}

}
