package com.lzw.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzw.web.dao.impl.JdbcDaoImplBuyer;
import com.lzw.web.meta.User;
@WebServlet("/index")
public class Index extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("productlist", new JdbcDaoImplBuyer().getMerchandiseList(-8));
		if(session.getAttribute("user") != null)
		{
			if(((User)(session.getAttribute("user"))).getUserType()==0 || ((User)(session.getAttribute("user"))).getUserType()==1 )
				session.setAttribute("productlist", new JdbcDaoImplBuyer().getMerchandiseList(((User)(session.getAttribute("user"))).getId()));
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
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
