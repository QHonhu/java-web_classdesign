package com.lzw.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.lzw.web.dao.JdbcDaoSeller;
import com.lzw.web.meta.Merchandise;
import com.lzw.web.utils.ConnectDB;

public class JdbcDaoSellerImpl implements JdbcDaoSeller {

	public void addPublic(Merchandise mer) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		String sql ="insert into merchandise(mername,price,summary,detail,image) values(?,?,?,?,?)";
		conn = ConnectDB.open();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mer.getTitle());
			pstmt.setLong(2, mer.getPrice());
			pstmt.setString(3, mer.getSummary());
			pstmt.setString(4, mer.getDetail());
			pstmt.setString(5, mer.getImage());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean deleteGoodsById(int id) {
		String sql ="delete   from merchandise where id=? ";
		PreparedStatement pstmt = null;
		boolean f = false;
		Connection conn = ConnectDB.open();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
			f=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
			{
				ConnectDB.close(conn);
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return f;
	}
	
	public void updateGoodInfo(int id,Merchandise m)
	{
		String sql ="update  merchandise set mername = ? ,price=?,summary=?,detail=?,image=? where id=? ";
		PreparedStatement pstmt = null;
		Connection conn = ConnectDB.open();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getTitle());
			pstmt.setLong(2, m.getPrice());
			pstmt.setString(3, m.getSummary());
			pstmt.setString(4,m.getDetail());
			pstmt.setString(5, m.getImage());
			pstmt.setInt(6, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
			{
				ConnectDB.close(conn);
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
public Merchandise getEditMerc(int id)
{
	String sql = "select * from merchandise where id= ?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn = ConnectDB.open();
	Merchandise m = new Merchandise();
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		while (rs.next())
		{
			m.setTitle(rs.getString("mername"));
			m.setSummary(rs.getString("summary"));
			m.setImage(rs.getString("image"));
			m.setDetail(rs.getString("detail"));
			System.out.println("----------=========");
			System.out.println(m.getDetail());
			m.setPrice(rs.getLong("price"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return m;
}
}
