package teacherintouch.dao.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * @author bryanpeterson
 *
 */
public class DBUtil {
	private static DataSource ds = null;
	static {
		Context ctx = null;
		
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/teacherintouch");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor
	 */
	private DBUtil() {
		
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
