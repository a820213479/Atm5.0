package com.feicui.atm.services;

import java.util.Date;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.AddBillDao;
import com.feicui.atm.dao.UpdateBalanceDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.util.FormatUtil;
import com.feicui.atm.util.Scan;

public class GeneralUserBankSavingsServices extends AbstractController {

	@Override
	public void execute(User user) {

		String dTime = FormatUtil.formatUtil("yyyy-MM-dd HH:mm:ss", new Date());

		here: while (true) {

			System.out.println("请输入存款金额:");
			double money;

			while (true) {

				money = Scan.scanDouble();

				// 如果存款金额不是100的整数倍,则重新输入
				if (money % 100 == 0 && money > 0) {

					break;
				} else if (money % 100 != 0 || money < 0) {

					// 输入存款金额不是100的整数倍,则提示重新输入
					System.out.println("请输入0以上且为100的整数倍存款金额!");

				} else {

					System.out.println("输入有误,请重新输入!");
				}

			}

			// 如果是100的整数倍,则提示确认存款或重新输入
			System.out.println("1.确认存款\n2.重新输入\n3.返回主菜单");
			String dIndex2;

			while (true) {

				dIndex2 = Scan.scanString();
				if ("1".equals(dIndex2)) {

					// 如果确认存款,则更新当前用户流水信息与用户余额信息
					double bal = user.getBalance() + money;
					user.setBalance(bal);

					String sql = "update atm_user set balance = " + user.getBalance() + " where account = '"
							+ user.getAccount() + "';";
					UpdateBalanceDao ubd = new UpdateBalanceDao();
					ubd.updateMoney(sql);

					// 存储流水
					String id = FormatUtil.formatUtil("yyyyMMddHHmmssSSS", new Date());
					String time = FormatUtil.formatUtil("yyyy-MM-dd HH:mm:ss", new Date());
					String targetAccount = user.getAccount();
					AddBillDao abd = new AddBillDao(user);
					abd.addBillDao(id, targetAccount, time, money);

					// 存款成功之后提示存款成功,并返回上一级
					System.out.println("成功存款:" + money + "元");
					System.out.println("存款时间:" + dTime);
					System.out.println("存款成功,正在返回主菜单!");
					System.out.println("返回主菜单成功!");
					break here;

				} else if ("2".equals(dIndex2)) {

					// 如果输入2,则重新选择存款金额
					break;

				} else if ("3".equals(dIndex2)) {

					// 如果输入3,则返回主菜单
					System.out.println("正在返回主菜单!");
					System.out.println("返回主菜单成功!");
					break here;

				} else {

					// 输入其他按键提示输入有误,并重新输入
					System.out.println("输入有误,请重新输入!");
					

				}
			}

		}

	}

	@Override
	public void execute() {
		
	}

}
