package teacherintouch.delegate.impl;

import java.util.Collection;

import teacherintouch.dao.StudentDAO;
import teacherintouch.dao.impl.StudentDAOImpl;
import teacherintouch.data.objects.Student;
import teacherintouch.delegate.StudentDelegate;

/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentDelegateImpl implements StudentDelegate {
	private static final StudentDAO dao = new StudentDAOImpl();//TODO DAO creation factory
	
	@Override
	public Collection<Student> getAllStudents() {
		return dao.findAll();
	}

	@Override
	public Student getStudent(int studentID) {
		return dao.findByPrimaryKey(studentID);
	}

	@Override
	public boolean addStudent(Student s) {
		return dao.insertStudent(s);
		
	}

	@Override
	public boolean updateStudent(Student s) {
		return dao.updateStudent(s);
		
	}

	@Override
	public boolean deleteStudent(Student s) {
		return dao.deleteStudent(s);
	}
}