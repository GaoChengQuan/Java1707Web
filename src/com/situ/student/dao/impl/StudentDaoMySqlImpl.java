package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.pojo.Student;
import com.situ.student.util.JdbcUtil;
import com.situ.student.vo.SearchCondition;

public class StudentDaoMySqlImpl implements IStudentDao {

	@Override
	public int add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "INSERT INTO student(NAME,age,gender,address,birthday) VALUES(?,?,?,?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement);
		}

		return result;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME,age,gender,address FROM student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Student student = new Student(id, name, age, gender, address, new Date());
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}

		return list;
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByGender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean isExist = false;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id FROM student WHERE NAME=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}

		return isExist;
	}

	@Override
	public List<Student> searchByName(String searchName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME,age,gender,address FROM student where name=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, searchName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Student student = new Student(id, name, age, gender, address, new Date());
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}

		return list;
	}

	@Override
	public Student findById(Integer idSearch) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME,age,gender,address FROM student where id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idSearch);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Student student = new Student(id, name, age, gender, address, new Date());
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}

		return null;
	
	}

	@Override
	public List<Student> searchByCondition(SearchCondition searchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		
		// select * from student where name like ? and age=? and gender=?;
		// select * from student where name like ? and age=? and gender=?;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME,age,gender,address FROM student where 1=1";
			String nameSearch = searchCondition.getName();
			List<String> listCondition = new ArrayList<String>();
			if (nameSearch != null && !nameSearch.equals("")) {
				sql += " and name like ?";
				listCondition.add("%" + nameSearch + "%");
			}
			String ageSearch = searchCondition.getAge();
			if (ageSearch != null && !ageSearch.equals("")) {
				sql += " and age=?";
				listCondition.add(ageSearch);
			}
			String genderSearch = searchCondition.getGender();
			if (genderSearch != null && !genderSearch.equals("")) {
				sql += " and gender=?";
				listCondition.add(genderSearch);
			}
			
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < listCondition.size(); i++) {
				preparedStatement.setString(i + 1, listCondition.get(i));
			}
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Student student = new Student(id, name, age, gender, address, new Date());
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}

		return list;
	}

	@Override
	public List<Student> findPageBeanList(int index, int pageSize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student limit ?,?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, index);
			preparedStatement.setObject(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, address, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalCount() {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int count = 0;
	    try {
	       connection = JdbcUtil.getConnection();
	       String sql = "SELECT COUNT(*) FROM student;";
	       preparedStatement = connection.prepareStatement(sql);
	       resultSet = preparedStatement.executeQuery();
	       if (resultSet.next()) {
	           count = resultSet.getInt(1);
	       }
	    } catch (SQLException e) {
	       e.printStackTrace();
	    }
	    
	    return count;
	}
	
	@Override
	public int getTotalCount(SearchCondition searchCondition) {
		Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int count = 0;
	    try {
	       connection = JdbcUtil.getConnection();
	       String sql = "SELECT COUNT(*) FROM student where 1=1 ";
	       
	       String nameSearch = searchCondition.getName();
			List<String> listCondition = new ArrayList<String>();
			if (nameSearch != null && !nameSearch.equals("")) {
				sql += " and name like ?";
				listCondition.add("%" + nameSearch + "%");
			}
			String ageSearch = searchCondition.getAge();
			if (ageSearch != null && !ageSearch.equals("")) {
				sql += " and age=?";
				listCondition.add(ageSearch);
			}
			String genderSearch = searchCondition.getGender();
			if (genderSearch != null && !genderSearch.equals("")) {
				sql += " and gender=?";
				listCondition.add(genderSearch);
			}
			
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < listCondition.size(); i++) {
				preparedStatement.setString(i + 1, listCondition.get(i));
			}
	       
	       resultSet = preparedStatement.executeQuery();
	       if (resultSet.next()) {
	           count = resultSet.getInt(1);
	       }
	    } catch (SQLException e) {
	       e.printStackTrace();
	    }
	    
	    return count;
	}

	@Override
	public List<Student> findPageBeanList(SearchCondition searchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from student where 1=1 ";
			
			String nameSearch = searchCondition.getName();
			List<String> listCondition = new ArrayList<String>();
			if (nameSearch != null && !nameSearch.equals("")) {
				sql += " and name like ?";
				listCondition.add("%" + nameSearch + "%");
			}
			String ageSearch = searchCondition.getAge();
			if (ageSearch != null && !ageSearch.equals("")) {
				sql += " and age=?";
				listCondition.add(ageSearch);
			}
			String genderSearch = searchCondition.getGender();
			if (genderSearch != null && !genderSearch.equals("")) {
				sql += " and gender=?";
				listCondition.add(genderSearch);
			}
			
			// limit ?,?
			sql += " limit ?,?";
			
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < listCondition.size(); i++) {
				preparedStatement.setString(i + 1, listCondition.get(i));
			}
			int index = (searchCondition.getPageIndex() - 1) * searchCondition.getPageSize();
			preparedStatement.setInt(listCondition.size() + 1, index);
			preparedStatement.setInt(listCondition.size() + 2, searchCondition.getPageSize());
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Date birthday = resultSet.getDate("birthday");
				Student student = new Student(id, name, age, gender, address, birthday);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
