package org.leadfar.raiden.utils;

import java.util.Properties;

import org.leadfar.raiden.model.FireStrategy;

public class FireStrategyConfiguration {
	private static Properties prop;
	static{
		prop=PropertyFileUtils.read("fire_stratey.propreties");
	}
	
	public static String getStrategyClassName(String f){
		try{
			return prop.getProperty(f);
			
		}catch(Exception e){
			return null;
		}
		
	}
	
	public static FireStrategy getStrategyInstance(String f){
		
		String className=getStrategyClassName(f);
		if(className!=null){
			try {
				return (FireStrategy)Class.forName(className).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
