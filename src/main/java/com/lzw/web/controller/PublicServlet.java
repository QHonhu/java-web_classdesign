package com.lzw.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzw.web.dao.impl.JdbcDaoSellerImpl;
import com.lzw.web.meta.Merchandise;


public class PublicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String summary = req.getParameter("summary");
		String image = req.getParameter("image");
		String detail = req.getParameter("detail");
		Long price = Long.valueOf(req.getParameter("price"));
		Merchandise mer = new Merchandise();
		JdbcDaoSellerImpl jdsi = new JdbcDaoSellerImpl();
		mer.setTitle(title);
		mer.setSummary(summary);
		mer.setImage(image);
		mer.setDetail(detail);
		mer.setPrice(price);
		jdsi.addPublic(mer);
		req.getSession().setAttribute("message","发布成功");
		req.getRequestDispatcher("/publicSubmit.jsp").forward(req, resp);
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
