package com.lzw.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzw.web.dao.impl.JdbcDaoSellerImpl;

public class Delete extends HttpServlet {

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
		System.out.println("delete");
		PrintWriter out = resp.getWriter();
		int id = Integer.valueOf(req.getParameter("id"));
		if(new JdbcDaoSellerImpl().deleteGoodsById(id))
			out.print("{\"code\":\"" + 200 + "\",\"message\":\""+"sucess"+"\",\"result\":\""+true+"\"}");
		else 
			out.print("{\"code\":\"" + 500 + "\",\"message\":\""+"删除失败"+"\",\"result\":\""+false+"\"}");
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
