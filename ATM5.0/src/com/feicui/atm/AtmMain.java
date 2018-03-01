package com.feicui.atm;

import com.feicui.atm.util.PrintUtil;
import com.feicui.atm.util.PropUtil;
import com.feicui.atm.util.Scan;
import com.feicui.atm.view.ViewShow;

public class AtmMain {

	public static void main(String[] args) {

		while (true) {

			atmRun();
		}

	}

	/**
	 * 进行管理员用户或普通用户的选择
	 */
	public static void atmRun() {

		// 输入按键1.管理员登录用户,按键2.普通用户登录,输入其他按键提示输入有误,重新进行输入
		while (true) {

			// 进入登录界面,选择登录的用户类型
			ViewShow vs = new ViewShow();
			vs.loginView();
			
			String loginNum = Scan.scanString();
			PropUtil pu = new PropUtil();

			if ("1".equals(loginNum)) {

				pu.propUtil("class.properties", "adminLogin");

			} else if ("2".equals(loginNum)) {

				pu.propUtil("class.properties", "generalUserLogin");

			} else {

				PrintUtil.printFromProperties("E08");
			}
		}
	}
}
