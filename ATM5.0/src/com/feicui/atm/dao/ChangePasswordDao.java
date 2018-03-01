package com.feicui.atm.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.feicui.atm.util.JdbcUtil;

public class ChangePasswordDao {

	public void changePasswordDao(String newPassword, String changePw_Account) {

		Connection con = null;
		PreparedStatement statement = null;

		try {

			con = JdbcUtil.jdbcUtil();
			// 获取执行sql的PreparedStatement对象
			String sql = "update atm_user set password = '" + newPassword + "' where account = '" + changePw_Account
					+ "';";
			statement = con.prepareStatement(sql);

			// 执行sql语句,返回结果 -- 修改密码
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			// 关闭资源
			try {

				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}