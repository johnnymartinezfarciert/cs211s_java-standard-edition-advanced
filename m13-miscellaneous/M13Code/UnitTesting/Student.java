
public class Student {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			return name.equalsIgnoreCase(((Student)obj).name);
		} else {
			return false;
		}
	}
	
}
