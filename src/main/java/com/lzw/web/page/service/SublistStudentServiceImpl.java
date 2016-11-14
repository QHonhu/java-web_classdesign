package com.lzw.web.page.service;

import com.lzw.web.page.dao.StudentDao;
import com.lzw.web.page.dao.SublistStudentDaoImpl;
import com.lzw.web.page.model.Pager;
import com.lzw.web.page.model.Student;

public class SublistStudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public SublistStudentServiceImpl() {
		// 创建servivce实现类时，初始化dao对象。
		studentDao = new SublistStudentDaoImpl();
	}


	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	public Pager<Student> findStudent(Student searchModel, int pageNum, int pageSize) {
		Pager<Student> result = studentDao.findStudent(searchModel, pageNum,
				pageSize);
		return result;
	}
}
