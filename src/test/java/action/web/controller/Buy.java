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

public class Buy extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;charset=utf-8");
		String jsonStr = "{code:200,message:sucess,result:true}";
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		PrintWriter out = resp.getWriter();
		int id = Integer.valueOf(req.getParameter("id"));
		HttpSession session = req.getSession();
		System.out.println(((User)(session.getAttribute("user"))).getId());
		if(new JdbcDaoImplBuyer().buyGoodsById(id,((User)(session.getAttribute("user"))).getId()))
			out.print("{\"code\":\"" + 200 + "\",\"message\":\""+"sucess"+"\",\"result\":\""+true+"\"}");
		else 
			out.print("{\"code\":\"" + 500 + "\",\"message\":\""+"购买失败"+"\",\"result\":\""+false+"\"}");
		out.flush();
		out.close();
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
