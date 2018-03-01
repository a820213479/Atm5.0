package com.feicui.atm.view;

import com.feicui.atm.util.ViewUtil;

/**
 * 功能选择视图
 *
 * @author 刘政
 * @创建时间 2018年2月26日 下午7:48:15
 */
public class ViewShow {

	/**
	 * 登录用户选选择视图
	 */
	public void loginView() {

		ViewUtil.printText("login.txt");
	}

	/**
	 * 管理员菜单功能视图
	 */
	public void adminMenu() {

		ViewUtil.printText("adminMenu.txt");
	}

	/**
	 * 普通用户功能视图
	 */
	public void generalUserMenu() {

		ViewUtil.printText("generalUserMenu.txt");
	}
}
