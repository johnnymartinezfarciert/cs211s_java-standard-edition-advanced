
public class Intern extends Employee {
	
    public static final int DEFAULT_INTERN_ID = -1;
    public static final String DEFAULT_INTERN_NAME = "INTERN NO NAME";
    
    public Intern() {
        this(DEFAULT_INTERN_ID, DEFAULT_INTERN_NAME);
    }
    
	public Intern(int id, String name) {
		super(id, name, new NoPayer());
	}

	@Override
	public void benefits() {
		System.out.println("Interns receive only the benefit of experience.");
		
	}

	
	@Override
	public void timeOff() {
		System.out.println("Interns do not receive time off.");		
	}

	@Override
	public void process() {
		System.out.println("Processing Intern " + super.getId());
		
	}
	
	

}
