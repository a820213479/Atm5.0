package com.feicui.atm.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.feicui.atm.util.JdbcUtil;

public class UpdateBalanceDao {

	public void updateMoney(String sql) {

		Connection con = null;
		PreparedStatement statement = null;

		try {

			// 注册驱动,创建连接
			con = JdbcUtil.jdbcUtil();

			// 获取执行sql的PreparedStatement对象
			statement = con.prepareStatement(sql);

			// 执行sql语句,返回结果 -- 更新
			statement.executeUpdate();

			// 关闭资源
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
