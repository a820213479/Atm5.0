package com.feicui.atm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.feicui.atm.controller.AbstractController;

public class PropUtil {

	public void propUtil(String propName, String clazzName) {

		try {

			Properties prop = new Properties();

			prop.load(new FileInputStream(new File(propName)));

			String className = prop.getProperty(clazzName);

			Object obj = Class.forName(className).newInstance();
			AbstractController ac = (AbstractController) obj;
			ac.execute();

		} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
