package teacherintouch.delegate.impl;

import teacherintouch.dao.TeacherDAO;
import teacherintouch.dao.impl.TeacherDAOImpl;
import teacherintouch.data.objects.Teacher;
import teacherintouch.delegate.TeacherDelegate;

/**
 * 
 * @author bryanpeterson
 *
 */
public class TeacherDelegateImpl implements TeacherDelegate {
	private static final TeacherDAO dao = new TeacherDAOImpl();
	
	@Override
	public Teacher getTeacher(int teacherID) {
		return dao.findByPrimaryKey(teacherID);
	}

	@Override
	public boolean addTeacher(Teacher teacher) {
		return dao.insertTeacher(teacher);
	}

}
