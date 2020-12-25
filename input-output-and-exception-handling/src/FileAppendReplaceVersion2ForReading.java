import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAppendReplaceVersion2ForReading {
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the file name with the data");
		String userFile = scan.nextLine();
		
		
		Path userInputPath = Paths.get(userFile);
		
		if(Files.exists(userInputPath))
		{
			List<String> fileLines = Files.readAllLines(userInputPath);
			for(String line : fileLines) {
				Scanner parseScan = new Scanner(line);
				parseScan.useDelimiter(",");
				
				String fileName = parseScan.next();
				boolean append = Boolean.parseBoolean(parseScan.next());
				List<String> newTextList = new ArrayList<String>();
				while(parseScan.hasNext()) {
					newTextList.add(parseScan.next());
				}
				
				Path fileToModify = Paths.get(fileName);
				StandardOpenOption howToWrite = append ? StandardOpenOption.APPEND: StandardOpenOption.TRUNCATE_EXISTING;
				Files.write(fileToModify, newTextList, howToWrite);
			}
				
			System.out.println("Done");
		} else {
			System.out.println("Invalid file");
		}
				
	}
}
