package com.feicui.atm.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feicui.atm.entity.User;
import com.feicui.atm.util.JdbcUtil;

public class GeneralUserTransferDao {

	private User user;

	public GeneralUserTransferDao(User user) {

		this.user = user;

	}

	public double targetUserTransferDao(String sql1) {

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		double balance = 0;
		try {
			con = JdbcUtil.jdbcUtil();

			statement = con.prepareStatement(sql1);

			// 执行sql语句,返回结果 -- 查询
			rs = statement.executeQuery();

			while (rs.next()) {

				balance = Double.valueOf(rs.getString(1));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {

			e.printStackTrace();
		}

		return balance;
	}

	public void targetBillDao(String sql2) {

		Connection con = null;
		PreparedStatement statement = null;

		try {

			con = JdbcUtil.jdbcUtil();
			statement = con.prepareStatement(sql2);

			// 执行sql语句,返回结果 -- 修改
			statement.executeUpdate();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				con.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void targetBillDao(String id1, String indexAccount, String time, double money, double newBalance) {
		Connection con = null;
		PreparedStatement statement = null;

		// 获取执行sql的PreparedStatement对象
		try {
			con = JdbcUtil.jdbcUtil();

			

		
			
			String sql3 = "insert into account_flow" + "(id,account,target_account,type,time,amount,after_amount)"
					+ "value (?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql3);

			statement.setString(1, id1);
			statement.setString(2, user.getAccount());
			statement.setString(3, indexAccount);
			statement.setInt(4, 4);
			statement.setString(5, time);
			statement.setDouble(6, money);
			statement.setDouble(7, newBalance);

			// 执行sql语句,返回结果 -- 新增
			statement.executeUpdate();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}