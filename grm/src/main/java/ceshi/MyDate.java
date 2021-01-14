package ceshi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MyDate {
	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		df2.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date = null;
		date = df.parse("2020-10-24T07:50:20.358Z");
		String value = df2.format(date);
		System.out.println(value);
	}
}
