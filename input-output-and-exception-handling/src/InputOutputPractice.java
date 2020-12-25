import java.io.*;
import java.util.*;

public class InputOutputPractice {

	public static void main(String[] args) throws Exception {
		
		//read in from file
		Scanner fileScan = new Scanner(new FileInputStream("input_oneperline.txt"));

		// write to fine
		PrintWriter out = new PrintWriter(new FileOutputStream("output_alloneline.txt", true));
		
		while(fileScan.hasNext())
		{
			String oneLine = fileScan.nextLine();
//			System.out.println(oneLine);
			out.print(oneLine + " ");
		}
		fileScan.close();
		out.close();
		System.out.println("done");
	}

}
