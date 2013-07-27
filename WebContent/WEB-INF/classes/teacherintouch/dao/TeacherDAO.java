package teacherintouch.dao;

import java.util.Collection;

import teacherintouch.data.objects.Teacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface TeacherDAO {

	public Teacher findByPrimaryKey(int teacherID);
	public Collection<Teacher> findAll();
	public boolean insertTeacher(Teacher teacher);
}
