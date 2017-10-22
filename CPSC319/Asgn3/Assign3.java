
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Assign3 {

    public static void main(String[] args) {

        if(!CheckInput(args)){
            System.err.println("Invalid arguments. Command line format should be - java Assign3 input output1 output2");
            System.exit(1);
        }

        String inputfile = args[0];
        String outputfiledepth= args[1];
        String outputfilebreadth = args[2];
        BinaryTree tree = new BinaryTree();
        File source = new File(inputfile);
        try {
            Scanner scan = new Scanner(source);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if(line.charAt(0) == 'I') tree.insert(line);
                if(line.charAt(0) == 'D'){
                    tree.delete(tree.root, line.substring(8, 32)); 
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        
        try{
            FileWriter fw_breadth = new FileWriter(outputfilebreadth);
            FileWriter fw_depth = new FileWriter(outputfiledepth);
            BufferedWriter outbreadth = new BufferedWriter(fw_breadth);
            BufferedWriter outdepth = new BufferedWriter(fw_depth);
            System.out.println("Breadth First:");        
            tree.printBreadth(tree.root, outbreadth);
            System.out.println("Depth First:");
            tree.printDepth(tree.root, outdepth);
            outbreadth.close();
            outdepth.close();
        } catch(IOException e){
            e.getMessage();
        }

    }
    protected static boolean CheckInput(String[] s){
        if(s.length != 3) return false;
        else if(!(s[0].substring(s[0].length()-4).equals(".txt"))){
            System.out.println("ERROR: Input must be a text file");
            return false;
        }
        else if(!(s[1].substring(s[1].length()-4).equals(".txt"))){
            System.out.println("ERROR: Output must be a text file");
            return false;
        }
        else if(!(s[2].substring(s[2].length()-4).equals(".txt"))){
            System.out.println("ERROR: Output must be a text file");
            return false;
        }
        else return true;
    }
}
