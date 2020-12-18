package org.leadfar.raiden.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtils {

	public static Properties read(String fileName){
		InputStream in=PropertyFileUtils.class.getClassLoader().getResourceAsStream(fileName);
		Properties prop=new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	
}
