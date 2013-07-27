package teacherintouch.data.objects;

/**
 * 
 * @author bryanpeterson
 *
 */
public class StudentTeacher {
	private Integer teacherID;
	private Integer studentID;
	
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}
	
	public Integer getTeacherID() {
		return teacherID;
	}
	
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	
	public Integer getStudentID() {
		return studentID;
	}

}
