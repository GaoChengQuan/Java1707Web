package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.situ.student.dao.IManagerDao;
import com.situ.student.pojo.Student;
import com.situ.student.util.JdbcUtil;
import com.situ.student.util.ModelConvert;

public class ManagerDaoImpl implements IManagerDao{

	@Override
	public List<Map<String, Object>> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Map<String, Object>> list = null;
		try {
			connection = JdbcUtil.getConnection();
			/*String sql = "select student.name as student_name,course.name as course_name,course.credit "
					+ "from student inner join banji  on student.banji_id=banji.id "
					+ "inner join banji_course on banji.id=banji_course.banji_id "
					+ "inner join course on banji_course.course_id=course.id;";*/
			String sql = "select banji_course.id AS bc_id, banji.name as banji_name,course.name as course_name,course.credit as course_credit from banji inner join banji_course on banji.id=banji_course.banji_id inner join course on banji_course.course_id=course.id order by bc_id;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			list = ModelConvert.convertList(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}

		return list;
	}

	

}
