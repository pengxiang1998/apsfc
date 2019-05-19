package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.awt.RepaintArea;

import com.java.pojo.Menus;
import com.java.pojo.Types;
import com.java.service.IAdminService;
import com.java.service.IMenusService;
import com.java.service.ITypeSrevice;
import com.java.service.impl.ITypeServiceImpl;
import com.java.service.impl.MenusServiceImpl;
import com.java.util.Page;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class MenusServlet
 */
@WebServlet("/menusServlet")
public class MenusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     IMenusService menusService=new MenusServiceImpl(); 
     ITypeSrevice typesService=new ITypeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenusServlet() {
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
		}else if(action.equals("delete")){
			deleteMenus(request,response);
		}else if(action.equals("findTypesAll")){
			findTypesAll(request,response);
		}else if(action.equals("add")){
			addMenus(request,response);
		}else if(action.equals("update")){
			update(request,response);
		}else if(action.equals("findTypesAll1")){
			findTypesAll1(request,response);
		}else if(action.equals("findID")){
			findMenuByID(request,response);
		}
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	private void findMenuByID(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		Menus menus=menusService.getMenusByID(id);
		request.setAttribute("menus", menus);
		List<Types> types=typesService.getTypesAll();
		request.setAttribute("types", types);
		request.getRequestDispatcher("/admin/menus_update.jsp").forward(request, response);

		
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
		//String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String burden = request.getParameter("burden");
		String price = request.getParameter("price");
		String price1 =request.getParameter("price1");
		String brief = request.getParameter("brief");
		String typeid = request.getParameter("typeid");
		Menus menus=new Menus();
		menus.setId(id);
		menus.setName(name);
		menus.setBurden(burden);
		menus.setBrief(brief);
		menus.setPrice(price1);
		menus.setPrice1(price1);
		menus.setTypeid(typeid);//未获得
		//menus.setName(name);
		int result=menusService.updateMenus(menus);
		if(result==1){
			out.write("<script>"+"alert('update menus successful');"
					+"window.location.href='"+request.getContextPath()+"/menusServlet?action=findAll&&curPage=1'; "
						+"</script>");
		}else if(result==-1){
			out.write("<script>"+"alert('the menus existed');"
					+"window.location.href='"+request.getContextPath()+"//menusServlet?action=findID'; "
						+"</script>");
		}else{
			out.write("<script>"+"alert('update failed');"
					+"window.location.href='"+request.getContextPath()+"//menusServlet?action=findID'; "
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
	
	private void findTypesAll1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Types> types=typesService.getTypesAll();
		request.setAttribute("types", types);
		request.getRequestDispatcher("/admin/menus_update.jsp").forward(request,response);
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws SmartUploadException 
	 */
	
	private void addMenus(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//创建SmartUpLoad对象
		SmartUpload smartUpload=new SmartUpload();
		//执行上传初始化
		smartUpload.initialize(this.getServletConfig(),request, response);
		try {
			//执行上传
			smartUpload.upload();
			//4获取用户输入的菜品信息
			//注意：在使用了该插件后，要这样获取数据
			String name = smartUpload.getRequest().getParameter("name");
			String burden = smartUpload.getRequest().getParameter("burden");
			String price = smartUpload.getRequest().getParameter("price");
			String price1 = smartUpload.getRequest().getParameter("price1");
			String brief = smartUpload.getRequest().getParameter("brief");
			String typeid = smartUpload.getRequest().getParameter("typeid");
			//获取上传的文件对象
			SmartFile file = smartUpload.getFiles().getFile(0);//获取第一个文件，因为只能上传一个文件
			//获取上传文件的名称
			String imgpath = "img/" + file.getFilePathName();
			//对Menus对象赋值
			Menus menus = new Menus(name, typeid, burden, brief, price, price1, imgpath);
			int result = menusService.addMenus(menus);
			if (result == 1) {
				//保存上传文件
				smartUpload.save("/img");
				out.write("<script>" + "alert('add menus successful');"
						+ "window.location.href='" + request.getContextPath()
						+ "/menusServlet?action=findAll'; " + "</script>");
			} else if (result == -1) {
				out.write("<script>" + "alert('the menus existed');"
						+ "window.location.href='" + request.getContextPath()
						+ "/admin/menus_add.jsp'; " + "</script>");
			} else {
				out.write("<script>" + "alert('add failed');"
						+ "window.location.href='" + request.getContextPath()
						+ "/admin/menus_add.jsp'; " + "</script>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	/** 
	 * 方法描述：
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void findTypesAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		List<Types> types=typesService.getTypesAll();
		request.setAttribute("types", types);
		request.getRequestDispatcher("/admin/menus_add.jsp").forward(request,response);
	}
	private void deleteMenus(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		//int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		//System.out.print(id);
		Types types=new Types();
		//types.setId(id);
		int result=menusService.deleteMenus(name);
		if(result==1){
			out.write("<script>"+"alert('delete successful');"
					+"window.location.href='"+request.getContextPath()+"/menusServlet?action=findAll'; "
						+"</script>");
		}else if(result==0){
			out.write("<script>"+"alert('delete failed');"
					+"window.location.href='"+request.getContextPath()+"/menusServlet?action=findAll'; "
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
	
	private void findMenusAll(HttpServletRequest request,
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
		Page page=new Page();
		page.setCurPage(curpagestr);
		//调用Service分页查询方法
		page=menusService.getMenusAll(page);
		//request绑定查询结果
		request.setAttribute("page", page);
		//请求转发
		request.getRequestDispatcher("/admin/menus.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
