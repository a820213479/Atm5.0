package com.feicui.atm.services;

import java.util.Date;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.AddBillDao;
import com.feicui.atm.dao.GeneralUserTransferDao;
import com.feicui.atm.dao.UpdateBalanceDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.util.FormatUtil;
import com.feicui.atm.util.PrintUtil;
import com.feicui.atm.util.Scan;

/**
 *
 *
 * @author 刘政
 * @创建时间 2018年2月26日 下午3:28:58
 */
public class GeneralUserTransferServices extends AbstractController {

	String tTime = FormatUtil.formatUtil("yyyy-MM-dd HH:mm:ss", new Date());

	@Override
	public void execute(User user) {

		here: while (true) {
			System.out.println("请输入对方银行卡号:");
			String indexAccount;

			// 判断账号是否存在
			while (true) {

				indexAccount = Scan.scanString();

				String sql = "select count(account) as number from atm_user where account = '" + indexAccount
						+ "'&& type != 1 && state = 1;";
				UserServices us = new UserServices();

				Boolean bln = us.userNumServies(sql);

				// 如果账号存在,跳出循环
				if (bln.equals(false)) {

					PrintUtil.printFromProperties("E01");
				} else {
					break;
				}

			}

			System.out.println("请输入转账金额:");
			double money;
			while (true) {

				money = Scan.scanDouble();

				if (money >= 0 && money <= user.getBalance()) {

					System.out.println("1.确认\n2.重新输入\n3.返回主菜单");

					String index = Scan.scanString();

					while (true) {
						if (index.equals("1")) {

							System.out.println("1.确认转账\n2.返回上一级");
							String index2 = Scan.scanString();

							if (index2.equals("1")) {

								double bal = user.getBalance() - money;
								user.setBalance(bal);

								String sql = "update atm_user set balance = " + bal + " where account = '"
										+ user.getAccount() + "';";
								UpdateBalanceDao ubd = new UpdateBalanceDao();
								ubd.updateMoney(sql);

								// 储存流水
								String id = FormatUtil.formatUtil("yyyyMMddHHmmssSSS", new Date());
								String time = FormatUtil.formatUtil("yyyy-MM-dd HH:mm:ss", new Date());
								String targetAccount = indexAccount;
								AddBillDao abd = new AddBillDao(user);
								abd.addBillDao(id, targetAccount, time, money);

								String sql1 = "select balance from atm_user where account = '" + indexAccount + "';";

								GeneralUserTransferDao gutd = new GeneralUserTransferDao(user);
								double balance = gutd.targetUserTransferDao(sql1);
								double newBalance = balance + money;
								
								String sql2 = "update atm_user set balance = " + newBalance + " where account = '"
										+ indexAccount + "';";
								gutd.targetBillDao(sql2);
								
								
								
								String id1 = FormatUtil.formatUtil("yyyyMMddHHmmssSSS", new Date());
								gutd.targetBillDao(id1, indexAccount, time, money, newBalance);

								System.out.println("成功转账:" + money + "元");
								System.out.println("存款时间:" + tTime);
								System.out.println("转账成功,正在返回主菜单!");
								System.out.println("返回主菜单成功!");

								break here;
							} else if (index2.equals("2")) {

								System.out.println("正在返回上一级...");
								break here;

							} else if (index2.equals("3")) {

								// 退卡

							} else {

								System.out.println("输入有误,请重新输入!");
							}
						} else if ("2".equals(index)) {

							break;

						} else {

							System.out.println("输入有误,请重新输入!");

						}

					}
				} else if (money > user.getBalance()) {

					System.out.println("余额不足!");

				} else {

					System.out.println("输入有误,请重新输入!");

				}

			}
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
