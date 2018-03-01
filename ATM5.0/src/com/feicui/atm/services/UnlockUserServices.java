package com.feicui.atm.services;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.UnlockUserDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.util.PrintUtil;
import com.feicui.atm.util.Scan;

public class UnlockUserServices extends AbstractController {

	@Override
	public void execute() {

		while (true) {
			PrintUtil.printFromProperties("A14");
			String unlock_Account = Scan.scanString();

			String sql = "select count(account) as number from atm_user where account = '" + unlock_Account
					+ "' && type != 1;";
			UserServices us = new UserServices();
			Boolean bln = us.userNumServies(sql);
			if (bln.equals(true)) {

				UnlockUserDao uud = new UnlockUserDao();
				uud.unlockUserDao(unlock_Account);
				PrintUtil.printFromProperties("S05");
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
