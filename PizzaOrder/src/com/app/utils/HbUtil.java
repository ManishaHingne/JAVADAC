package com.app.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HbUtil {
	private static SessionFactory factory = buildSessionFactory();
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		Configuration cfg = new Configuration(); // empty config object
		cfg.configure(); // read config xml file. 
		return cfg.buildSessionFactory(); //create session factory
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
