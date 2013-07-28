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
	public Student findByPrimaryKey(int studentID) {
		Connection c = null;
		PreparedStatement ps = null;
		String query = "SELECT * FROM student where id = ?";
		ResultSet rs = null;
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
				rs.close();
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
		ResultSet rs = null;
		List<Student> students = new ArrayList<Student>();
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();

			int rowNum = 1;
			while(rs.next()) {
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
				rs.close();
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
		String query = "INSERT INTO student VALUES(NULL, ?, ?, ?, ?, ?)";
		int rowsAffected = 0;
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, s.getFirstName());
			ps.setString(2, s.getLastName());
			ps.setString(3, s.getGender());
			if (s.getHomeroomTeacherID() == null) {
				ps.setNull(4, java.sql.Types.INTEGER);
			} else {
				ps.setInt(4,s.getHomeroomTeacherID());
			}
			ps.setInt(5, s.getGrade());
			rowsAffected = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			Integer key = null;
			if(rs !=null && rs.next()) {
				key = rs.getInt(1);
			}
			s.setId(key);
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
		StringBuilder query = new StringBuilder("UPDATE student").append(" ");
		query.append("SET first_name=?, last_name=?, gender=?, homeroom_teacher_id=?, grade=?").append(" ");
		query.append("WHERE id=?");
		int rowsAffected = 0;
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query.toString());
			ps.setString(1, s.getFirstName());
			ps.setString(2, s.getLastName());
			ps.setString(3, s.getGender());
			if (s.getHomeroomTeacherID() == null) {
				ps.setNull(4, java.sql.Types.INTEGER);
			} else {
				ps.setInt(4,s.getHomeroomTeacherID());
			}
			ps.setInt(5, s.getGrade());
			ps.setInt(6, s.getId());
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
	public boolean deleteStudent(Student s) {
		Connection c = null;
		PreparedStatement ps = null;
		StringBuilder query = new StringBuilder("DELETE FROM student").append(" ");
		query.append("WHERE id=?");
		int rowsAffected = 0;
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query.toString());
			if (s.getId() == null) {
				ps.setNull(1, java.sql.Types.INTEGER);
			} else {
				ps.setInt(1,s.getId());
			}
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