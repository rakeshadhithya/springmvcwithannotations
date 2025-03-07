package util;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil{
	
	private static volatile SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			synchronized(SessionFactoryUtil.class) {
				Configuration configuration = new Configuration();
				//for object value to put, getProperties().put
				configuration.getProperties().put("hibernate.connection.datasource", HikariDataSourceUtil.getHikariDataSource());
				//for string, int, boolean, .class value, just setProperty
				configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
				configuration.setProperty("hibernate.hbm2ddl.auto", "update");
				configuration.setProperty("hibernate.show_sql", true);

				//add mapping annotated classes(in xml mapping resource)
				configuration.addAnnotatedClass(entity.Employee.class);
				//build session factory
				sessionFactory = configuration.buildSessionFactory();
			}
		}	
		return sessionFactory;
		
	}
	
	public static void closeSessionFactory(SessionFactory sessionFactory) {
		sessionFactory.close();
		System.out.println("session factory successfully closed");
	}
}