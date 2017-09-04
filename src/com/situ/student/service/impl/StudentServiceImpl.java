package com.situ.student.service.impl;

import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.dao.impl.StudentDaoMySqlImpl;
import com.situ.student.exception.NameRepeatException;
import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.vo.PageBean;
import com.situ.student.vo.SearchCondition;
import com.sun.xml.internal.bind.v2.TODO;

public class StudentServiceImpl implements IStudentService{
	private IStudentDao studentDao = new StudentDaoMySqlImpl();
			
	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public boolean add(Student student) throws NameRepeatException {
		//1.判断这个学生是否已经存在
		if (studentDao.checkName(student.getName())) {//用户已经存在
			//System.out.println("用户名已经存在");
			// return false;
			throw new NameRepeatException("用户名已经存在");
		} else {//用户不存在
			// return studentDao.add(student) > 0 ? true : false;
			int result = studentDao.add(student);
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public List<Student> searchByName(String name) {
		return studentDao.searchByName(name);
	}

	@Override
	public Student findById(Integer id) {
		
		return studentDao.findById(id);
	}

	@Override
	public PageBean searchByCondition(SearchCondition searchCondition) {
		PageBean pageBean = new PageBean();
		 //当前是第几页
		//private Integer pageIndex;
		pageBean.setPageIndex(searchCondition.getPageIndex());
		//每一页有多少条数据
		//private Integer pageSize;
		pageBean.setPageSize(searchCondition.getPageSize());
		//数据库中一共有多少条记录
		//private Integer totalCount; 
		//SELECT COUNT(*) FROM student WHERE NAME LIKE '%uu%' AND age=20;
		//SELECT COUNT(*) FROM student ;
		int totalCount = studentDao.getTotalCount(searchCondition);
		// TODO 具体实现这个方法而不是写死 
		//int totalCount = 7;
		pageBean.setTotalCount(totalCount);
		// 一共有多少页
		//private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / searchCondition.getPageSize()); 
		pageBean.setTotalPage(totalPage);
		// 当前页的数据
		//private List<Student> list;
		//int index = (searchCondition.getPageIndex() - 1) * searchCondition.getPageSize();
		//SELECT * FROM student WHERE NAME LIKE '%uu%' LIMIT 0,3;
		//SELECT * FROM student LIMIT 0,3;
		List<Student> list = studentDao.findPageBeanList(searchCondition);
		pageBean.setList(list);
		
		return pageBean;
		//return studentDao.searchByCondition(searchCondition);
	}

	@Override
	public PageBean getPageBean(int pageIndex, int pageSize) {
		PageBean pageBean = new PageBean();
		 //当前是第几页
		//private Integer pageIndex;
		pageBean.setPageIndex(pageIndex);
		//每一页有多少条数据
		//private Integer pageSize;
		pageBean.setPageSize(pageSize);
		//数据库中一共有多少条记录
		//private Integer totalCount; 
		int totalCount = studentDao.getTotalCount();
		// TODO 具体实现这个方法而不是写死 
		//int totalCount = 7;
		pageBean.setTotalCount(totalCount);
		// 一共有多少页
		//private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize); 
		pageBean.setTotalPage(totalPage);
		// 当前页的数据
		//private List<Student> list;
		int index = (pageIndex - 1) * pageSize;
		//SELECT * FROM student WHERE LIMIT 0,3;
		List<Student> list = studentDao.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

}
