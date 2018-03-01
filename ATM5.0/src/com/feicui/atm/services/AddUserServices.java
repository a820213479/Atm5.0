package com.feicui.atm.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.feicui.atm.controller.AbstractController;
import com.feicui.atm.dao.AddUserDao;
import com.feicui.atm.entity.User;
import com.feicui.atm.util.FormatUtil;
import com.feicui.atm.util.PrintUtil;
import com.feicui.atm.util.Scan;

public class AddUserServices extends AbstractController {

	User user = new User();

	@Override
	public void execute() {

		// 输入用户姓名,姓名长度不等于0且不大于20
		PrintUtil.printFromProperties("A04");
		String userName;

		// 如果输入的姓名不符合要求格式,则返回重新输入
		while (true) {

			userName = Scan.scanString();

			// 如果输入的用户名长度大于20或等于0,给出错误信息
			if (userName.length() > 20 || userName.length() == 0) {

				PrintUtil.printFromProperties("E03");
				continue;
			}

			user.setUserName(userName);
			break;
		}

		// 输入身份证号,身份证号输入后不可修改
		PrintUtil.printFromProperties("A05");
		PrintUtil.printFromProperties("T01");

		String idCardNumber;

		// 如果输入的身份证号不符合要求格式,则返回重新输入
		while (true) {

			idCardNumber = Scan.scanString();

			// 身份证号由18位数字组成,输入不符合规范则重新进行输入
			if (!idCardNumber.matches("[0-9]{17}[0-9x]{1}")) {

				PrintUtil.printFromProperties("E04");
				continue;
			}
			user.setIdCardNumber(idCardNumber);
			break;
		}

		// 选择性别,性别选择后用于户账号生成
		PrintUtil.printFromProperties("A06");
		PrintUtil.printFromProperties("T02");
		Integer gender;

		// 如果输入的性别不符合要求格式,则返回重新输入
		while (true) {

			gender = Scan.scanInt();

			// 如果输入1,储存结果
			if (gender == 1) {

				user.setGender(gender);
				break;

			} else if (gender == 2) {

				user.setGender(gender);
				break;
			} else {

				PrintUtil.printFromProperties("E05");
			}
		}

		//
		PrintUtil.printFromProperties("A07");
		String birthday;

		while (true) {

			birthday = Scan.scanString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {

				user.setBirthday(sdf.parse(birthday));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;

		}

		// 输入联系地址,长度不等于0且不大于50
		PrintUtil.printFromProperties("A08");
		String address;

		while (true) {

			address = Scan.scanString();
			if (address.length() > 50 || address.length() == 0) {

				PrintUtil.printFromProperties("E06");
				continue;
			}

			user.setAddress(address);
			break;
		}

		// 自动根据性别和出生日期生成账号
		String account = "BC0" + gender + birthday.replaceAll("-", "") + (int) ((Math.random() * 9 + 1) * 1000);
		user.setAccount(account);

		// 设置用户密码,密码要求为6位,包含阿拉伯数字,大写英文字母和小写英文字母
		PrintUtil.printFromProperties("A09");
		String password;

		while (true) {

			password = Scan.scanString();

			if (!password.matches("[0-9a-zA-Z]{6}")) {

				PrintUtil.printFromProperties("E07");
				continue;
			}

			user.setPassword(password);
			break;
		}

		// 默认初始余额为0.0元
		Double balance = 0.0;
		user.setBalance(balance);

		// 默认获得账号类型为 2:普通用户
		Integer type = 2;
		user.setType(type);

		// 默认账户状态为 1:正常状态
		Integer state = 1;
		user.setState(state);

		PrintUtil.printFromProperties("A10");
		String remark = Scan.scanString();
		user.setRemark(remark);

		// 生成时间戳,用于唯一主键的生成
		String id = FormatUtil.formatUtil("yyyyMMddHHmmssSSS", new Date());
		user.setId(id);

		// 账号生成后调用存储方法存入数据库
		AddUserDao aud = new AddUserDao(user);
		aud.addUserDao();

		// 存储成功后提示新增成功并返回上一级
		System.out.println("开户成功,用户账号为:" + account + ",请牢记账号密码!");
		PrintUtil.printFromProperties("S02");
		PrintUtil.printFromProperties("S03");

	}

	@Override
	public void execute(User user) {
		
	}

}
