package com.feicui.atm.services;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.ChangePasswordDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.util.PrintUtil;
import com.feicui.atm.util.Scan;

public class ChangePasswordServices extends AbstractController {

	@Override
	public void execute() {

		here: while (true) {
			PrintUtil.printFromProperties("A11");
			String changePw_Account = Scan.scanString();

			String sql = "select count(account) as number from atm_user where account = '" + changePw_Account
					+ "' && state = 1;";
			UserServices us = new UserServices();
			Boolean bln = us.userNumServies(sql);
			if (bln.equals(true)) {

				PrintUtil.printFromProperties("A15");

				while (true) {

					String newPassword = Scan.scanString();

					if (!newPassword.matches("[0-9a-zA-Z]{6}")) {

						PrintUtil.printFromProperties("E07");
						continue;
					}

					PrintUtil.printFromProperties("A16");
					String newPassword2 = Scan.scanString();

					if (newPassword2.equals(newPassword)) {

						ChangePasswordDao cpd = new ChangePasswordDao();
						cpd.changePasswordDao(newPassword,changePw_Account);
						PrintUtil.printFromProperties("S06");
						break here;

					} else {

						PrintUtil.printFromProperties("E09");
					}
				}
			} else {

				PrintUtil.printFromProperties("E01");
			}

		}

	}

	@Override
	public void execute(User user) {
		
	}

}
