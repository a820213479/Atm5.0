package com.feicui.atm.services;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.DeleteUserDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.util.PrintUtil;
import com.feicui.atm.util.Scan;

public class DeleteUserServices extends AbstractController {

	@Override
	public void execute() {

		while (true) {
			PrintUtil.printFromProperties("A13");
			String del_Account = Scan.scanString();

			String sql = "select count(account) as number from atm_user where account = '" + del_Account
					+ "' && type != 1;";
			UserServices us = new UserServices();
			Boolean bln = us.userNumServies(sql);
			if (bln.equals(true)) {

				DeleteUserDao dud = new DeleteUserDao();
				dud.deleteUserDao(del_Account);
				PrintUtil.printFromProperties("S04");
				break;
			} else {

				PrintUtil.printFromProperties("E01");
			}
		}
	}

	@Override
	public void execute(User user) {
		
	}

}
