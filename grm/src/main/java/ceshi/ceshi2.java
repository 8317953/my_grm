package ceshi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ceshi2 {
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");
		Date date=new Date();
		String str=sdf.format(date);
		System.out.println(str);
	}
}
