import java.text.DecimalFormat;



public class Averagecalculator{

    public static void main(String[] args){
        double sum = 0.0;
        System.out.print("The "+args.length+" numbers are:");
        for(int i = 0; i < args.length; i++){
            System.out.print(" "+args[i]);
            sum += Double.parseDouble(args[i]);
        }
        double average = sum/args.length;
        DecimalFormat three_places = new DecimalFormat("#0.000");
        System.out.print("\n The average is: " + three_places.format(average));

    }



}