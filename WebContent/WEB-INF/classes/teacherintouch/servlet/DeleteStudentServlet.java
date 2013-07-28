package teacherintouch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacherintouch.data.objects.Student;
import teacherintouch.delegate.StudentDelegate;
import teacherintouch.delegate.impl.StudentDelegateImpl;

import com.google.gson.Gson;

/**
 * 
 * @author bryanpeterson
 *
 */
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StudentDelegate sDelegate = new StudentDelegateImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
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
		student.setId(Integer.parseInt(request.getParameter("id")));
//		student.setFirstName(request.getParameter("firstName"));
//		student.setLastName(request.getParameter("lastName"));
//		student.setGender(request.getParameter("gender"));
//		student.setGrade(Integer.parseInt(request.getParameter("grade")));
//		Integer homeroomTeacherID = StringUtils.isNullOrEmpty(request.getParameter("homeroomTeacherID"))? null : Integer.parseInt(request.getParameter("homeroomTeacherID"));
//		student.setHomeroomTeacherID(homeroomTeacherID);
		
		sDelegate.deleteStudent(student);

//		request.setAttribute("student", student);
		//response is for ajax callback
//		writeJson(response, student);

//		String url = "/students.jsp?teacherID=1";
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//		dispatcher.forward(request, response);
	}

}
