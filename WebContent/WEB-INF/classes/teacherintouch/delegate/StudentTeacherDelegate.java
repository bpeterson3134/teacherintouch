package teacherintouch.delegate;

import java.util.Collection;

import teacherintouch.data.objects.Student;
import teacherintouch.data.objects.Teacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface StudentTeacherDelegate {
	
	public Collection<Student> getAllStudentsOfTeacher(int teacherID);
	
	public boolean addNewStudentOfTeacher(Student student, Teacher teacher);
	
	public boolean addExistingStudentOfTeacher(Student student, Teacher teacher);
}
