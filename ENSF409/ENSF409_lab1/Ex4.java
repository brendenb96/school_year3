import java.util.Scanner;
import java.lang.Character;
import java.util.Arrays;

public class Ex4{
    //Initialize the arrays
    private static Character[][] char_output = new Character[3][60]; 

    public static void main(String[] args){
        Ex4 example = new Ex4();

        String input;                           // Get input from console
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a sentence: (max 60 letters)");
        input = scan.nextLine();
        
        example.flip_array(input);          //Change arrays
        example.flip_words(input);
        example.capitalize_letters(input);

        for(int j = 0; j < 3;j++){                          //Print the arrays
            for(int i = 0; char_output[j][i]!=null ;i++){
                System.out.print(char_output[j][i]);}
                System.out.println(""); }
            }
    public void capitalize_letters(String s){   //Capitalize every 5th letter
        s = s.toLowerCase();                        //Convert all to lowercase
        char[] temp = s.toCharArray();          //Convert to char array
        for(int i = 0; i < s.length(); i++){    //Convert every 5th to capital letter
            char_output[2][i] = temp[i];        // Put char into Character
            if(i%5 == 0)char_output[2][i] = Character.toUpperCase(temp[i]);}
    }
    public void flip_words(String s){       //Reverse word order
        String[] parts = s.split(" ");                      //Split into substrings
        String[] flip_parts = new String[parts.length]; 
        for(int i = 0; i < parts.length; i++){
            flip_parts[i] = parts[(parts.length-1)-i];}     //Reverse order of substrings
        String temp_string = "";
        for(int i = 0; i < flip_parts.length; i++){         //Add substrings back together
            temp_string+= flip_parts[i]+" ";}
        char[] temp_char = temp_string.toCharArray();   
        for(int i = 0; i < temp_string.length();i++){       //Put char into Character
            char_output[1][i] = temp_char[i];}
    }
    public void flip_array(String input){       //Reverse all letters method
        int len = input.length();
        char[] charArray = input.toCharArray();      //Convert string to char array 
        for(int i = 0; i < len; i++){        //REVERSE
            char_output[0][i] = charArray[(len-1)-i]; } //Put char into Character
    }

}