
//
//Write an immutable class to describe a Worker.
//
//A Worker is described by:
//
//    String name
//    int id
//    Manager boss


public final class IMWorker {

	private final String name;
	private final int id;
	private final Manager boss; // MUTABLE!!

	public IMWorker(String name, int id, Manager boss) {
		this.name = name;
		this.id = id;
		Manager copyManager = new Manager(boss.getName(), boss.getSalary());
		this.boss = copyManager;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Manager getManager() {
		Manager addressCopy = new Manager(boss.getName(), boss.getSalary());
		return addressCopy;
	}


}
