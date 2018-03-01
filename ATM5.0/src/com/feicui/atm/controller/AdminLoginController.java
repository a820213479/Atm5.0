package com.feicui.atm.controller;

import com.feicui.atm.entity.User;
import com.feicui.atm.services.UserServices;
import com.feicui.atm.util.PrintUtil;
import com.feicui.atm.util.Scan;

/**
 * 管理员用户登录
 *
 * @author 刘政
 * @创建时间 2018年2月10日 下午3:14:18
 */
public class AdminLoginController extends AbstractController {

	@Override
	public void execute() {

		PrintUtil.printFromProperties("A01");

		here: while (true) {
			String adminAccount = Scan.scanString();

			String sql = "select count(account) as number from atm_user where account = '" + adminAccount
					+ "'&& type = 1 ;";
			UserServices us = new UserServices();

			Boolean bln = us.userNumServies(sql);

			if (bln.equals(false)) {

				PrintUtil.printFromProperties("E01");
			} else {

				PrintUtil.printFromProperties("A02");

				while (true) {

					String inputPassword = Scan.scanString();
					String sql1 = "select password from atm_user where account = '" + adminAccount + "' && type = 1 ;";

					Boolean bln1 = us.userAccountServies(sql1, inputPassword);

					if (bln1.equals(true)) {

						PrintUtil.printFromProperties("S01");
						AdminMenuController amc = new AdminMenuController();
						amc.adminMenuController();
						break here;
					} else {

						PrintUtil.printFromProperties("E02");

					}
				}
			}
		}
	}

	@Override
	public void execute(User user) {
		
	}
}
