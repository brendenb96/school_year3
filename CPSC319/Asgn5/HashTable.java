import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


public class HashTable {
	
	private String[] words;

	int currentSize;
	int maxSize;
	int maxChain = 0;
	int totalReads = 0;


	public HashTable(int c) {
		currentSize = 0;
		maxSize = c;
		words = new String[maxSize];
	}

	void makeEmpty(){
		currentSize = 0;
		words = new String[maxSize];
	}
	private  int myHash(String key){
		int hash = 0x811c9dc5;
		int prime = 0x01000193;
		for(int i = 0; i < key.length(); i++){
			hash = hash ^ key.charAt(i);
			hash = hash*prime;
		}	
		if(hash < 0)hash*=(-1);
		return hash%maxSize;
	}
	public void insert(String key){
		int temp = myHash(key);
		int i = temp;		
		do{
			if(words[i] == null){
				words[i] = key;
				currentSize++;
				return;
			}
			if(words[i].equals(key)){
		      words[i] = key;
			  return;
			}
			i = (i + 1) % maxSize;
		}while(i != temp);
		
		
	}
	public void getnulls(){
		int c = 0;
		for(int i = 0; i < maxSize; i++){
			if(words[i]==null)c++;
		}
		System.out.println(c);
	}
    public void search(String key) 
    {
    	
        int i = myHash(key);
        int reads = 0;
        while (words[i] != null){	
        	reads++;
            if (words[i].equals(key)){
            	break;
            }

            i = (i + 1)% maxSize;
        }            
        totalReads += reads;
    	if(maxChain < reads)maxChain = reads;
    }
   
    public String get(String key) 
    {
        int i = myHash(key);
        while (words[i] != null)
        {
            if (words[i].equals(key))
                return words[i];
            i = (i + 1) % maxSize;
        }            
        return null;
    }

    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (words[i] != null)
                System.out.println(words[i]);
        System.out.println();
    }   
    
    public void outputHashTable(BufferedWriter output) throws IOException
    {
        for (int i = 0; i < maxSize; i++){
        
        		 if (words[i] != null) {
        			 output.write(words[i] + "\n");
        		 }
        }
        output.write("\nMax Chain: " + maxChain + "\nTotal Reads: " + totalReads);
        output.write("\nAverage Reads: " + totalReads / currentSize);
        
        
    }
    
   


}
