package com.lzw.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzw.web.dao.impl.JdbcDaoImplBuyer;
import com.lzw.web.meta.BuyGood;
import com.lzw.web.meta.User;
@WebServlet("/account")
public class Account extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BuyGood> buylist = new ArrayList<BuyGood>();
		HttpSession session = req.getSession();
		buylist = new JdbcDaoImplBuyer().getBuyList(((User)session.getAttribute("user")).getId());
		session.setAttribute("buyList",buylist);
		req.getRequestDispatcher("account.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BuyGood> buylist = new ArrayList<BuyGood>();
		buylist = new JdbcDaoImplBuyer().getBuyList(Integer.valueOf(req.getParameter("id")));
		HttpSession session = req.getSession();
		System.out.println(buylist.get(1));
		session.setAttribute("buyList",buylist);
		req.getRequestDispatcher("account.jsp").forward(req, resp);
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
