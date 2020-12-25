package annotation;

@FunctionalInterface
public interface Hireable {
	
	void hire();
	
	default void process() {
		System.out.println("processing a hire");
	}

}
