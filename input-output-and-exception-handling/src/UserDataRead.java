import java.io.*;
import java.util.*;

public class UserDataRead {

	public static void main(String[] args) throws IOException {
		ArrayList<User> userList = new ArrayList<User>();
		
		Scanner fileScan = new Scanner(new FileInputStream(new File("userdata.csv")));
		
		fileScan.nextLine(); // read/skip the column headers 
		/* assuming file is clean and well-formated (e.g, no missing cells) */
		
		while(fileScan.hasNext()) {
			String oneLine = fileScan.nextLine();
//			System.out.println(oneLine);
			
			Scanner lineScan = new Scanner(oneLine);
			lineScan.useDelimiter(",");
			
//			while (lineScan.hasNext())
//			{ // inner loop parses that single line into token
//				String token = lineScan.next();
//				System.out.println(token);
//			}
			// NOTE: only works with perfectly formed data
			String firstName = lineScan.next();
			String lastName = lineScan.next();
			String email = lineScan.next();
			String phone = lineScan.next();
			
			User user = new User(firstName, lastName, email, phone);
			userList.add(user);
			
		}
		fileScan.close();
		
		for(User user : userList)
		{
			System.out.println(user);
		}
	}

}
