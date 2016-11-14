package com.lzw.web.dao;

import java.util.List;

import com.lzw.web.meta.Merchandise;
import com.lzw.web.meta.Trx;
import com.lzw.web.meta.User;

public interface JdbcDaoAdministrator {

	public boolean isUserName(String username);
	
	public boolean isUserPassword(String password);
	
	public boolean deleteGoodsById(int id);
	
	public boolean deleteUserId(int id);
	
	public List<User> getUserInfoByUserName();  //查询用户信息  重写
	
	public List<Merchandise> getMerchandiseInfoById();  //商品 重
	
	public List<Trx> getTrxInfoById();  //订单  重写
	
	public void updateGoodInfo(int id,Merchandise m);   //重写
	
	public void updateUserInfo(int id,User u);   //重写
	
}
