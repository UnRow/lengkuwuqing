package org.leadfar.raiden.utils;

import java.util.Properties;

import org.leadfar.raiden.model.Collider;
import org.leadfar.raiden.model.FireStrategy;

public class CollidersConfiguration {
	private static Properties prop;
	static{
		prop=PropertyFileUtils.read("colliders.propreties");
	}
	public static  int size(){
		return prop.size();
	}
	public static String getColliderClassName(String f){
		try{
			return prop.getProperty(f);
			
		}catch(Exception e){
			return null;
		}
		
	}
	
	public static Collider getColliderInstance(String c){
		
		String className=getColliderClassName(c);
		if(className!=null){
			try {
				return (Collider)Class.forName(className).newInstance();
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
