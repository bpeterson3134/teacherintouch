package teacherintouch.data.objects;
/**
 * 
 * @author bryanpeterson
 *
 */
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private int teacher;
	private int homeroomTeacherID;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
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
	
	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}
	
	public int getTeacher() {
		return teacher;
	}
	
	public void setHomeroomTeacher(int homeroomTeacher) {
		this.homeroomTeacherID = homeroomTeacher;
	}
	
	public int getHomeroomTeacherID() {
		return homeroomTeacherID;
	}
}
