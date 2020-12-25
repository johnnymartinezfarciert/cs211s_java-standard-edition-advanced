import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DaysUntilBirthday {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LocalDate today = LocalDate.now();

		System.out.println("Today's date is " + today);
		System.out.println("When is your birthday ? (enter in 'YYYY-MM-DD' format )");
		String input = scan.nextLine();
		LocalDate birthdate = LocalDate.parse(input);

		long numDays = ChronoUnit.DAYS.between(birthdate, today);
		System.out.println("You are..\n" + numDays + " days old.");
		long numYears = ChronoUnit.YEARS.between(birthdate, today);
		System.out.println(numYears + " years old.");

	}

}
