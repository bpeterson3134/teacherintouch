package teacherintouch.servlet;


import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacherintouch.data.objects.Student;
import teacherintouch.delegate.StudentTeacherDelegate;
import teacherintouch.delegate.impl.StudentTeacherDelegateImpl;

/**
 * 
 * @author bryanpeterson
 *
 */
@WebServlet("/GetStudents")
public class GetStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StudentTeacherDelegate stDelegate = new StudentTeacherDelegateImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentsServlet() {
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
		int teacherID = Integer.parseInt(request.getParameter("teacherID"));
		
		Collection<Student> students = stDelegate.getAllStudentsOfTeacher(teacherID);
		request.setAttribute("students", students);
		
		//forward request to jsp
		String url = "/students.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
				
	}

}
