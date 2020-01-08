package com.gwxtd.core.common;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateId {
	public static String generateId(){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmssSS");
		String dateStr=dateFormat.format(new Date());
		String rStr=Math.random()+"";
		String rStrCut=rStr.substring(rStr.length()-5,rStr.length());
		return dateStr+rStrCut;
	}
}
