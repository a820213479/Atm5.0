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

public class QueryLoginTimeDao {

	public void queryLoginTimeDao(User user) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {

			// 注册驱动,创建连接
			con = JdbcUtil.jdbcUtil();
			// 获取执行sql的PreparedStatement对象

			String sql = "select login_time from login_query where account = '" + user.getAccount() + "';";
			statement = con.prepareStatement(sql);

			// 执行sql语句,返回结果 -- 查询
			rs = statement.executeQuery();

			while (rs.next()) {
				String time = rs.getString(1);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = sdf.parse(time);
				String newTime = sdf.format(date);
				System.out.println(newTime);

				// System.out.println(time.substring(0, time.length()-2));
			}

			// 关闭资源
			rs.close();
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
