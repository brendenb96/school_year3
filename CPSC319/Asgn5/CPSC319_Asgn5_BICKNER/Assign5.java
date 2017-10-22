import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Assign5 {

    HashTable hashTable;
    int maxSize = 1;

    public Assign5(){
        
    }
    public static void main(String[] args) {
		if (!CheckInput(args)) {
			System.err.println("Invalid arguments. Arguments format is (input.txt) (output.txt)");
			System.exit(-1);
		}
        String inputfile = args[0];
        String outputfile = args[1];

        Assign5 driver = new Assign5();

        driver.maxSize = driver.inputSize(inputfile);
        driver.hashTable = new HashTable((int)(driver.maxSize/(0.7)));
        driver.uploadToHash(inputfile);
        driver.searchHash(inputfile);
        driver.printStats(outputfile);
        
    }
    private int inputSize(String filename){
        Scanner scan = null;
        int count = 0;
        try{
            scan = new Scanner(new File(filename));
            while(scan.hasNext()){
                String temp = scan.next();
                count++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if(scan!=null)scan.close();
        }catch(Exception e1){
            e1.printStackTrace();
        }
        return count;
    }
    private void uploadToHash(String filename){
        Scanner scan = null;
        try{
            scan = new Scanner(new File(filename));
            while(scan.hasNext()){
                String temp = scan.next();
                hashTable.insert(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if(scan!=null)scan.close();
        }catch(Exception e1){
            e1.printStackTrace();
        }

    }
    private void searchHash(String filename){
        Scanner scan = null;
        try{
            scan = new Scanner(new File(filename));
            while(scan.hasNext()){
                String temp = scan.next();
                hashTable.search(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if(scan!=null)scan.close();
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }
    private void printStats(String filename){
        BufferedWriter output = null;
        FileWriter out = null;
        try{
            double hasheff = (((0.71)/(hashTable.totalReads/maxSize))*100);
            out = new FileWriter(new File(filename));
            output = new BufferedWriter(out);
            output.write("The stats on the search of the Hash Table are:\n\n");
            output.write("Total reads: "+hashTable.totalReads+"\n");
            output.write("Longest Chain for a search: "+hashTable.maxChain+"\n");
            output.write("Average reads for a search: "+(hashTable.totalReads/hashTable.currentSize)+"\n");
            output.write("Load Factor is: 71%\n");
            output.write("Hash Efficiency: "+hasheff+"%\n");
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if(output!=null){
                output.close();
                out.close();
            }
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }
    // Method to check input from command line
	private static boolean CheckInput(String[] s) {
		if (s.length != 2)
			return false;
		else if (!(s[0].substring(s[0].length() - 4).equals(".txt"))) {
			System.out.println("ERROR: Input must be a text file");
			return false;
		} else if (!(s[1].substring(s[1].length() - 4).equals(".txt"))) {
			System.out.println("ERROR: Input must be a text file");
			return false;
		} else
			return true;
	}

}