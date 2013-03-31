package teacherintouch.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface RowMapper<BUSINESS_OBJECT extends Object> {
	
	public BUSINESS_OBJECT mapRow(ResultSet rs, int rowNum) throws SQLException;
	
}
