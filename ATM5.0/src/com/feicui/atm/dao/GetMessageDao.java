package com.feicui.atm.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.feicui.atm.entity.User;
import com.feicui.atm.util.JdbcUtil;

public class GetMessageDao {

	private User user;

	public GetMessageDao(User user) {
		this.user = user;
	}

	public void getMessageDao(String sql) {

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {

			// 注册驱动,创建连接
			con = JdbcUtil.jdbcUtil();

			// 获取执行sql的PreparedStatement对象
			//String sql = "select id,userName,idCardNumber,gender,birthday,address,balance,account,password,type,state,remark from atm_user where state = 1 && type != 1;";
			statement = con.prepareStatement(sql);

			// 执行sql语句,返回结果 -- 查询
			rs = statement.executeQuery();

			while (rs.next()) {

				user.setId(rs.getString(1));
				user.setUserName(rs.getString(2));
				user.setIdCardNumber(rs.getString(3));
				user.setGender(Integer.valueOf(rs.getString(4)));
				user.setBirthday(rs.getDate(5));
				user.setAddress(rs.getString(6));
				user.setBalance(Double.valueOf(rs.getString(7)));
				user.setAccount(rs.getString(8));
				user.setPassword(rs.getString(9));
				user.setType(Integer.valueOf(rs.getString(10)));
				user.setState(Integer.valueOf(rs.getString(11)));
				user.setRemark(rs.getString(12));

			}

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
				rs.close();
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
