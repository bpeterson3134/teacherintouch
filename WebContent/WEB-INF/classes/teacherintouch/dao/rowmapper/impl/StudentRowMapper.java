package teacherintouch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import teacherintouch.data.objects.Student;

/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
