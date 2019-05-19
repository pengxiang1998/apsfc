package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.pojo.Notice;
import com.java.pojo.Types;
import com.java.service.INoticeService;
import com.java.service.ITypeSrevice;
import com.java.service.impl.ITypeServiceImpl;
import com.java.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/noticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 INoticeService noticeService=new NoticeServiceImpl();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
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
		System.out.println(action);
		if(action.equals("findAll")){
			findAll(request,response);
		}else if(action.equals("delete")){
			delete(request,response);
		}else if(action.equals("add")){
			System.out.println(action);
			add(request,response);
		}
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String content=request.getParameter("content");
		//给types实体类的name赋值
		System.out.println(name);
		Notice notice=new Notice();
		notice.setName(name);
		notice.setContent(content);
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=df.format(new Date());
		notice.setTimes(time);
		//调用添加方法
		int result=noticeService.addNotice(notice);
		if(result==1){
			out.write("<script>"+"alert('add successful');"
					+"window.location.href='"+request.getContextPath()+"/noticeServlet?action=findAll'; "
						+"</script>");
		}else if(result==-1){
			out.write("<script>"+"alert('the type existed');"
					+"window.location.href='"+request.getContextPath()+"/admin/notice_add.jsp'; "
						+"</script>");
		}else{
			out.write("<script>"+"alert('add failed');"
					+"window.location.href='"+request.getContextPath()+"/admin/notice_add.jsp'; "
						+"</script>");
		}
		//判读是否成功
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		Notice notice=new Notice();
		notice.setId(id);
		int result=noticeService.deleteNotice(id);
		if(result==1){
			out.write("<script>"+"alert('delete successful');"
					+"window.location.href='"+request.getContextPath()+"/noticeServlet?action=findAll'; "
						+"</script>");
		}else if(result==0){
			out.write("<script>"+"alert('delete failed');"
					+"window.location.href='"+request.getContextPath()+"/noticeServlet?action=findAll'; "
						+"</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		if(action.equals("add")){
			System.out.println(action);
			add(request,response);
		}
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Notice> list=noticeService.getNoticeAll();
		
		//2.将查询结果保存在request域对象中
		request.setAttribute("notices",list);
		request.getRequestDispatcher("/admin/notice.jsp").forward(request, response);
	}

}
