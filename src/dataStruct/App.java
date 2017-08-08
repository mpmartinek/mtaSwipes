package dataStruct;

import java.io.IOException;

public class App {
	
		
	public static void main(String[] args) throws IOException{ 
		
		
		System.out.println("Main Class Initiated!");
		
		String links = "links.txt";
		String csvFile = "swipeSource/4weeks.csv";
		//List<String> types = new ArrayList<String>(6);
		//for(int i=0; i<4; i++){types.add("String");}
		//for(int i=0; i<2; i++){types.add("int");}
		
		
		Table dataSet = new Table(links, csvFile, 4, 361, 365);
		
		//    MAKE FIRST LINE FROM DONWLOADED GET SKIPPED
		
		
		
		//dataSet.testing();
		//dataSet.store();
		dataSet.store1();
		dataSet.refactorByTurnstyle();
		dataSet.refactorByStation();
		//dataSet.printRefactoredSwipesByTurnstyle1();
		//dataSet.printRefactoredByStation();
		dataSet.printRelevantStations();
		//dataSet.downloadData();
		//dataSet.printAll();
		//dataSet.printOne(192045, 0);
		

		
		System.out.println("Exiting...");
		}
}
	
