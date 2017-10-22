
public class Driver {

	public static void main(String[] args) {
		
		LinearProbingHashTable pt = new LinearProbingHashTable(5);
		
		pt.insert("Na", "Sodium");
		pt.insert("H", "Hydrogen");
		pt.insert("Cl", "Chlorine");
		pt.insert("K", "Potassium");
		pt.insert("Ca", "Calcium");
		
		pt.PrintHashTable();
		pt.remove("C1");
		
		pt.PrintHashTable();
		
		//System.out.println("Looking for O: " + pt.get("O"));
		
		//pt.PrintHashTable();
		
	}

}
