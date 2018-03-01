package com.feicui.atm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.feicui.atm.entity.User;
import com.feicui.atm.util.JdbcUtil;

public class LoginTimeDao {

	

	public void loginTimeDao(String sql, String time, User user) {


		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = JdbcUtil.jdbcUtil();

			statement = con.prepareStatement(sql);
			statement.setString(1, user.getAccount());
			statement.setString(2, time);

			statement.executeUpdate();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	
		
	}

}
