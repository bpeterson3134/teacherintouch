package teacherintouch.dao;

import java.util.Collection;

import teacherintouch.data.objects.StudentTeacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface StudentTeacherDAO {

	public Collection<StudentTeacher> findAll();
	public Collection<StudentTeacher> findAllStudentsOfTeacher(int teacherID);
}
