package teacherintouch.dao;

import java.util.Collection;

import teacherintouch.data.objects.Student;
import teacherintouch.data.objects.StudentTeacher;
import teacherintouch.data.objects.Teacher;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface StudentTeacherDAO {

	public Collection<StudentTeacher> findAll();
	public Collection<StudentTeacher> findAllStudentsOfTeacher(int teacherID);
	public boolean insertStudent(Student s, Teacher t);
}
