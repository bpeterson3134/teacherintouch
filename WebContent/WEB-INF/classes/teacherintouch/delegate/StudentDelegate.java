package teacherintouch.delegate;

import java.util.Collection;

import teacherintouch.data.objects.Student;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface StudentDelegate {
	
	public Collection<Student> getAllStudents();
	
	public Student getStudent(int studentID);
	
	public boolean addStudent(Student s);
	
	public boolean updateStudent(Student s);
	
	public boolean deleteStudent(Student s);
	
}
