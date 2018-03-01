package com.feicui.atm.services;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.QueryLoginTimeDao;
import com.feicui.atm.entity.User;

public class QueryLoginTimeServices extends AbstractController {

	@Override
	public void execute(User user) {
		QueryLoginTimeDao qltd = new QueryLoginTimeDao();
		qltd.queryLoginTimeDao(user);

	}

	@Override
	public void execute() {

	}
}
