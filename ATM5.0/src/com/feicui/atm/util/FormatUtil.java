package com.feicui.atm.util;

import java.text.SimpleDateFormat;

public class FormatUtil {

	public static String formatUtil(String timeType, Object obj) {

		SimpleDateFormat format = new SimpleDateFormat(timeType);
		String date = format.format(obj);

		return date;
	}

}
