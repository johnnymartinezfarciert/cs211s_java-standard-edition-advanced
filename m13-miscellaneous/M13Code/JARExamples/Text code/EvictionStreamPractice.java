import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class EvictionStreamPractice {
	
	public static void main(String[] args) {
		
		List<Eviction> evictionList = new ArrayList<>();
		fillList(evictionList);
		
		Stream<Eviction> evictionStream = evictionList.stream();
		evictionStream.limit(10).forEach(System.out::println);
		
		// filter all the evictions due to nuisance, in the tenderloin, on market
		/*
		evictionStream.filter(	        
		        eviction -> 
		        {
		            if(eviction.getEvictionCause() == Eviction.EvictionCause.NUISANCE) {
		                if(eviction.getNeighborhood().contains("Tenderloin")) {
		                    if(eviction.getAddress().contains("Market")) {
		                        return true;
		                    }
		                }
		            }
		            return false;
		        }        
		        ).forEach(System.out::println);
		*/
		// "stream"lined way of writing the filter
		//evictionStream.filter(eviction -> eviction.getEvictionCause()==Eviction.EvictionCause.NUISANCE &&
		//                            eviction.getNeighborhood().contains("Tenderloin") &&
		//                            eviction.getAddress().contains("Market") ).forEach(System.out::println);
		
		// map onto a Stream<String> that contain neighborhoods, then filter out the richmond
		// our map goes from Stream<Eviction> to Stream<String>
		// first two are equivalent and would be used if in reality you wanted to collect a List<String>
		// the third would be how you'd probably do it if you really just wanted to print the neighborhoods-
		// in that case, you don't really need a map, you can just filter and print
		/*
		evictionStream.map( eviction -> eviction.getNeighborhood() )
		              .filter( neighborhoodString -> neighborhoodString.contains("Richmond") )
		              .forEach(System.out::println);
		evictionStream.filter( eviction -> eviction.getNeighborhood().contains("Richmond"))
		               .map( eviction -> eviction.getNeighborhood())
		               .forEach(System.out::println);
		evictionStream.filter( eviction -> eviction.getNeighborhood().contains("Richmond"))
		                .forEach( eviction -> System.out.println(eviction.getNeighborhood()) );
		*/
		
		// count the evictions due to nuisance, in tenderloin, on market
		long count = evictionStream.filter(         
                eviction -> eviction.getEvictionCause() == Eviction.EvictionCause.NUISANCE &&
                            eviction.getNeighborhood().contains("Tenderloin") &&
                            eviction.getAddress().contains("Market")
                ).count();

		// are there any evictions on phelan ave?
		boolean phelanEvic = evictionList.stream()
		        .anyMatch(eviction -> eviction.getAddress().contains("Phelan"));
		
		// a list of all evictions in the tenderloid
		List<Eviction> tenderloinEvictionList = evictionList.stream()
		        .filter(eviction -> eviction.getNeighborhood().contains("Tenderloin"))
		        .collect(Collectors.toList());
		
		// map of all nuisance evictions- key is the eviction id, value is the eviction
		Map<String, Eviction> nuisanceEvictionMap = evictionList.stream()
		        .filter(eviction -> eviction.getEvictionCause()==Eviction.EvictionCause.NUISANCE)
		        .collect(Collectors.toMap( // Collectors.toMap method takes two parameters- each a lambda
		                eviction -> eviction.getId(), // parameter 1- the function to get the key
		                // eviction -> eviction // parameter 2- the function to get the value
		                Function.identity() // alternate parameter 2
		        ));
		
		// map of all evictions by neighborhood- key is the neighborhood, value is the list of evictions for that neighborhood
		Map<String, List<Eviction>> evictionMap = evictionList.stream()
		        .collect(Collectors.groupingBy(
		                    eviction -> eviction.getNeighborhood() // map from value to the grouping used for key
		                    // Eviction::getNeighborhood- another option
		                ));
		
		// map of all evictions by neighborhood- key is the neighborhood, value is the count
		Map<String, Long> evictionCountMap = evictionList.stream()
		        .collect(Collectors.groupingBy( // takes two parameters
		                eviction -> eviction.getNeighborhood(), // param1- function that specifies how to get the key
		                Collectors.counting() // param2- this is the Collectors object that specifies how to get the value
		                ));
		
		
	
	
	
	
	
	
	
	
	}

	private static void fillList(List<Eviction> list) {
		try (Scanner fileScan = new Scanner(
				new FileReader(new File("Evictions.csv")))) {
			String line = fileScan.nextLine();
			
			
			while(fileScan.hasNext()) {
				line = fileScan.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				String id = lineScan.next();
				String address = lineScan.next();
				String zip = lineScan.next();
				String fileDate = lineScan.next();
				String neighborhood = lineScan.next();	
				Eviction.EvictionCause evictionCause = null;
				
				Eviction.EvictionCause[] array = Eviction.EvictionCause.values();
				boolean found = false;
				for(int i = 0; i < array.length && !found; i++){
					String temp = lineScan.next();
					if(temp.equalsIgnoreCase("true")){
						evictionCause = array[i];
						found = true;
					}
				}

				Eviction eviction = new Eviction(id, address, zip, fileDate, 
						neighborhood, evictionCause);	
				list.add(eviction);
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}

	
	
	
	
	

}
