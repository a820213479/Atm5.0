package com.feicui.atm.services;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.entity.User;

public class GeneralUserQueryMessage extends AbstractController {

	@Override
	public void execute(User user) {

		
		System.out.println(user.getAccount());
		String gen;
		if (user.getGender() == 1) {
			gen = "男";

		} else {

			gen = "女";
		}

		// 显示用户信息
		System.out.println(
				"id:" + user.getId() + ",姓名:" + user.getUserName() + ",身份证号:" + user.getIdCardNumber() + ",性别:" + gen
						+ ",出生日期:" + user.getBirthday() + ",联系地址:" + user.getAddress() + ",账户余额:" + user.getBalance()
						+ ",账号:" + user.getAccount() + ",密码:" + user.getPassword() + ",备注:" + user.getRemark());

		/*System.out.println("返回上一级请按  1");
		// 选择返回上一层按键 1 时,从查询界面返回菜单界面,输入其他字符提示:输入有误,请重新输入!
		while (true) {
			String returnMenu = Scan.scanString();
			if (returnMenu.equals("1")) {
				break;
			} else {
				System.out.println("输入有误,请重新输入!");
			}
		}
*/
	}

	@Override
	public void execute() {

	}

}
