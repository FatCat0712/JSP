package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class JDBCUtil {
	public static Connection connect() {
		Connection c = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			String sql = "jdbc:mySQL://10.10.10.5:3306/bookstore?useUnicode=true&characterSetResults=utf8&characterEncoding=UTF-8";
			String username = "root";
			String password = "root123";
			c = DriverManager.getConnection(sql,username,password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static void disconnect(Connection c) {
		if(c != null) {
			try {
				c.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			DatabaseMetaData mtdt = (DatabaseMetaData)c.getMetaData();
			System.out.println(mtdt.getDatabaseProductName());
			System.out.println(mtdt.getDatabaseProductVersion());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
