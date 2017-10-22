import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Assign5 {
	
	static HashTable hashTable; 

	public static void main(String[] args) {
		
		//Make sure user inputs correct arguments
		//output1 = depth first, output2 = breadth first
		if(args.length != 2){
			System.err.println("Arguments must be input.txt and output.txt");
			System.exit(-1);
		}
		
		String inputFile = args[0];		//Input text file
		String outputFile = args[1];	//Output text file
		
		
		//Check to see if all files have names
		if(inputFile == null || outputFile == null){
			System.err.println("Invalid file name");
			System.exit(-1);
		}
		
		//Print names of input and output files
		System.out.println("Input File: " + inputFile);
		System.out.println("Output File: " + outputFile + "\n");
		
		int maxSize = inputSize(inputFile) * 2; //TO MAKE 70% FULL, CHANGE TO 1.4
		
		//create hash table with max size = number of words in input file
		hashTable = new HashTable(maxSize);
		
		//System.out.print(maxSize);
		
		//OUTPUT ORDER: fillHashTable -> searchHashTable -> writeFile
		
		fillHashTable(inputFile);
	
		search(inputFile);
		
		hashTable.printHashTable();
		
		writeFile(outputFile);
		
		System.out.println("Max Reads: " + hashTable.maxReads + "\nTotal Reads: " + hashTable.totalReads);
		
	}
	
	
	/*
	 * Reads input file and searches the hash table
	 */
	public static void search(String inputFile){
		Scanner scan = null;
		int maxReads = 1;
		int totalReads = 0;
		try{
			scan = new Scanner(new File(inputFile));
			while(scan.hasNext()){
			//	hashTable.get(scan.next());
				int temp = hashTable.Search(scan.next());
				if(temp > maxReads) maxReads = temp;
				totalReads += temp;		
			} 
				
				System.out.println(totalReads + " " + maxReads);			
			}
		catch(IOException e){
			System.err.println("Couldn't find file");
		}
	}
	
	public static void fillHashTable(String inputFile){
		try{
			Scanner scan = new Scanner(new File(inputFile));
			while(scan.hasNext()){
				hashTable.insert(scan.next());
			}
		}
		catch(IOException e){
			System.err.println("Failed to read input file");
		}
	
	}
	
	
	public static int inputSize(String inputFile){
		Scanner scan = null;
		int count = 0; //count = input size
		try{
			scan = new Scanner(new File(inputFile));
			while(scan.hasNext()){
				scan.nextLine();
				count++;
			}
		}	
		catch(IOException e){
			System.out.println("Couldn't find file");
			System.exit(-1);
		}
	//	System.out.println(count);
		return count;
	}
	
	public static void writeFile(String outputFile){
		
		try{
			FileWriter fwriter = new FileWriter(outputFile);
			BufferedWriter output = new BufferedWriter(fwriter);

			hashTable.outputHashTable(output);
			
			output.close();
		}
		catch(IOException e){
			System.err.println("Failed to write to file");
			System.exit(-1);
		}
		
	}
	
}
