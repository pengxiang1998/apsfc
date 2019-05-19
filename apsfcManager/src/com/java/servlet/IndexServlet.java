package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.pojo.Menus;
import com.java.pojo.Notice;
import com.java.pojo.Types;
import com.java.service.IMenusService;
import com.java.service.INoticeService;
import com.java.service.IOrderStaticService;
import com.java.service.impl.IOrderStaticServiceImpl;
import com.java.service.impl.MenusServiceImpl;
import com.java.service.impl.NoticeServiceImpl;
import com.java.util.Page;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMenusService menusService=new MenusServiceImpl(); 
	INoticeService noticeService=new NoticeServiceImpl(); 
	IOrderStaticService orderService=new IOrderStaticServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		if(action.equals("findAll")){
			findMenusAll(request,response);
		}else if(action.equals("findNotice")){
			findNotice(request,response);
		}else if(action.equals("findMenus")){
			findMenus(request,response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void findMenus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		Menus menus=menusService.getMenusByID(id);
		request.setAttribute("menus", menus);
		request.getRequestDispatcher("/qiantai/show.jsp").forward(request, response);
	}
	protected void findNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		Notice notice=noticeService.getNoticeById(id);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/qiantai/notice.jsp").forward(request, response);
	}

	private void findMenusAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取当前页码
		String curPage=request.getParameter("curPage");
		int curpagestr=0;
		List<Notice> list=noticeService.getNoticeAll();

		if(curPage==null||"".equals(curPage)){
			curpagestr=1;
		}else{
			curpagestr=Integer.parseInt(curPage);
		}
		//把当前页码赋值给Page的curpage属性
		Page page=new Page();
		page.setCurPage(curpagestr);
		//调用Service分页查询方法
		page=menusService.getMenusAll(page);
		Page page1=new Page();
		page1.setCurPage(curpagestr);
		page1=orderService.getOrderAll(page1);
		request.setAttribute("page1", page1);
		
		//request绑定查询结果
		request.setAttribute("page", page);
		//请求转发
		request.setAttribute("notice",list);

		request.getRequestDispatcher("/qiantai/index.jsp").forward(request, response);
	}

}
