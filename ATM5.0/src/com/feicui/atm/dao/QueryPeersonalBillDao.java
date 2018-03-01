package com.feicui.atm.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.feicui.atm.entity.User;
import com.feicui.atm.util.JdbcUtil;

public class QueryPeersonalBillDao {

	public void queryPeersonalBillDao(User user) {

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {

			// 注册驱动,创建连接
			con = JdbcUtil.jdbcUtil();
			// 获取执行sql的PreparedStatement对象

			String sql = "select id,account,target_account,type,time,amount,after_amount from account_flow where account = '"
					+ user.getAccount() + "';";
			statement = con.prepareStatement(sql);

			// 执行sql语句,返回结果 -- 查询
			rs = statement.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String account = rs.getString(2);
				String target_account = rs.getString(3);
				int type = Integer.valueOf(rs.getString(4));
				String time = rs.getString(5);
				double amount = Double.valueOf(rs.getString(6));
				double after_amount = Double.valueOf(rs.getString(7));

				String tp = null;
				if (type == 1) {
					tp = "存款";
				} else if (type == 2) {
					tp = "取款";
				} else if (type == 3) {
					tp = "转账-支出";
				} else if (type == 4) {
					tp = "转账收入";
				}

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				Date date = sdf.parse(time);
				String newTime = sdf.format(date);

				System.out.println("账务流水号:" + id + "," + "源账户:" + account + "," + "目标账户:" + target_account + ","
						+ "账务类型:" + tp + "," + "账务时间:" + newTime + "," + "交易余额:" + amount + "交易后账户余额:" + after_amount);

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e) {
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
