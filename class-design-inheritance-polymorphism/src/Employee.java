
public class Employee {
	
	private String name;
	private int id;
	private static int numberEmployed;
	
	public Employee(String name)
	{
		this.name = name;
		numberEmployed++;
		this.id = numberEmployed;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	@Override
	public String toString()
	{
		return "Employee name: " + name + "; Employee ID: " + id ;
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Employee)
		{
			Employee otherEmployee = (Employee)obj;
			
			int otherEmployeeId = otherEmployee.id;
			String otherEmployeeName = otherEmployee.name;
			
			if(otherEmployeeId == id   && otherEmployeeName.equalsIgnoreCase(name))
			{
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	

}
