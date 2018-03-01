package com.feicui.atm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 选择登录用户类型视图的读取
 *
 * @author 刘政
 * @创建时间 2018年2月26日 下午7:50:00
 */
public class ViewUtil {

	public static void printText(String fileName) {

		try {

			InputStream is = ViewUtil.class.getClassLoader().getResourceAsStream(fileName);

			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader br = new BufferedReader(isr);

			String strLine = null;

			while ((strLine = br.readLine()) != null) {

				System.out.println(strLine);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
