package com.lzw.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lzw.web.dao.JdbcDaoBuyer;
import com.lzw.web.meta.BuyGood;
import com.lzw.web.meta.Merchandise;
import com.lzw.web.meta.User;
import com.lzw.web.utils.ConnectDB;

public class JdbcDaoImplBuyer implements JdbcDaoBuyer {

	public boolean isAddUser(User user) {

		Connection conn = ConnectDB.open();
		PreparedStatement pstmt = null;
		String sql = "insert into user(username,password,phone) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getPhone());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectDB.close(conn);
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

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

	public User getUserInfoByUserName(String username) {
		String sql = "select * from user where username = ?";
		User user = new User();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = ConnectDB.open();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setUserType(rs.getInt("userType"));
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
		return user;
	}

	public List<Merchandise> getMerchandiseList(int userId) {
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
				if (getIsSell(mer.getId())) {
					mer.setSell(true);
				}
				if (getIsBuy(mer.getId(), userId)) {
					mer.setBuy(true);
				}
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

	public Merchandise getMerchandiseInfoById(int id, int userId) {
		String sql = "select m.* ,t.price  from merchandise m ,trx t where  m.id=? and m.id=contentId";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = ConnectDB.open();
		Merchandise mer = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					mer = new Merchandise();
					mer.setDetail(rs.getString("detail"));
					mer.setId(rs.getInt("id"));
					mer.setImage(rs.getString("image"));
					mer.setSummary(rs.getString("summary"));
					mer.setTitle(rs.getString("mername"));
					mer.setPrice(rs.getLong(3));
					mer.setBuyPrice(rs.getLong(7));
					if (getIsBuy(mer.getId(), userId)) {
						mer.setBuy(true);
					}
				}
			} else {
				mer = new Merchandise();
				show(mer, id);
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
		return mer;
	}
	
	public void show(Merchandise mer ,int id)
	{
		String sql = "select * from merchandise where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = ConnectDB.open();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					mer.setDetail(rs.getString("detail"));
					mer.setId(rs.getInt("id"));
					mer.setImage(rs.getString("image"));
					mer.setSummary(rs.getString("summary"));
					mer.setTitle(rs.getString("mername"));
					mer.setPrice(rs.getLong("price"));
				}
			} else {
				mer = new Merchandise();
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
	}
	
	public boolean buyGoodsById(int id, int u) {
		String sql = "insert into trx(contentId,time,price,personId) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		boolean f = false;
		Connection conn = ConnectDB.open();
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setLong(2, new Date().getTime());
			pstmt.setInt(3, getMerPrice(id));
			pstmt.setInt(4, u);
			pstmt.execute();
			conn.commit();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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

	public int getMerPrice(int id) {
		String sql = "select price from merchandise where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int price = 0;
		Connection conn = ConnectDB.open();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				price = rs.getInt("price");
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
		return price;
	}

	public boolean isBuy() {
		Connection conn = ConnectDB.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user where id = (select personId from trx)";
		try {
			pstmt = conn.prepareStatement(sql);
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

	public boolean getIsBuy(int id, int userId) {
		String sql = "select m.id  from trx , merchandise m where contentId = m.id and  personId =?";
		Connection conn = ConnectDB.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> numbers = new ArrayList<Integer>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				numbers.add(rs.getInt(1));
			}
			for (int number : numbers) {
				if (number == id)
					return true;
			}

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

	public boolean getIsSell(int id) {
		String sql = "select personId from trx where contentId =?";
		Connection conn = ConnectDB.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
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

	public List<BuyGood> getBuyList(int id) {
		String sql = "select m.id ,mername ,image ,time ,trx.price from trx , merchandise m where contentId = m.id and  personId =? ";
		Connection conn = ConnectDB.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
		List<BuyGood> buylist = new ArrayList<BuyGood>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BuyGood b = new BuyGood();
				b.setId(rs.getInt(1));
				b.setBuyPrice(rs.getLong(5));
				b.setBuyTime(sdf.format(new Date(rs.getLong(4))));
				b.setImage(rs.getString(3));
				b.setTitle(rs.getString(2));
				buylist.add(b);
			}
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
		return buylist;
	}
}
