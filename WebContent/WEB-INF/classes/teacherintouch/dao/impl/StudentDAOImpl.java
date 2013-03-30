package teacherintouch.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import teacherintouch.dao.StudentDAO;
import teacherintouch.data.objects.Student;


/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentDAOImpl implements StudentDAO {

	@Override
	public Collection<Student> findByPrimaryKey(int studentID) {
		Context ctx;
		DataSource ds;
		Connection c;
		PreparedStatement ps;
		String query = "SELECT FROM Student where id = ?";
		ResultSet rs;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/teacherintouch");
			c = ds.getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, studentID);
			rs = ps.executeQuery();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Collection<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> findByTeacher(int teacherIDd) {
		// TODO Auto-generated method stub
		return null;
	}

}