package com.feicui.atm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feicui.atm.util.JdbcUtil;

public class QueryUserDao {

	Connection con = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	public void queryRegularUserDao(String sql) {

		try {

			con = JdbcUtil.jdbcUtil();
			statement = con.prepareStatement(sql);

			rs = statement.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String userName = rs.getString(2);
				String idCardNumber = rs.getString(3);
				int gender = Integer.valueOf(rs.getString(4));
				String account = rs.getString(5);
				double balance = Double.valueOf(rs.getString(6));

				String gen;
				if (gender == 1) {
					gen = "男";
				} else {
					gen = "女";
				}

				System.out.println("id:" + id + "," + "用户名:" + userName + "," + "身份证号:" + idCardNumber + "," + "性别:"
						+ gen + "," + "账号:" + account + "," + "余额:" + balance);
			}

		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {

				// 关闭资源
				rs.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void queryDeleteUserDao(String sql) {

		try {

			con = JdbcUtil.jdbcUtil();
			statement = con.prepareStatement(sql);
			// 执行sql语句,返回结果 -- 查询
			rs = statement.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String userName = rs.getString(2);
				String idCardNumber = rs.getString(3);
				int gender = Integer.valueOf(rs.getString(4));
				String account = rs.getString(5);
				double balance = Double.valueOf(rs.getString(6));
				int state = Integer.valueOf(rs.getString(7));

				String gen;
				if (gender == 1) {
					gen = "男";
				} else {
					gen = "女";
				}

				String sta = null;
				if (state == 1) {
					sta = "正常用户";
				} else if (state == 2) {
					sta = "销户用户";
				} else if (state == 3) {
					sta = "锁定用户";
				}

				System.out.println("id:" + id + "," + "用户名:" + userName + "," + "身份证号:" + idCardNumber + "," + "性别:"
						+ gen + "," + "账号:" + account + "," + "余额:" + balance + "用户状态:" + sta);
			}

			// 关闭资源

		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {

				rs.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void quserLockingUserDao(String sql) {

		try {

			con = JdbcUtil.jdbcUtil();
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String userName = rs.getString(2);
				String idCardNumber = rs.getString(3);
				int gender = Integer.valueOf(rs.getString(4));
				String account = rs.getString(5);
				double balance = Double.valueOf(rs.getString(6));
				int state = Integer.valueOf(rs.getString(7));

				String gen;
				if (gender == 1) {
					gen = "男";
				} else {
					gen = "女";
				}

				String sta = null;
				if (state == 1) {
					sta = "正常用户";
				} else if (state == 2) {
					sta = "销户用户";
				} else if (state == 3) {
					sta = "锁定用户";
				}

				System.out.println("id:" + id + "," + "用户名:" + userName + "," + "身份证号:" + idCardNumber + "," + "性别:"
						+ gen + "," + "账号:" + account + "," + "余额:" + balance + "用户状态:" + sta);
			}

		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {

			// 关闭资源
			try {
				rs.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
