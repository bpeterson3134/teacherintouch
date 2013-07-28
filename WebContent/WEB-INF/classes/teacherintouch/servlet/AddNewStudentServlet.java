package teacherintouch.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacherintouch.data.objects.Student;
import teacherintouch.data.objects.Teacher;
import teacherintouch.delegate.StudentTeacherDelegate;
import teacherintouch.delegate.TeacherDelegate;
import teacherintouch.delegate.impl.StudentTeacherDelegateImpl;
import teacherintouch.delegate.impl.TeacherDelegateImpl;

/**
 * 
 * @author bryanpeterson
 *
 */
@WebServlet("/AddNewStudentServlet")
public class AddNewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StudentTeacherDelegate stDelegate = new StudentTeacherDelegateImpl();
	private static TeacherDelegate tDelegate = new TeacherDelegateImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setGender(request.getParameter("gender"));
		student.setGrade(Integer.parseInt(request.getParameter("grade")));
//		student.setHomeroomTeacher(homeroomTeacher)
		int teacherID = Integer.parseInt(request.getParameter("teacherID"));
		
		Teacher teacher = tDelegate.getTeacher(teacherID);
		student.setTeacher(teacher);
		stDelegate.addNewStudentOfTeacher(student, teacher);
		
		//send redirect since a refresh of page on a forward will try inserting the student again
		response.sendRedirect("getStudents?teacherID=" + teacher.getId());
	}

}
