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
@WebServlet("/show")
public class Show extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		HttpSession session = req.getSession();
		if(((User)(session.getAttribute("user")))!=null)
			session.setAttribute("products", new JdbcDaoImplBuyer().getMerchandiseInfoById(id,((User)(session.getAttribute("user"))).getId()));
		else
			session.setAttribute("products", new JdbcDaoImplBuyer().getMerchandiseInfoById(id,1));
		req.getRequestDispatcher("show.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
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
