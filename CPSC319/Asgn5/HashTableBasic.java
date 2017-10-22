
import java.util.Hashtable;


public class HashTableBasic {

	public static void main(String[] args) {
		Hashtable pt = new Hashtable();
		
		pt.put("Na", "Sodium");
		pt.put("K", "Potassium");
		pt.put("Ca", "Calcium");
		pt.put("H", "Hydrogen");
		
		
		System.out.println("Ca: " + pt.get("Ca"));
		
		System.out.println("Looking for O: " + pt.contains("O"));

	}

}
