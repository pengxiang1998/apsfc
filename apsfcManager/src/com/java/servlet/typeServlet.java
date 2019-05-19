package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.pojo.Types;
import com.java.service.IAdminService;
import com.java.service.ITypeSrevice;
import com.java.service.impl.ITypeServiceImpl;

/**
 * Servlet implementation class typeServlet
 */
@WebServlet("/typeServlet")
public class typeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ITypeSrevice typesService=new ITypeServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public typeServlet() {
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
			System.out.print(action);
			findAll(request,response);
		}else if(action.equals("add")){
			add(request,response);
		}else if(action.equals("findById")){
			findByID(request,response);
		}else if(action.equals("update")){
			update(request,response);
		}else if(action.equals("delete")){
			delete(request,response);
		}
		
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
		Types types=new Types();
		types.setId(id);
		int result=typesService.deleteTypes(id);
		if(result==1){
			out.write("<script>"+"alert('delete successful');"
					+"window.location.href='"+request.getContextPath()+"/typeServlet?action=findAll'; "
						+"</script>");
		}else if(result==0){
			out.write("<script>"+"alert('delete failed');"
					+"window.location.href='"+request.getContextPath()+"/typeServlet?action=findAll'; "
						+"</script>");
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
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		Types types=new Types();
		types.setId(id);
		types.setName(name);
		int result=typesService.updateTypes(types);
		if(result==1){
			out.write("<script>"+"alert('update type successful');"
					+"window.location.href='"+request.getContextPath()+"/typeServlet?action=findAll'; "
						+"</script>");
		}else if(result==-1){
			out.write("<script>"+"alert('the type existed');"
					+"window.location.href='"+request.getContextPath()+"/admin/type_update.jsp'; "
						+"</script>");
		}else{
			out.write("<script>"+"alert('update failed');"
					+"window.location.href='"+request.getContextPath()+"/admin/type_update.jsp'; "
						+"</script>");
		}
		
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	private void findByID(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		Types type=typesService.getTypesById(id);
		request.setAttribute("type",type);
		request.getRequestDispatcher("/admin/type_update.jsp").forward(request, response);
		
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//1获取类别名称
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		//给types实体类的name赋值
		System.out.println(name);
		Types types=new Types();
		types.setName(name);
		//调用添加方法
		int result=typesService.addTypes(types);
		if(result==1){
			out.write("<script>"+"alert('add successful');"
					+"window.location.href='"+request.getContextPath()+"/typeServlet?action=findAll'; "
						+"</script>");
		}else if(result==-1){
			out.write("<script>"+"alert('the type existed');"
					+"window.location.href='"+request.getContextPath()+"/admin/type_add.jsp'; "
						+"</script>");
		}else{
			out.write("<script>"+"alert('add failed');"
					+"window.location.href='"+request.getContextPath()+"/admin/type_add.jsp'; "
						+"</script>");
		}
		//判读是否成功
		
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			//1.调用Service查询所有类别方法
		List<Types> list=typesService.getTypesAll();
		
		//2.将查询结果保存在request域对象中
		request.setAttribute("types",list);
		request.getRequestDispatcher("/admin/type.jsp").forward(request, response);
		//request.getRequestDispatcher("/admin/type.jsp").forward(request,response);
		//3.请求转发给前台页面
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
