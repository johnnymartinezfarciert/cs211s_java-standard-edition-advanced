import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;
import java.util.Scanner;

public class CopyFile {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the file name to copy: ");
		String userFile = scan.nextLine();
		
		Path userInputPath = Paths.get(userFile);
		
		if(Files.exists(userInputPath))
		{
			System.out.println("That is a valid file");
			
			System.out.println("Enter the directory of where you want the file copied: ");
			String userOutputDirectory = scan.nextLine();
			
			Path outputPath = Paths.get(userOutputDirectory);
			
			if(Files.isDirectory(outputPath))
			{
				System.out.println("that is a Directory");
				Files.copy(userInputPath, outputPath.resolve(userInputPath.getFileName()), REPLACE_EXISTING);
				
			} else { // directory does not exist
				System.out.println("That is not a directory.");
			}
		} else { // file does not exist
			System.out.println("That is not a valid input file.");
		}
	}

}
