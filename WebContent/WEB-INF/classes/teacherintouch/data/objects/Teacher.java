package teacherintouch.data.objects;
/**
 * 
 * @author bryanpeterson
 *
 */
public class Teacher {
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private String homeroom;
	private int grade;
	
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
	
	public void setHomeroom(String homeroom) {
		this.homeroom = homeroom;
	}
	
	public String getHomeroom() {
		return homeroom;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		return grade;
	}
}
