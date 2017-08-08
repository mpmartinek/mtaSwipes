package dataStruct;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class Table {
	
	
	//private static final char DEFAULT_SEPARATOR = ',';
	//private static final char DEFAULT_QUOTE = '"';
	
	int docs = 4;
	static int nOfCol;
	static String links;
	String testLine;
	int k = docs * 200000;
	String[] lineIn = new String[k];
	static URL link;
	static String csvFile;
	static int top;
	static int bottom;
	
	String[] col1 = new String[k];
	String[] col2 = new String[k];
	String[] col3 = new String[k];
	String[] col4 = new String[k];
	String[] col5 = new String[k];
	String[] col6 = new String[k];
	String[] col7 = new String[k];
	String[] col8 = new String[k];
	
	String[] col1a = new String[k/6];
	String[] col2a = new String[k/6];
	String[] col3a = new String[k/6];
	String[] col4a = new String[k/6];
	String[] col5a = new String[k/6];
	String[] col6a = new String[k/6];
	String[] col7a = new String[k/6];
	
	String[] station = new String[k/40];
	String[] line = new String[k/40];
	String[] date = new String[k/40];
	String[] swipes = new String[k/40];
	String[] exits = new String[k/40];
	
	List<String> cols = new ArrayList<String>();
	
	
	public Table(){
		
	}
	
	public Table(String list, String file, int docs1, int bottom1, int top1){

		System.out.println("Table Created!");
		links = list;
		csvFile = file;
		docs = docs1;
		bottom = bottom1;
		top = top1;
	}

	public void store(){
		System.out.println("...");
		CSVReader reader = null;
		//String[] linkList = getLinks();
		
		int x = 2;
		int y = 0;
		//int linkN = getLength(linkList);

		try {
			reader = new CSVReader(new FileReader(csvFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((line = reader.readNext()) != null){
			col1[y] = lineIn[x];x++;
			col2[y] = lineIn[x];x++;
			col3[y] = lineIn[x];x++;x++;
			col4[y] = lineIn[x];x++;
			col5[y] = lineIn[x];x++;x++;
			col6[y] = lineIn[x];x++;
			//col6[y] = Long.parseLong(line[x]);x++;
			col7[y] = lineIn[x];
			//col7[y] = Long.parseLong(line[x]);
			//}
			x=2;y++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void store1(){
		System.out.println("...");
		CSVReader reader = null;
		//String[] linkList = getLinks();
		
		int x = 0;
		int y = 0;
		//int linkN = getLength(linkList);

		try {
			reader = new CSVReader(new FileReader(csvFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((lineIn = reader.readNext()) != null){
			col1[y] = lineIn[x];x++;
			col2[y] = lineIn[x];x++;
			col3[y] = lineIn[x];x++;
			col4[y] = lineIn[x];x++;
			col5[y] = lineIn[x];x++;
			col6[y] = lineIn[x];x++;
			//col6[y] = Long.parseLong(line[x]);x++;
			col7[y] = lineIn[x];
			//col7[y] = Long.parseLong(line[x]);
			//}
			x=0;y++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void printOne(int y, int x){
		System.out.println("Searching...");
		if(x==0)System.out.println(col1[y]);
		if(x==1)System.out.println(col2[y]);
		if(x==2)System.out.println(col3[y]);
		if(x==3)System.out.println(col4[y]);
		if(x==4)System.out.println(col5[y]);
		if(x==5)System.out.println(col6[y]);
		if(x==6)System.out.println(col7[y]);
	}
	
	public String returnOne(int y, int x){
		if(x==0)return col1[y];
		if(x==1)return col2[y];
		if(x==2)return col3[y];
		if(x==3)return col4[y];
		if(x==4)return col5[y];
		if(x==5)return col6[y];
		if(x==6)return col7[y];
		else return ("unavailible");
		
	}
	
	public void printAll() throws IOException{
		System.out.println("Printing table...");
		int b = getLength(col1);
		for(int i = 0; i<b; i++){
			if(col1[i] != null)
			System.out.println(col1[i] + "," + col2[i] + "," + col3[i] + "," + col4[i] + "," + col5[i] + "," + col6[i] + "," + col7[i] + "," + col8[i]);
			
			
		}	
	}
	
	public void printSelectTest(){
		String test = "00-01-07";
		
		int y = 0;
		System.out.println("Printing select test..");
		for(String element: col1){
			if(element != null && element.equals(test)){
				System.out.println(col1[y]);
				y++;
			}
		}
	}
	
	public void printSwipesByTurnstyle(){
		long higher = 0;long lower = 0;
		for(int i=1;i<192045;i++){
			if(col2[i].equals(col2[i-1])){
				if(!col1[i].equals(col1[i+1])){
					higher = Long.parseLong(col6[i]);
					System.out.println(col3[i] + " - " + col2[i] + " - " + col1[i] + " - " + (higher - lower));
					if(i!=27323){lower = Long.parseLong(col6[i+1]);}	
				}
			}
			if(!col2[i].equals(col2[i-1])){
				lower = Long.parseLong(col6[i]);}}}
	
	public void printRefactoredSwipesByTurnstyle1(){
		int b = getLength(col1a);
		for(int i = 0; i<b; i++){
			if(col1a[i] != null)
			System.out.println(col1a[i] + ", " + col2a[i] + ", "+ col3a[i] + ", " + col4a[i] + ", " + col5a[i]);
		}
	}
		
	public void refactorByTurnstyle(){
		System.out.println("Refactoring by turnstyle...");
		long higher = 0;long lower = 0;//long higherX = 0;long lowerX = 0;
		long diff;
		//long diffX;
		int n = 0;
		int b = getLength(col1);
		for(int i=1;i<b-1;i++){
			if(col2[i].equals(col2[i-1])){
				if(!col1[i].equals(col1[i+1])){
					higher = 
							Long.parseLong(col6[i]);
					//higherX = Long.parseLong(col7[i].replaceAll("\\s+$", ""));
					diff = higher - lower;
					//diffX = higherX - lowerX;
					diff = Math.abs(diff);
					//diffX = Math.abs(diffX);
					col1a[n] = col1[i];col3a[n] = col3[i];col2a[n] = col2[i];col4a[n] = col4[i];col5a[n] = String.valueOf(diff);
					//System.out.println(col);
					//col6a[n] = String.valueOf(diffX);
					if(i!=b-1){lower = Long.parseLong(col6[i+1]);
					//lowerX = Long.parseLong(col7[i+1].replaceAll("\\s+$", ""));}
					}
					n++;}}
			if(!col2[i].equals(col2[i-1])){lower = Long.parseLong(col6[i]);
			//*lowerX = Long.parseLong(col7[i].replaceAll("\\s+$", ""));
			}
		}
	}	
			
	public void refactorByStation(){
		System.out.println("Refactoring by station...");
		int n = 0;int b = getLength(col1a);int sum = 0;//long sumX = 0;
		for(int i=0;i<b-1;i++){
			if(col1a[i] != null){sum = sum+Integer.parseInt(col5a[i]);
			//sumX = sumX+Integer.parseInt(col6a[i]);
				if(!col2a[i].equals(col2a[i+1])){
					station[n] = col2a[i];
					line[n] = col3a[i];
					date[n] = col4a[i];
					swipes[n] = Integer.toString(sum);
					//exits[n] = Long.toString(sumX);
					n++;sum=0;//sumX=0;
					}
			}
		}
	}
	
	public void printRefactoredByStation(){
		System.out.println("Printing...");
		System.out.println("Station, Line, Date, Swipes");
		int b = getLength(station);
		for(int i=0;i<b;i++)
			System.out.println(station[i] + ", " + line[i] + ", " + date[i] + ", " + swipes[i]);
		
	}
	
	public void printRelevantStations(){
		System.out.println("Printing relevant...");
		int nRecords = getLength(station);int nStations = getLength(lines());int i=0;int j=0;int n=0;
		System.out.println(nRecords + " " + nStations);
		String[] stationsList = stations();	String[] linesList = lines();
		String[] first = new String[nRecords];String[] second = new String[nRecords];
		String[] third = new String[nRecords];	String[] fourth = new String[nRecords]; //String[] fifth = new String[nRecords];
		while(i<nRecords){
			while(j<nStations){
				//System.out.println(stationsList[j] + " " + linesList[j]);
				//System.out.println(station[i] + " " + line[i]);
				if(station[i].equals(stationsList[j]) && line[i].equals(linesList[j])){
					first[n] = station[i];
					second[n] = line[i];
					third[n] = date[i];
					fourth[n] = swipes[i];n++;
					//System.out.println(nRecords + " " + nStations);
					//fifth[n] = exits[i];n++;
				}j++;}i++;j=0;}	
		i = 0;n = getLength(first);
		while(i<n){
		System.out.print(first[i] + ",");
		System.out.print(second[i] + ",");
		System.out.print(third[i] + ",");
		System.out.println(fourth[i]);i++;
		//System.out.println(fifth[i]);i++;
		}
	}

	public static String[] getLinks(){
		CSVReader reader = null;int i=0;
		String a = links;String[] line1;
		String[] lines = new String[4000];
		try {
			reader = new CSVReader(new FileReader(a));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((line1 = reader.readNext()) != null){
				lines[i] = line1[0];i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
		
	}
		
	public static String[] stations(){
		CSVReader reader = null;int i=0;
		String a = ("stationList1.txt");String[] lineInput;
		String[] stations = new String[121];
		try {
			reader = new CSVReader(new FileReader(a));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((lineInput = reader.readNext()) != null){
				stations[i] = lineInput[0];i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stations;
	}
	
	public static String[] lines(){
		CSVReader reader = null;int i=0;
		String a = ("linesList1.txt");String[] lineInput;
		String[] lines = new String[121];
		try {
			reader = new CSVReader(new FileReader(a));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((lineInput = reader.readNext()) != null){
				lines[i] = lineInput[0];i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}
	
	public void downloadData(){
		System.out.println("Downloading & storing...");
		CSVReader reader = null;
		String[] linkList = getLinks();
		//String inLine1 = new String();
		
		int x = 2;
		int y = 0;
		//List<String[]> inLine2;
		//int r = 0;
		//int linkN = getLength(linkList);
		for(int o=bottom;o<top;o++){ 
			
			try {
				link = new URL(linkList[o]);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedReader in1 = null;
			try {
				in1 = new BufferedReader(new InputStreamReader(link.openStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			reader = new CSVReader(in1);
			try {
				while ((lineIn = reader.readNext()) != null){
					col1[y] = lineIn[x];x++;	
					col2[y] = lineIn[x];x++;
					col3[y] = lineIn[x];x++;x++;
					col4[y] = lineIn[x];x++;
					col5[y] = lineIn[x];x++;x++;
					col6[y] = lineIn[x];x++;
					col7[y] = lineIn[x];
					col8[y] = lineIn[1];
					x=2;y++;
				}					
			} catch (IOException e) {
			}
				// TODO Auto-generated catch block
			System.out.println("---------------------NEXT FILE---------------------");
			}
	}
	
	public int getLength(String[] list){
		int l = list.length;
		int n = 0;
		for(int i=0;i<l;i++){
			try{
				if(!list[i].equals(null)){
					n++;
				}
				}
			catch (NullPointerException e){
			}
				
			
		}
		return n;
	}
	
	public void testing(){
		
		}
		
	}
	


