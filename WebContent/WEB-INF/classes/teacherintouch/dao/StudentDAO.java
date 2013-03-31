package teacherintouch.dao;

import java.util.Collection;

import teacherintouch.data.objects.Student;

/**
 * 
 * @author bryanpeterson
 *
 */
public interface StudentDAO {
	
	public Student findByPrimaryKey(int studentID);
	public Collection<Student> findAll();
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
}