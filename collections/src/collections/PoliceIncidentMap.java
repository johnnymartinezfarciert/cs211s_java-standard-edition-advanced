package collections;

import java.util.*;
import java.io.*;

public class PoliceIncidentMap {

	public static void main(String[] args) {

		Map<String, Incident> incidentMap = new HashMap<>(); // or TreeMap
		
		fillMapByID(incidentMap);
		System.out.println("There are " + incidentMap.size() + " key-value pairs.");
		
		// how many number of instances by category type 'Disorderly conduct' ?
		printIncidentsByCatagory(incidentMap, 10, "Disorderly Conduct");
		
		// what are the number of instances per day of the week ?
		Map<String, List<Incident>> incidentDayOfWeekMap = new HashMap<>(); // or TreeMap
		fillMapByDayOfWeek(incidentDayOfWeekMap);
        System.out.println("There are " + incidentDayOfWeekMap.size() + " key-value pairs.");
        printDayOfWeekIncident(incidentDayOfWeekMap);
	}

	private static void fillMapByID(Map<String, Incident> map) {
		try (Scanner fileScan = new Scanner(new FileReader(new File("Police_Incident_Reports.csv")))) {
			String line = fileScan.nextLine(); // column headers

			while (fileScan.hasNext()) {
				line = fileScan.nextLine();
				// assuming perfectly formatted data
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(";");
				String dateTime = lineScan.next();
				String dayOfWeek = lineScan.next();
				String id = lineScan.next();
				String catagory = lineScan.next();
				String description = lineScan.next();
				String resolution = lineScan.next();
				Incident i = new Incident(dateTime, dayOfWeek, id, catagory, description, resolution);

				map.put(id, i);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// return number of incidents by catagory type
	private static void printIncidentsByCatagory(Map<String, Incident> map, int printCount, String catagory) {
		int recordsPrinted = 0;
		int numberOfIncidents = 0;

		Collection<Incident> values = map.values();
		Iterator<Incident> iterator = values.iterator();
		while (iterator.hasNext()) {
			Incident incident = iterator.next();
			if (incident.getCatagory().equalsIgnoreCase(catagory)) {
				numberOfIncidents++;
				if (recordsPrinted < printCount) {
					System.out.println(incident);
					recordsPrinted++;
				}
			}
		}
		System.out.println(numberOfIncidents + " instances of catagory type : " + catagory);
	}

	// Day of the week with the most number of instances
	private static void fillMapByDayOfWeek(Map<String, List<Incident>> map) {
		try (Scanner fileScan = new Scanner(new FileReader(new File("Police_Incident_Reports.csv")))) {
			String line = fileScan.nextLine();

			while (fileScan.hasNext()) {
				line = fileScan.nextLine();
				// assuming perfectly formatted data
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(";");
				String dateTime = lineScan.next();
				String dayOfWeek = lineScan.next();
				String id = lineScan.next();
				String catagory = lineScan.next();
				String description = lineScan.next();
				String resolution = lineScan.next();
				Incident i = new Incident(dateTime, dayOfWeek, id, catagory, description, resolution);
				
				if(map.containsKey(dayOfWeek))
				{
					List<Incident> incidentList = map.get(dayOfWeek);
					
					if(incidentList==null)
					{
						incidentList = new ArrayList<Incident>();
					}
					
					incidentList.add(i);
				} else {
					List<Incident> incidentList = new ArrayList<Incident>();
					incidentList.add(i);
					map.put(dayOfWeek, incidentList);
				}
			}
		} catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	// number of incidents per day of the week
	private static void printDayOfWeekIncident(Map<String,List<Incident>> map)
	{
		Set<String> daysOfWeek = map.keySet();
		Iterator<String> iterator = daysOfWeek.iterator();
		while(iterator.hasNext()) {
			String dayOfWeek = iterator.next();
			List<Incident> incidentList = map.get(dayOfWeek);
			int numberOfIncidents = incidentList.size();
			System.out.println(dayOfWeek + " has " + numberOfIncidents + " reported incidents" );
		}
	}

}
