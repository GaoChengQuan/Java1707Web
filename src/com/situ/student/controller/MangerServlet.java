package com.situ.student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.service.IManagerService;
import com.situ.student.service.impl.ManagerServiceImpl;
import com.situ.student.util.JdbcUtil;

public class MangerServlet extends BaseServlet{

	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IManagerService managerService = new ManagerServiceImpl();
		List<Map<String, Object>> list = managerService.findAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/manager_list.jsp").forward(request, response);
	}
	
	public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		System.out.println("id:" + id);
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "delete from banji_course where id=?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(id));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement);
		}
		
		response.sendRedirect(request.getContextPath() + "/manager?method=findAll");
	}
}
