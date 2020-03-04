package com.xuxin.xl050224storeback.util;

import java.util.UUID;

public class UUIDUtils {

	
	 public static String getUUID(){
	        return UUID.randomUUID().toString().replace("-", "");
	 }
}
