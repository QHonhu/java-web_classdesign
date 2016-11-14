package com.lzw.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lzw.web.dao.JdbcDaoAdministrator;
import com.lzw.web.meta.Merchandise;
import com.lzw.web.meta.Trx;
import com.lzw.web.meta.User;
import com.lzw.web.utils.ConnectDB;

public class JdbcDaoAdministratorImpl implements JdbcDaoAdministrator {

	public boolean isUserName(String username) {
		Connection conn = ConnectDB.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select username from user where username = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectDB.close(conn);
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	public boolean isUserPassword(String password) {
		Connection conn = ConnectDB.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select password from user where password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			rs = pstmt.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectDB.close(conn);
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
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

	public boolean deleteUserId(int id) {
		String sql ="delete  from user where id=? ";
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

	public List<Trx> getTrxInfoById(){
		String sql = "select * from Trx";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Trx> trxs = new ArrayList<Trx>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
		Connection conn = ConnectDB.open();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Trx trx = new Trx();
				trx.setContentId(rs.getInt("contentId"));
				trx.setPersonId(rs.getInt("personId"));
				trx.setPrice(rs.getInt("price"));
				trx.setTime(sdf.format(new Date(rs.getLong("time"))));
				System.out.println(rs.getString(2));
				trxs.add(trx);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectDB.close(conn);
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trxs;
	}

	public void updateGoodInfo(int id,Merchandise m) {
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
				pstmt.execute();
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
	}

	public void updateUserInfo(int id,User u) {
		{
			String sql ="update user set username = ? ,password=?,phone=?,userType=?,address=? where id=? ";
			PreparedStatement pstmt = null;
			Connection conn = ConnectDB.open();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,u.getUsername());
				pstmt.setString(2, u.getPassword());
				pstmt.setString(3, u.getPhone());
				pstmt.setInt(4,u.getUserType());
				pstmt.setString(5, u.getAddress());
				pstmt.setInt(6, id);
				pstmt.execute();
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
	}

	public List<User> getUserInfoByUserName() {
		String sql = "select * from user";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		Connection conn = ConnectDB.open();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUserType(rs.getInt("userType"));
				user.setAddress(rs.getString("address"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectDB.close(conn);
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	
	public List<Merchandise> getMerchandiseInfoById() {
		String sql = "select * from merchandise";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Merchandise> ms = new ArrayList<Merchandise>();
		Connection conn = ConnectDB.open();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Merchandise mer = new Merchandise();
				mer.setDetail(rs.getString("detail"));
				mer.setId(rs.getInt("id"));
				mer.setImage(rs.getString("image"));
				mer.setSummary(rs.getString("summary"));
				mer.setTitle(rs.getString("mername"));
				mer.setPrice(rs.getLong("price"));
				ms.add(mer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectDB.close(conn);
			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ms;
	}
}