package com.feicui.atm.util;

import java.util.Scanner;

/**
 * Scanner工具类
 *
 * @author 刘政
 * @创建时间 2018年2月10日 下午3:04:32
 */
public class Scan {

	/**
	 * int型Scanner输入
	 * 
	 * @return int 输入的int值
	 */
	public static Integer scanInt() {

		Scanner scanner = new Scanner(System.in);
		Integer index = scanner.nextInt();

		return index;

	}

	/**
	 * String型Scanner输入
	 * 
	 * @return String 输入的字符串
	 */
	public static String scanString() {

		Scanner scanner = new Scanner(System.in);
		String index = scanner.nextLine();

		return index;

	}

	/**
	 * double型Scanner输入
	 * 
	 * @return double 输入的double值
	 */
	public static Double scanDouble() {

		Scanner scanner = new Scanner(System.in);
		Double index = scanner.nextDouble();

		return index;

	}
}
