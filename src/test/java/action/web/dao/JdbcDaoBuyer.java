package com.lzw.web.dao;

import java.util.List;

import com.lzw.web.meta.Merchandise;
import com.lzw.web.meta.User;

public interface JdbcDaoBuyer {
	
	public boolean isUserName(String username);
	
	public boolean isUserPassword(String password);
	
	public boolean isAddUser(User user);
	
	public List<Merchandise> getMerchandiseList(int userId);
	
	public Merchandise getMerchandiseInfoById(int id,int userId);
	
	public boolean buyGoodsById(int id ,int u);
	
	public boolean isBuy();
	
}
