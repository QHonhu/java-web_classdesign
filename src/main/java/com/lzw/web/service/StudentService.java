package com.lzw.web.service;

import com.lzw.web.page.model.Student;
import com.lzw.web.utils.Pager;

public interface StudentService {
	
	/**
	 * 
	 *根据查询条件，来查询学生分页信息
	 * @param searchModel  封装的查询条件
	 * @param pageNum      当前查询第几页数据
	 * @param pageSize     每页显示多少数据
	 * @return             查询数据
	 */
	public Pager<Student> findStudent(Student searchModel,int pageNum,int pageSize);
}
