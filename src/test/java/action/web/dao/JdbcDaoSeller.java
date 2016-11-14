package com.lzw.web.dao;

import com.lzw.web.meta.Merchandise;

public interface JdbcDaoSeller {

	public void addPublic(Merchandise mer);
	
	public boolean deleteGoodsById(int id);
	
	public void updateGoodInfo(int id,Merchandise m);
}
