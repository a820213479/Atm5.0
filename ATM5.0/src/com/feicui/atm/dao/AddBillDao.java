package com.feicui.atm.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.feicui.atm.entity.User;
import com.feicui.atm.util.JdbcUtil;

public class AddBillDao {

	private User user;

	public AddBillDao(User user) {

		this.user = user;

	}

	public void addBillDao(String id, String targetAccount, String time, double money) {

		Connection con = null;
		PreparedStatement statement = null;

		try {

			con = JdbcUtil.jdbcUtil();

			// 获取执行sql的PreparedStatement对象
			String sql = "insert into account_flow" + "(id,account,target_account,type,time,amount,after_amount)"
					+ "value (?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);

			statement.setString(1, id);
			statement.setString(2, user.getAccount());
			statement.setString(3, targetAccount);
			statement.setInt(4, 1);
			statement.setString(5, time);
			statement.setDouble(6, money);
			statement.setDouble(7, user.getBalance());

			// 执行sql语句,返回结果 -- 新增
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
		} finally {

			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}