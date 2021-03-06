package teacherintouch.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import teacherintouch.dao.StudentTeacherDAO;
import teacherintouch.dao.rowmapper.RowMapper;
import teacherintouch.dao.rowmapper.impl.StudentTeacherRowMapper;
import teacherintouch.dao.util.DBUtil;
import teacherintouch.data.objects.Student;
import teacherintouch.data.objects.StudentTeacher;
import teacherintouch.data.objects.Teacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentTeacherDAOImpl implements StudentTeacherDAO {
	private static final RowMapper<StudentTeacher> rowMapper = new StudentTeacherRowMapper();


	@Override
	public Collection<StudentTeacher> findAll() {
		Connection c = null;
		PreparedStatement ps = null;
		String query = "SELECT * FROM student_teacher";
		ResultSet rs = null;
		List<StudentTeacher> students = new ArrayList<StudentTeacher>();
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();

			int rowNum = 1;
			while(rs.next()) {
				StudentTeacher st = new StudentTeacher();
				st = rowMapper.mapRow(rs, rowNum);
				students.add(st);
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
	public Collection<StudentTeacher> findAllStudentsOfTeacher(int teacherID) {
		Connection c = null;
		PreparedStatement ps = null;
		String query = "SELECT * FROM student_teacher where teacher_id = ?";
		ResultSet rs;
		Collection<StudentTeacher> stLinks = new ArrayList<StudentTeacher>();
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, teacherID);
			rs = ps.executeQuery();

			int rowNum = 1;
			while(rs.next()) {
				StudentTeacher st = new StudentTeacher();
				st = rowMapper.mapRow(rs, rowNum);
				stLinks.add(st);
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
		
		return stLinks;
	}

	@Override
	public boolean insertStudent(Student s, Teacher t) {
		Connection c = null;
		PreparedStatement ps = null;
		String query = "INSERT INTO student_teacher VALUES(?, ?)";
		int rowsAffected = 0;
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, t.getId());
			ps.setInt(2, s.getId());
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
