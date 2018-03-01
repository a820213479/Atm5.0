package com.feicui.atm.services;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.QueryPeersonalBillDao;
import com.feicui.atm.entity.User;

public class QueryPersonalBillServices extends AbstractController {

	

	@Override
	public void execute(User user) {
		
		QueryPeersonalBillDao qpbd = new QueryPeersonalBillDao();
		qpbd.queryPeersonalBillDao(user);
	}

	@Override
	public void execute() {
		
	}

}
