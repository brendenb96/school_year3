import java.util.Scanner;


public class SinValidator {

private int[] SIN;

private int sumDigit(int x)
{
	int result =0;
	
	while(x > 0){
		result += x % 10;
		x = x /10;
	}
	
	return result;
}

	public SinValidator(String sin) {

		SIN = new int[9];
		int i =0;
		int counter =0;
		while(i < sin.length()){

			
			if(Character.isDigit(sin.charAt(i))){
				if(counter < 9)
					SIN[counter] =(int) sin.charAt(i) - 48;
				counter++;
			}
			else{
				System.err.println("Error: Invalid input by the user");
				return;
			}
			i++;
		}
		
		if(counter != 9){
			System.err.println("Error: SIN must be 9 digits...");
			return;
		}	
	}
	
	public boolean validateSin()
	{
		int step2_a,step2_b,step2_c,step2_d;
		int sum = 0;
		int[] digits = {1,3,5,7};
		int step1 = SIN[0]+SIN[2]+SIN[4]+SIN[6];
		for(int i = 0; i < digits.length; i++){
		step2_a = SIN[digits[i]]*2;
		step2_b = step2_a/10;
		step2_c = step2_a%10;
		step2_d = step2_b + step2_c;
		sum += step2_d;	}
		int step5 = step1 + sum;
		int step6 = 10 - step5%10;
		if(step6 == SIN[8])return true;
		else return false;
		
	}

	public static void main(String[] args) {
		// Read user input
	
	    String sin;
		Scanner scan = new Scanner(System.in);	
		while (true)
		{
			System.out.println("Please enter your 10 digit social insuracne number"
					+ " or enter quit to terminate the program: ");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			SinValidator sv = new SinValidator(sin);
			if(sv.validateSin())
				System.out.println("Yes this is a valid SIN\n");
			else
				System.out.println("No this is NOT a valid SIN\n");
			
		}
	}

}
