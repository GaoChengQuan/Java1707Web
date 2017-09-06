package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.situ.student.dao.IAdminDao;
import com.situ.student.pojo.Admin;
import com.situ.student.pojo.Student;
import com.situ.student.util.JdbcUtil;

public class AdminDaoImpl implements IAdminDao{

	@Override
	public Admin findByNameAndPassword(String name, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME,PASSWORD FROM admin WHERE NAME=? AND PASSWORD=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String adminName = resultSet.getString("name");
				String adminPassword = resultSet.getString("password");
				Admin admin = new Admin(id, adminName, adminPassword);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}

		return null;
	}

}
