package teacherintouch.dao.rowmapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import teacherintouch.dao.rowmapper.RowMapper;
import teacherintouch.data.objects.Student;
import teacherintouch.data.objects.StudentTeacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentTeacherRowMapper implements RowMapper<StudentTeacher> {

	@Override
	public StudentTeacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentTeacher st = new StudentTeacher();
		st.setStudentID(rs.getInt(1));
		st.setTeacherID(rs.getInt(2));
		return st;
	}

}
