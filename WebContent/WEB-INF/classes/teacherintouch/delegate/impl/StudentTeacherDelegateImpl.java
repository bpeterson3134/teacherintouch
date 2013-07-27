package teacherintouch.delegate.impl;

import java.util.ArrayList;
import java.util.Collection;

import teacherintouch.dao.StudentTeacherDAO;
import teacherintouch.dao.impl.StudentTeacherDAOImpl;
import teacherintouch.data.objects.Student;
import teacherintouch.data.objects.StudentTeacher;
import teacherintouch.data.objects.Teacher;
import teacherintouch.delegate.StudentDelegate;
import teacherintouch.delegate.StudentTeacherDelegate;
import teacherintouch.delegate.TeacherDelegate;

/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentTeacherDelegateImpl implements StudentTeacherDelegate {
	private static final StudentTeacherDAO dao = new StudentTeacherDAOImpl();
	private static final StudentDelegate studentDelegate = new StudentDelegateImpl();
	private static final TeacherDelegate teacherDelegate = new TeacherDelegateImpl();
	
	@Override
	public Collection<Student> getAllStudentsOfTeacher(int teacherID) {
		Collection<StudentTeacher> results =  dao.findAllStudentsOfTeacher(teacherID);
		Collection<Student> students = new ArrayList<Student>();
		for(StudentTeacher st : results) {
			Student student = studentDelegate.getStudent(st.getStudentID());
			Teacher teacher = teacherDelegate.getTeacher(st.getTeacherID());
			student.setTeacher(teacher);
			students.add(student);
		}
		return students;
	}

	@Override
	public boolean addNewStudentOfTeacher(Student student, Teacher teacher) {
		studentDelegate.addStudent(student);
		dao.insertStudent(student, teacher);
		return true;
		
	}

	@Override
	public boolean addExistingStudentOfTeacher(Student student, Teacher teacher) {
		dao.insertStudent(student, teacher);
		return true;
	}

}
