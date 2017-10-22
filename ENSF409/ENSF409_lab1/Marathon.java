
import java.util.ArrayList;
import java.util.Scanner;

class Marathon{
//Implement your method
public static void main (String[] args) {
// Define two array lists here to store the names and the running times
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Double> times = new ArrayList<Double>();
// Read user input
    String sin;
    Scanner scan = new Scanner(System.in);
    while (true){
        System.out.println("Please enter the name of the participant(or QUIT)");
        sin = scan.nextLine();
        if(sin.toUpperCase().equals("QUIT")) break;
// Add the name to your ArrayList
    names.add(sin);
    System.out.println("Please enter the running time of the participant in minutes:");
    sin = scan.nextLine();
// Add the running time to your array list

    times.add(Double.parseDouble(sin));
}
// Call the function findFastestRunner and pass the running times array list to it
 // Print the name of the fastestrunner to the console
  int fastest_index = fastest_run(times);
  System.out.println("The fastest runner is "+names.get(fastest_index)+" with at time of "+times.get(fastest_index)+ " min.");
}
public static int fastest_run(ArrayList<Double> arr){
    int smallest_index = 0;
    for(int i = 0; i < arr.size(); i++){
        if(arr.get(i)<arr.get(smallest_index))smallest_index = i;
    }
    return smallest_index;
  }
}
