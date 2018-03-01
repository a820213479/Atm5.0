package com.feicui.atm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PrintUtil {

	public static String getValueFromProp(String key) {

		Properties prop = new Properties();

		try {

			prop.load(new FileInputStream(new File("class.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = prop.getProperty(key);

		return value;
	}

	public static void printFromProperties(String key) {

		System.out.println(getValueFromProp(key));

	}
}
