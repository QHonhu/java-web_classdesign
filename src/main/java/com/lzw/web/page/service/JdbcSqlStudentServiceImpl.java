package com.lzw.web.page.service;

import com.lzw.web.page.dao.JdbcSqlStudentDaoImpl;
import com.lzw.web.page.dao.StudentDao;
import com.lzw.web.page.model.Pager;
import com.lzw.web.page.model.Student;

public class JdbcSqlStudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	public JdbcSqlStudentServiceImpl(){
		studentDao = new JdbcSqlStudentDaoImpl();
	}

	public Pager<Student> findStudent(Student searchModel, int pageNum, int pageSize) {
		Pager<Student> result = studentDao.findStudent(searchModel, pageNum,
				pageSize);
		return result;
	}

	

}
