package teacherintouch.delegate.impl;

import java.util.ArrayList;
import java.util.Collection;

import teacherintouch.dao.StudentTeacherDAO;
import teacherintouch.dao.impl.StudentTeacherDAOImpl;
import teacherintouch.data.objects.Student;
import teacherintouch.data.objects.StudentTeacher;
import teacherintouch.delegate.StudentDelegate;
import teacherintouch.delegate.StudentTeacherDelegate;

/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentTeacherDelegateImpl implements StudentTeacherDelegate {
	private static final StudentTeacherDAO dao = new StudentTeacherDAOImpl();
	private static final StudentDelegate studentDelegate = new StudentDelegateImpl();
	
	@Override
	public Collection<Student> getAllStudentsOfTeacher(int teacherID) {
		Collection<StudentTeacher> results =  dao.findAllStudentsOfTeacher(teacherID);
		Collection<Student> students = new ArrayList<Student>();
		for(StudentTeacher st : results) {
			Student student = studentDelegate.getStudent(st.getStudentID());
			students.add(student);
		}
		return students;
	}

}
