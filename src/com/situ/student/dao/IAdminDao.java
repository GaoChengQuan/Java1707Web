package com.situ.student.dao;

import com.situ.student.pojo.Admin;

public interface IAdminDao {

	Admin findByNameAndPassword(String name, String password);

}
