package teacherintouch.dao.rowmapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import teacherintouch.dao.rowmapper.RowMapper;
import teacherintouch.data.objects.Teacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public class TeacherRowMapper implements RowMapper<Teacher> {

	@Override
	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		Teacher t = new Teacher();
		t.setId(rs.getInt(1));
		t.setFirstName(rs.getString(2));
		t.setLastName(rs.getString(3));
		t.setGender(rs.getString(4));
		t.setHomeroom(rs.getString(5));
		t.setGrade(rs.getInt(6));
		t.setEmail(rs.getString(6));
		return t;
	}
}
