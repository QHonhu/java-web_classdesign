package com.lzw.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzw.web.dao.impl.JdbcDaoImplBuyer;
import com.lzw.web.meta.User;
import com.lzw.web.utils.MD5andKL;
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String piccode = (String) req.getSession().getAttribute("piccode");
		String piccode = (String) req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String chechcode = req.getParameter("checkcode");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		password = MD5andKL.MD5(password);
//		chechcode = chechcode.toUpperCase();
		PrintWriter out = resp.getWriter();
		JdbcDaoImplBuyer jdib = new JdbcDaoImplBuyer(); 
		System.out.println(chechcode);
		System.out.println(piccode);
		User user = null; 
		HttpSession session =req.getSession();
		session.setMaxInactiveInterval(5*60);
		String message = null;
		if (chechcode.equals(piccode))
		{
			if (jdib.isUserName(username))
			{
				if (jdib.isUserPassword(password))
				{
					JdbcDaoImplBuyer j = new JdbcDaoImplBuyer();
					user = j.getUserInfoByUserName(username);
					if(user.getUserType()==1)
					{
						user.setSell(true);
					}
					session.setAttribute("user", user);
					session.setAttribute("productlist", new JdbcDaoImplBuyer().getMerchandiseList(user.getId()));
					req.getRequestDispatcher("./index.jsp").forward(req, resp);
				}
				else
					message = "密码错误";
				
			}
			else
				message = "用户不存在";
		}
		else
		{
			message="验证码不正确";
		}
		session.setAttribute("message", message);
		req.getRequestDispatcher("./publicSubmit.jsp").forward(req, resp);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
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
