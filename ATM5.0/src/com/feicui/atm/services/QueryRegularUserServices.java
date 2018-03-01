package com.feicui.atm.services;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.QueryUserDao;
import com.feicui.atm.entity.User;

public class QueryRegularUserServices extends AbstractController {

	@Override
	public void execute() {
		String sql = "select id,userName,idCardNumber,gender,account,balance from atm_user where state = 1 && type != 1;";
		QueryUserDao qud = new QueryUserDao();
		qud.queryRegularUserDao(sql);

	}

	@Override
	public void execute(User user) {
		
	}
}
