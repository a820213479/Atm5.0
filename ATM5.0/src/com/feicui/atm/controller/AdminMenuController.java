package com.feicui.atm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.feicui.atm.util.PrintUtil;
import com.feicui.atm.util.Scan;
import com.feicui.atm.view.ViewShow;

public class AdminMenuController {

	public void adminMenuController() {

		PrintUtil.printFromProperties("A03");

		// 1.开户2.销户3.检索普通账户4.检索已销户账户5.检索锁定账户6.解除锁定账户7.重置密码8.返回登录界面
		while (true) {

			// 输入1-8选择功能,输入其他按键提示输入有误,重新进行按键选择
			ViewShow vs = new ViewShow();
			vs.adminMenu();

			String str = Scan.scanString();

			// 如果输入1-7,调用execute方法
			if ("1".equals(str) || "2".equals(str) || "3".equals(str) || "4".equals(str) || "5".equals(str)
					|| "6".equals(str) || "7".equals(str)) {

				Properties prop = new Properties();

				try {

					prop.load(new FileInputStream(new File("admin.properties")));
					String className = prop.getProperty(str);

					Object obj = Class.forName(className).newInstance();
					AbstractController al = (AbstractController) obj;
					al.execute();

					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}
			// 如果输入8,返回登录界面
			else if ("8".equals(str)) {

				return;
			}
			// 输入其他按键返回重新进行选择
			else {

				System.out.println("输入有误,请重新输入!");
			}

		}
	}
}
