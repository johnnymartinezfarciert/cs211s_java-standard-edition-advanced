package annotation;

/*
@DevelopmentInformation(
        developer = "Bessie Boss",
        version = 4,
        status = DevelopmentInformation.Status.DEVELOPMENT
)
*/
public class Employee implements Hireable {
    
    public Employee() {     
    }
	
    @Deprecated
	public void pay() {
		System.out.println("paying employee");
	}
	
    @DevelopmentInformation(
            developer = "Jessica Masters",
            version = 2,
            status = DevelopmentInformation.Status.TESTING
    )
	public void processingPay() {
	    System.out.println("processing employee pay");
	}
	
	public void processingBonus() {
        System.out.println("processing employee bonus");
    }
    
	@DevelopmentInformation(
	       developer = "Jessica Masters",
	       status = DevelopmentInformation.Status.LIVE
	)
	@Override
	public void hire() {
		System.out.println("hiring");
	}
	
	@Override
	public void process() {
	    System.out.println("processing");
	}
	
	
	
	
	

}
