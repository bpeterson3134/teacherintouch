package teacherintouch.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import teacherintouch.dao.StudentDAO;
import teacherintouch.dao.rowmapper.RowMapper;
import teacherintouch.dao.rowmapper.impl.StudentRowMapper;
import teacherintouch.dao.util.DBUtil;
import teacherintouch.data.objects.Student;


/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentDAOImpl implements StudentDAO {
	private static final RowMapper<Student> rowMapper = new StudentRowMapper();
	
	@Override
	public Student findByPrimaryKey(int studentID) {;
		Connection c = null;
		PreparedStatement ps = null;
		String query = "SELECT * FROM student where id = ?";
		ResultSet rs;
		Student s = null;
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, studentID);
			rs = ps.executeQuery();

			if(rs.next()) {
				s = rowMapper.mapRow(rs, 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return s;
	}

	@Override
	public Collection<Student> findAll() {
		Connection c = null;
		PreparedStatement ps = null;
		String query = "SELECT * FROM student";
		ResultSet rs;
		List<Student> students = new ArrayList<Student>();
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();

			int rowNum = 1;
			if(rs.next()) {
				Student s = new Student();
				s = rowMapper.mapRow(rs, rowNum);
				students.add(s);
				rowNum++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return students;
	}

	@Override
	public boolean insertStudent(Student s) {
		Connection c = null;
		PreparedStatement ps = null;
		String query = "INSERT INTO student VALUES(NULL, ?, ?, ?, ?)";
		int rowsAffected = 0;
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			ps.setString(1, s.getFirstName());
			ps.setString(2, s.getLastName());
			ps.setString(3, s.getGender());
			ps.setInt(4, s.getHomeroomTeacherID());
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowsAffected > 0;
		
	}

	@Override
	public boolean updateStudent(Student s) {
		Connection c = null;
		PreparedStatement ps = null;
		StringBuilder query = new StringBuilder("UPDATE student");
		query.append("SET first_name=?, last_name=?, gender=?, homeroom_teacher_id=?");
		query.append("WHERE id=?");
		int rowsAffected = 0;
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query.toString());
			ps.setString(1, s.getFirstName());
			ps.setString(2, s.getLastName());
			ps.setString(3, s.getGender());
			ps.setInt(4, s.getHomeroomTeacherID());
			ps.setInt(5, s.getId());
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rowsAffected > 0;
		
	}

}