package com.feicui.atm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	public static Connection jdbcUtil()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Properties prop = new Properties();

		prop.load(new FileInputStream(new File("class.properties")));

		String path = prop.getProperty("path");
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		Class.forName(path);
		Connection con = DriverManager.getConnection(url,user,password);

		return con;

	}

	 
}
