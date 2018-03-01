package com.feicui.atm.services;

import com.feicui.atm.dao.GetMessageDao;
import com.feicui.atm.entity.User;

public class GetMessageServices {

	public void getMessageServices(User user, String userAccount) {

		String sql = "select id,userName,idCardNumber,gender,birthday,address,balance,account,password,type,state,remark from atm_user where (account = '"
				+ userAccount + "' or idCardNumber ='" + userAccount + "') && state = 1 && type != 1;";

		GetMessageDao gmd = new GetMessageDao(user);
		gmd.getMessageDao(sql);
	}
}
