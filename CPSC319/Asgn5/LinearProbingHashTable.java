
public class LinearProbingHashTable {
	
	private int currentSize, maxSize;
	
	private String[] keys;
	private String[] vals;
	
	LinearProbingHashTable(int c)
	{
		currentSize = 0;
		maxSize = c;
		keys = new String[maxSize];
		vals = new String[maxSize];
	}
	
	void makeEmpty(){
		currentSize = 0;
		keys = new String[maxSize];
		vals = new String[maxSize];
	}
	
	int getSize()
	{
		return this.currentSize;
	}
	
	private int hash(String key){
		return key.hashCode()%maxSize;
	}

	
	public void insert(String key, String val){
		int temp = hash(key);
		
		int i = temp;
		
		do{
			if(keys[i] == null){
				keys[i] = key;
				vals[i] = val;
				currentSize++;
				return;
			}
			if(keys[i].equals(key)){
				vals[i] = val;
				return;
			}
			i = (i + 1) % maxSize;
		}while(i != temp);
	}
	
	public String get(String key){	//*****not complete, fix*****
		
		int i = hash(key);
		
		while(keys[i] != null){
			if(keys[i].equals(key)){
				return vals[i];
			}	
			i = (i + 1) % maxSize;
		}

		return null;
	}
	
	
	public void PrintHashTable(){
		System.out.println("\nPrinting hash table: \n");
		for(int i = 0; i < maxSize; i++){
			if(keys[i] != null){
				System.out.println(keys[i] + " -> " + vals[i]);
			}
		}
	}
	
	public Boolean contains(String key){
		return get(key) != null;
	}
	
	public void remove(String key){
		if(!contains(key)) return;
		
		int i = hash(key);
		while(!key.equals(keys[i])) i = (i+1)%maxSize;
		
		keys[i] = vals[i] = null;
		
		for(i = (i+1) % maxSize; keys[i] != null; i = (i+1) % maxSize){
			String tmp1 = keys[i], temp2 = vals[i];
			keys[i] = vals[i] = null;
			currentSize--;
			insert(tmp1, temp2);
		}
		currentSize--;
		
	}
	
	

}
