import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Address {

	@ProperLength(minLength = 1, maxLength = 255)
	private String street;
	@ProperLength(minLength = 0)
	private String street2;
	@ProperLength(minLength = 1, maxLength = 40)
	private String city;
	@ProperLength(minLength = 2, maxLength = 2)
	private String state;
	@ProperLength(minLength = 5, maxLength = 5)
	private String zip;

	public Address(String street, String street2, String city, String state, String zip)
			throws IllegalArgumentException {
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;

		validateLengths();
	}

	private void validateLengths() {
		String s = "";
		String fieldName = "";
		int minLength = -1;
		int maxLength = -1;

		try {
			Class c = Address.class;

			Field[] fields = c.getDeclaredFields();

			for (Field field : fields) {
				s = (String) field.get(this);
				fieldName = field.getName();
				if (field.isAnnotationPresent(ProperLength.class)) {
					ProperLength annotation = field.getAnnotation(ProperLength.class);
					minLength = annotation.minLength();
					maxLength = annotation.maxLength();
					if (s.length() > maxLength || s.length() < minLength) {
						throw new IllegalArgumentException();
					}
				}
			}
		} catch (IllegalArgumentException e) {
			String message = "";
			message += "Invalid address value " + "[" + fieldName + "=\"" + s + "\"] " ;
			if(minLength == maxLength) {
				message += fieldName + " must be exatcly " + minLength + " characters " ; 
			}
			else if(maxLength < s.length())
			{
				message += fieldName + " must be a maximum of " + maxLength + " characters" ;
			}
			else {
				message += fieldName + " must be at least " + minLength + " or more characers ";
			}
			
			throw new IllegalArgumentException(message);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String s = street + (street2.length() > 0 ? "\t" + street2 : "") + "\t" + city + ", " + state + " " + zip;
		return s;

	}

}
