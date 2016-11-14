package com.lzw.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzw.web.dao.impl.JdbcDaoImplBuyer;
import com.lzw.web.meta.User;
import com.lzw.web.utils.MD5andKL;

public class RegisteredServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("user");
		String password = req.getParameter("passwd");
		String phone = req.getParameter("phine");
		password = MD5andKL.MD5(password);
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setPhone(phone);
		JdbcDaoImplBuyer jdib = new JdbcDaoImplBuyer();
		if(jdib.isAddUser(u))
		{
			out.println("注册成功");
		}
		else
		{
			out.println("注册失败");
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
