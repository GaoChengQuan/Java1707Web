package com.situ.student.service;

import java.util.List;

import com.situ.student.exception.NameRepeatException;
import com.situ.student.pojo.Student;
import com.situ.student.vo.PageBean;
import com.situ.student.vo.SearchCondition;

public interface IStudentService {

	/**
	 * 返回所有数据
	 * @return
	 */
	List<Student> findAll();

	/**
	 * 添加学生
	 * @param student
	 * @return
	 * @throws NameRepeatException 
	 */
	boolean add(Student student) throws NameRepeatException;
	
	List<Student> searchByName(String name);

	Student findById(Integer id);

	PageBean searchByCondition(SearchCondition searchCondition);

	PageBean getPageBean(int pageIndex, int pageSize);

	boolean checkName(String name);

}
