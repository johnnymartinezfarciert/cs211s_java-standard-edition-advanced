import java.lang.annotation.*;
import java.lang.reflect.*;

public class Address {
	
	private String street;	
	private String street2;
	private String city;
	private String state;
	private String zip;

	public Address(String street, String street2, String city, String state, String zip) throws IllegalArgumentException  {
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		validateLengths();
	}
	
	private void validateLengths() throws IllegalArgumentException {
		// YOUR CODE HERE
	}
	
	@Override
	public String toString() {
		String s = street + (street2.length()>0 ? "\t"+street2 : "") +
				"\t" + city + ", " + state + " " + zip;
		return s;
				
	}

	
	

}
