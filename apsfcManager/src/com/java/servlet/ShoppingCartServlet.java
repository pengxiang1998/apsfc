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

import com.java.pojo.Menus;
import com.java.pojo.ShoppingCart;
import com.java.pojo.User;
import com.java.service.IMenusService;
import com.java.service.impl.MenusServiceImpl;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/shoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMenusService service=new MenusServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=utf-8");
		String action=request.getParameter("action");
		if(action.equals("add")){
			addCart(request,response);
		}else if(action.equals("deletecart")){
			deleteCart(request,response);
		}else if(action.equals("del")){
			delete(request,response);
		}if(action.equals("findShopCart")){
			findShopCart(request,response);
		}
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void findShopCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		User user=(User) session.getAttribute("user");
		
		if(user!=null){
			out.write("<script>"+"alert('add order failed,check your account');"
					+"window.location.href='"+request.getContextPath()+"/qiantai/login.jsp;'"
						+"</script>");
			//session.setAttribute("shoppingCart",cartList);
			response.sendRedirect(request.getContextPath()+"/qiantai/shoppingcar.jsp");
		}else{
			out.write("<script>"+"alert('add order failed,check your account');"
					+"window.location.href='"+request.getContextPath()+"/qiantai/login.jsp;'"
						+"</script>");
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//获取菜品ID
		HttpSession session=request.getSession();
		//1.get the id of dishes
		int menuid=Integer.parseInt(request.getParameter("menuid"));
		//2.get the cart
		ArrayList<ShoppingCart> cartList=(ArrayList<ShoppingCart>) session.getAttribute("shoppingCart");

		//获取购物车
		for(ShoppingCart shoppingCart:cartList){
			//4.判断id是否存在
				if(shoppingCart.getMenuid()==menuid){
					cartList.remove(shoppingCart);
					break;
				}
			}

		//循环遍历购物车
		//判断id是否存在
		//取消购物车
		response.sendRedirect(request.getContextPath()+"/qiantai/index.jsp");
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	
	private void deleteCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.removeAttribute("shoppingCart");
		response.sendRedirect(request.getContextPath()+"/qiantai/index.jsp");
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	
	private void addCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int menuid=Integer.parseInt(request.getParameter("menuid"));
		//获取购物车
		HttpSession session=request.getSession();
		//判断是否有该购物车
		ArrayList<ShoppingCart> cartList=(ArrayList<ShoppingCart>) session.getAttribute("shoppingCart");
		boolean flag=false;
		//如果没有,创建新的购物车
		if(cartList==null){
			//创建一个购物车
			cartList=new ArrayList<ShoppingCart>();
			
		}else{
			for(ShoppingCart cart:cartList){
				if(cart.getMenuid()==menuid){
					//数量加一
					cart.setSum(cart.getSum()+1);
					flag=true;
					break;
				}
			}
		}
		//如果有，数量加一
		
		//如果没有购物车，创建购物车实例
		if(!flag)
		{
			ShoppingCart cart=new ShoppingCart();
			//根据菜品ID查询
			Menus menus=service.getMenusByID(menuid);
			//添加菜品id
			cart.setMenuid(menuid);
			//菜品名称
			cart.setName(menus.getName());
			//单价
			cart.setPrice(Float.parseFloat(menus.getPrice()));
			cart.setSum(1);
			//把购物车信息放到list中
			cartList.add(cart);
			
		}
		//购物车信息加入session
		session.setAttribute("shoppingCart", cartList);
		//请求重定向
		response.sendRedirect(request.getContextPath()+"/qiantai/index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
