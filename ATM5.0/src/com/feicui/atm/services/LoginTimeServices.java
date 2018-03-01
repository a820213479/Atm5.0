package com.feicui.atm.services;

import java.util.Date;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.LoginTimeDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.util.FormatUtil;

public class LoginTimeServices extends AbstractController {

	@Override
	public void execute(User user) {
		String time = FormatUtil.formatUtil("yyyy-MM-dd HH:mm:ss", new Date());

		String sql = "insert into login_query" + "(account,login_time)" + "value (?,?)";
		LoginTimeDao ltd = new LoginTimeDao();
		ltd.loginTimeDao(sql, time, user);
	}

	@Override
	public void execute() {

	}
}
