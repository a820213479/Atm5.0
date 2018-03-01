package com.feicui.atm.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.feicui.atm.util.JdbcUtil;

public class UnlockUserDao {

	public void unlockUserDao(String unlock_Account) {

		Connection con = null;
		PreparedStatement statement = null;

		try {

			con = JdbcUtil.jdbcUtil();
			// 获取执行sql的PreparedStatement对象
			String sql = "update atm_user set state = 1 where account = '" + unlock_Account + "';";
			statement = con.prepareStatement(sql);

			// 执行sql语句,返回结果 -- 解除锁定
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
