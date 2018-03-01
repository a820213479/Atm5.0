package com.feicui.atm.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.feicui.atm.entity.User;
import com.feicui.atm.util.FormatUtil;
import com.feicui.atm.util.JdbcUtil;

public class AddUserDao {

	private User user;

	public AddUserDao(User user) {

		this.user = user;

	}

	public void addUserDao() {

		Connection con = null;
		PreparedStatement statement = null;
		try {

			// 建立数据库连接
			con = JdbcUtil.jdbcUtil();

			// 获取执行sql的PreparedStatement对象
			String sql = "insert into atm_user"
					+ "(id,userName,idCardNumber,gender,birthday,address,balance,account, password,type,state,remark)"
					+ "value (?,?,?,?,?,?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);

			String date = FormatUtil.formatUtil("yyyy-MM-dd", user.getBirthday());
			//String date = fu.formatUtil("yyyy-MM-dd", user.getBirthday());

			statement.setString(1, user.getId());
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getIdCardNumber());
			statement.setInt(4, user.getGender());
			statement.setString(5, date);
			statement.setString(6, user.getAddress());
			statement.setDouble(7, user.getBalance());
			statement.setString(8, user.getAccount());
			statement.setString(9, user.getPassword());
			statement.setInt(10, user.getType());
			statement.setInt(11, user.getState());
			statement.setString(12, user.getRemark());

			// 执行sql语句,返回结果 -- 新增
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

			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
