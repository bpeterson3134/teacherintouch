package teacherintouch.delegate;

import teacherintouch.data.objects.Teacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface TeacherDelegate {

	public Teacher getTeacher(int teacherID);
	
	public boolean addTeacher(Teacher teacher);
}
