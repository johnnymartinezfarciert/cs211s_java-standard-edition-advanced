
import java.util.*;

public class Course {
	
	private String name;
	private List<Student> students;
	
	public Course(String name) {
		this.name = name;
		this.students = new ArrayList<>();
	}
	
	public boolean addStudent(Student s) {
	    if(!students.contains(s)) {
	        return students.add(s);
	    } else {
	        return false;
	    }
	}
	
	public boolean removeStudent(Student s) {
		return students.remove(s);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return new ArrayList<Student>(students);
	}
	

	@Override
	public String toString() {
		return name + "\n\t" + students;
	}

	

}
