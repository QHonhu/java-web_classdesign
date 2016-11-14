package com.lzw.web.page.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzw.web.page.Constant;
import com.lzw.web.page.model.Pager;
import com.lzw.web.page.model.Student;
import com.lzw.web.page.service.JdbcSqlStudentServiceImpl;
import com.lzw.web.page.service.StudentService;
import com.lzw.web.page.util.StringUtil;

public class JdbcSqlServlet extends HttpServlet {
	
	private static final long serialVersionUID = -318134993070614515L;
	
	private StudentService studentService = new JdbcSqlStudentServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收request里的参数
		String stuName = request.getParameter("stuName"); //学生姓名
		
		// 获取学生性别
		int gender = Constant.DEFAULT_GENDER;
		String genderStr = request.getParameter("gender");
		if(genderStr!=null && !"".equals(genderStr.trim())){
			gender = Integer.parseInt(genderStr);
		}
		
		// 校验pageNum参数输入合法性
		String pageNumStr = request.getParameter("pageNum"); 
		if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
			request.setAttribute("errorMsg", "参数传输错误");
			request.getRequestDispatcher("jdbcSqlStudent.jsp").forward(request, response);
			return;
		}
		
		int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		// 组装查询条件
		Student searchModel = new Student(); 
		searchModel.setStuName(stuName);
		searchModel.setGender(gender);
		
		//调用service 获取查询结果
		Pager<Student> result = studentService.findStudent(searchModel, 
																pageNum, pageSize);
		
		// 返回结果到页面
		request.setAttribute("result", result);
		request.setAttribute("stuName", stuName);
		request.setAttribute("gender", gender);
		
		request.getRequestDispatcher("/sublist/sublistStudent.jsp").forward(request, response);
	}

}


