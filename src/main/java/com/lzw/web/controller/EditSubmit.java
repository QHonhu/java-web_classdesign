package com.lzw.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzw.web.dao.impl.JdbcDaoSellerImpl;
import com.lzw.web.meta.Merchandise;
@WebServlet("/editSubmit")
public class EditSubmit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = Integer.valueOf(req.getParameter("id"));
		Merchandise m = new Merchandise();
		m.setTitle(req.getParameter("title"));
		m.setSummary(req.getParameter("summary"));
		m.setImage(req.getParameter("image"));
		m.setDetail(req.getParameter("detail"));
		m.setPrice(Long.valueOf(req.getParameter("price")));
		new JdbcDaoSellerImpl().updateGoodInfo(id, m);
		session.setAttribute("message", "编辑成功");
		req.getRequestDispatcher("publicSubmit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		HttpSession session = req.getSession();
		Merchandise m = new Merchandise();
		m.setTitle(req.getParameter("title"));
		m.setSummary(req.getParameter("summary"));
		m.setImage(req.getParameter("image"));
		m.setDetail(req.getParameter("detail"));
		m.setPrice(Long.valueOf(req.getParameter("price")));
		new JdbcDaoSellerImpl().updateGoodInfo(id, m);
		session.setAttribute("message", "编辑成功");
		req.getRequestDispatcher("publicSubmit.jsp").forward(req, resp);
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
