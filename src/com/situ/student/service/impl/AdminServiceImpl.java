package com.situ.student.service.impl;

import com.situ.student.dao.IAdminDao;
import com.situ.student.dao.impl.AdminDaoImpl;
import com.situ.student.pojo.Admin;
import com.situ.student.service.IAdminService;

public class AdminServiceImpl implements IAdminService{
	IAdminDao adminDao = new AdminDaoImpl();
	
	@Override
	public Admin findByNameAndPassword(String name, String password) {
		return adminDao.findByNameAndPassword(name, password);
	}

}
