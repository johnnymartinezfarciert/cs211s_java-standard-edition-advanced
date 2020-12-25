import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.Scanner;

public class SaveNumberToFile {

	public static void main(String[] args) throws IOException {
		// scanner objet to read input from console
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the name of the file you wish to save to: ");
		String outputFile = scan.nextLine();
		
		//PrinteWriter object to write FileOutputStream to file
		PrintWriter out = new PrintWriter(new FileOutputStream(outputFile));

		System.out.println("Enter a positive number and hit enter (or 'done' to quit) :");
		String input = scan.nextLine();
		while (!input.equalsIgnoreCase("DONE")) {
			try {
				int number = Integer.parseInt(input);
				out.println(number);
				input = scan.nextLine();
			} catch (NumberFormatException ex) {
				System.out.println(input + " : is not a number");
				input = scan.nextLine();
			} finally {
				out.close();
			}
		}// end while
		
		System.out.println("Contents of " + outputFile);

		Scanner fileScan = new Scanner(new FileInputStream(outputFile));
		while (fileScan.hasNext()) {
			String line = fileScan.nextLine();
			System.out.println(line);
		}
	}

}
