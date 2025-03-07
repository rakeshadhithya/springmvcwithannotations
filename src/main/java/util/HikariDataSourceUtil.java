package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//you can do this directly in the applicationcontext.xml as spring bean scope is singleton
//first define hikariconfig class and set properties
//next send hikariconfig to the constructor of hikari datasource
//that's it
public class HikariDataSourceUtil {

	private static volatile HikariDataSource dataSource;
	
	public static HikariDataSource getHikariDataSource() {
		if(dataSource == null) {
            //use class as lock not object(objects are different, class is only one)
			synchronized(HikariDataSourceUtil.class) {
				if(dataSource == null) {
					HikariConfig hikariConfig = new HikariConfig();
					hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
					//not a http connection, it is a jdbc connection to mysql server
					//wrong: hikariConfig.setJdbcUrl("http://localhost:3306/studenttribedb");
					//correct version:
					hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/rakeshdb");
					hikariConfig.setUsername("root");
					hikariConfig.setPassword("root");
					hikariConfig.setMaximumPoolSize(5);
					hikariConfig.setMinimumIdle(2);
					
					HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
					dataSource = hikariDataSource;
				}
			}
		}
		return dataSource;
	}
}

/*
Using the this keyword in the synchronized block synchronizes on the instance of the DatasourceProvider class. 
This means that if there were multiple instances of DatasourceProvider, each one would have its own lock, which 
wouldn't guarantee thread safety for the shared dataSource variable. that's why use DatasourceProvider.class(single lock) instead
 */
/*
Volatile ensures that a variable's value is consistently updated and visible across all threads. 
Double-checked locking minimizes synchronization overhead by first checking if the instance is initialized 
outside of a synchronized block, and then ensuring only one thread initializes it inside the synchronized block
 */