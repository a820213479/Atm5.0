package com.feicui.atm.services;

import com.feicui.atm.dao.UserDao;

public class UserServices {

	public Boolean userNumServies(String sql) {

		UserDao ud = new UserDao();
		Boolean bln = ud.userNumDao(sql);

		if (bln.equals(false)) {

			return false;
		}

		return true;
	}

	public Boolean userAccountServies(String sql1, String inputPassword) {

		UserDao ud = new UserDao();
		Boolean bln = ud.userAccountDao(sql1, inputPassword);

		if (bln.equals(false)) {

			return false;
		}

		return true;
	}

}
