package teacherintouch.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import teacherintouch.dao.TeacherDAO;
import teacherintouch.dao.rowmapper.RowMapper;
import teacherintouch.dao.rowmapper.impl.TeacherRowMapper;
import teacherintouch.dao.util.DBUtil;
import teacherintouch.data.objects.Teacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public class TeacherDAOImpl implements TeacherDAO {
	private static final RowMapper<Teacher> rowMapper = new TeacherRowMapper();
	
	@Override
	public Teacher findByPrimaryKey(int teacherID) {
		Connection c = null;
		PreparedStatement ps = null;
		String query = "SELECT * FROM teacher where id = ?";
		ResultSet rs = null;
		Teacher t = null;
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			ps.setInt(1, teacherID);
			rs = ps.executeQuery();

			if(rs.next()) {
				t = rowMapper.mapRow(rs, 1);
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
		
		return t;
	}

	@Override
	public Collection<Teacher> findAll() {
		Connection c = null;
		PreparedStatement ps = null;
		String query = "SELECT * FROM teacher";
		ResultSet rs = null;
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();

			int rowNum = 1;
			while(rs.next()) {
				Teacher t = new Teacher();
				t = rowMapper.mapRow(rs, rowNum);
				teachers.add(t);
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
		
		return teachers;
	}

	@Override
	public boolean insertTeacher(Teacher t) {
		Connection c = null;
		PreparedStatement ps = null;
		String query = "INSERT INTO teacher VALUES(NULL, ?, ?, ?, ?, ?, ?)";
		int rowsAffected = 0;
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query);
			ps.setString(1, t.getFirstName());
			ps.setString(2, t.getLastName());
			ps.setString(3, t.getGender());
			ps.setString(4, t.getHomeroom());
			ps.setInt(5, t.getGrade());
			ps.setString(6, t.getEmail());
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
