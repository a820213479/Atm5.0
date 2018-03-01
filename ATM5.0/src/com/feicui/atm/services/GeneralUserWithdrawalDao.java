package com.feicui.atm.services;

import java.util.Date;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.AddBillDao;
import com.feicui.atm.dao.UpdateBalanceDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.util.FormatUtil;
import com.feicui.atm.util.Scan;

/**
 * 用户取款存储
 *
 * @author 刘政
 * @创建时间 2018年2月23日 下午7:57:59
 */
public class GeneralUserWithdrawalDao extends AbstractController {

	String wTime = FormatUtil.formatUtil("yyyy-MM-dd HH:mm:ss", new Date());

	@Override
	public void execute(User user) {

		here:while (true) {
			System.out.println("请输入取款金额:");
			double money;
			while (true) {

				money = Scan.scanDouble();

				// 判断输入的取款金额是不是100的整数倍并且是否小于等于账户余额
				if (money % 100 == 0 && money <= user.getBalance() && money >= 0) {

					break;
				} else if (money % 100 != 0 && money <= user.getBalance() || money < 0) {
					System.out.println("请输入大于0的100的整数倍取款金额!");

				} else if (money % 100 != 0 && money > user.getBalance()) {
					System.out.println("余额不足,请输入100的整数倍取款金额!");

				} else if (money % 100 == 0 && money > user.getBalance()) {
					System.out.println("余额不足!");

				} else {
					System.out.println("输入有误,请重新输入!");
				}
			}

			System.out.println("1.确认\n2.重新输入\n3.返回主菜单");
			String wIndex2;
			while (true) {
				wIndex2 = Scan.scanString();

				// 如果输入1,确认取款
				if ("1".equals(wIndex2)) {

					double bal = user.getBalance() - money;
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
					System.out.println("成功取款:" + money + "元");
					System.out.println("存款时间:" + wTime);
					System.out.println("取款成功,正在返回主菜单!");
					System.out.println("返回主菜单成功!");
					break here;
				} else if ("2".equals(wIndex2)) {
					break;
				} else if ("3".equals(wIndex2)) {

					System.out.println("正在返回主菜单!");
					System.out.println("返回主菜单成功!");
					break here;
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
