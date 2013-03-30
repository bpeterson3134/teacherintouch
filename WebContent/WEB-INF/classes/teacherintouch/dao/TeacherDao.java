package teacherintouch.dao;

import java.util.Collection;

import teacherintouch.data.objects.Teacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface TeacherDao {

	public Collection<Teacher> findByPrimaryKey(int teacherID);
	public Collection<Teacher> findAll();
}
