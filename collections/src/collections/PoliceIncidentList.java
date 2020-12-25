package collections;

import java.io.*;
import java.time.*;
import java.util.*;

public class PoliceIncidentList {
	
	public static void main(String[] args) 
	{
		List<Incident> incidentList = new ArrayList<Incident>();
		fillList(incidentList);
		
		System.out.println("first incident " + incidentList.get(0));
		System.out.println("last incident is " + incidentList.get(incidentList.size()-1));
		
	}
	
	private static void fillList(List<Incident> list) 
	{
		try (Scanner fileScan = new Scanner(new FileReader(new File("Police_Incident_Reports.csv"))))
		{
			String line = fileScan.nextLine();
			
			while(fileScan.hasNext()) {
				line = fileScan.nextLine(); // one line of data
				
				// this code assumes perfectly formatted input data
				Scanner lineScan = new Scanner(line);
				System.out.println(line);
				lineScan.useDelimiter(";");
				String dateTime = lineScan.next();
//				System.out.println(dateTime);
				String dayOfWeek = lineScan.next();
				String id = lineScan.next();
				String catagory = lineScan.next();
				String description = lineScan.next();
				String resolution = lineScan.next();
				Incident i = new Incident(dateTime, dayOfWeek, id, catagory, description, resolution);
				list.add(i);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
