
public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("George Costanzza");
		Employee e2 = new Employee("Sally");
		System.out.println(e1.toString());
		System.out.println(e2.toString());

		System.out.println(e1.equals(e2));
	}

}
