package com.feicui.atm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feicui.atm.util.JdbcUtil;

public class UserDao {

	Connection con = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	public Boolean userNumDao(String sql) {

		try {

			con = JdbcUtil.jdbcUtil();
			statement = con.prepareStatement(sql);

			rs = statement.executeQuery();
			rs.next();
			int num = rs.getInt("number");

			if (num == 0) {

				return false;
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {

				con.close();
				statement.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public Boolean userAccountDao(String sql1, String inputPassword) {

		try {

			con = JdbcUtil.jdbcUtil();
			statement = con.prepareStatement(sql1);

			rs = statement.executeQuery();

			while (rs.next()) {

				String password = rs.getString(1);

				if (password.equals(inputPassword)) {

					return true;
				}

			}

		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {

		}

		try {

			con.close();
			statement.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}