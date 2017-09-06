package com.situ.student.service;

import com.situ.student.pojo.Admin;

public interface IAdminService {

	Admin findByNameAndPassword(String name, String password);
	
}
