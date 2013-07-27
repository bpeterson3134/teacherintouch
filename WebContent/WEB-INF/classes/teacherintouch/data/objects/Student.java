package teacherintouch.data.objects;
/**
 * 
 * @author bryanpeterson
 *
 */
public class Student {
	private Integer id;
	private String firstName;
	private String lastName;
	private String gender;
	private Teacher teacher;
	private Integer homeroomTeacherID;
	private Integer grade;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setHomeroomTeacherID(Integer homeroomTeacherID) {
		this.homeroomTeacherID = homeroomTeacherID;
	}
	
	public Integer getHomeroomTeacherID() {
		return homeroomTeacherID;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	public Integer getGrade() {
		return grade;
	}
}
