package com.lzw.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin")
public class Administrator extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("password"));
		if("admin".equals(req.getParameter("username"))&&"administrator".equals(req.getParameter("password")))
			req.getRequestDispatcher("/WEB-INF/adminindex.jsp").forward(req, resp);
		else
		{
			out.println("登录失败");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("password"));
		if("admin".equals(req.getParameter("username"))&&"administrator".equals(req.getParameter("password")))
			req.getRequestDispatcher("/WEB-INF/adminindex.jsp").forward(req, resp);
		else
		{
			out.println("登录失败");
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
}
