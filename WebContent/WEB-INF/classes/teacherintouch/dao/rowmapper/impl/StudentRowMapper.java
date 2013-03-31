package teacherintouch.dao.rowmapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import teacherintouch.dao.rowmapper.RowMapper;
import teacherintouch.data.objects.Student;

/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s = new Student();
		s.setId(rs.getInt(1));
		s.setFirstName(rs.getString(2));
		s.setLastName(rs.getString(3));
		s.setGender(rs.getString(4));
		s.setHomeroomTeacher(rs.getInt(5));
		return s;
	}

}
