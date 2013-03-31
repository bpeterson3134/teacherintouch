package teacherintouch.delegate;

import java.util.Collection;

import teacherintouch.data.objects.Student;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface StudentTeacherDelegate {
	
	public Collection<Student> getAllStudentsOfTeacher(int teacherID);
}
