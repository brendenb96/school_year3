import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.color.*;

/**
 * Frame for managing student records
 */
public class ex1 extends JFrame {
    // Declare variables to be used in frame
	JButton b1,b2,b3,b4;
    JTextArea t1;
    BinSearchTree tree;
    JScrollPane scroll;                         // Make the text area scrollable if needed
    JPanel bottom,top,center;                   // Panels for formatting frame
    /**
     * Constructor for ex1 Frame
     * @param s title of the frame
     */
	public ex1(String s) {
		super(s);
		setLayout(new BorderLayout());                          // Use the border layour
		b1 = new JButton("Create Tree From file");              // Create the buttons
        b2 = new JButton("Insert");
        b3 = new JButton("Search");
        b4 = new JButton("Browse");
        t1 = new JTextArea();
        t1.setEditable(false);                                  // Make text area read only
        scroll = new JScrollPane(t1);                           // Makes text area scrollable
        bottom = new JPanel();                                  // Create panels as flow layout
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
        center = new JPanel();
        center.setLayout(new FlowLayout(FlowLayout.CENTER));
        tree = new BinSearchTree();                             // Create data binary search tree for records
		b1.addActionListener(new ActionListener() {             // Create event for load file button

			@Override
			public void actionPerformed(ActionEvent e) {        // Open file choose to select the file, better than typing filename
				JFileChooser fileChooser = new JFileChooser();
                int value = fileChooser.showOpenDialog(null);
                if(value == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();  
                    try{
                        Scanner scan = new Scanner(file);       // Scan the file and add Node to the tree
                        while(scan.hasNext()){
                        String id = scan.next();
                        String faculty = scan.next();
                        String major = scan.next();
                        String year = scan.next();
                        tree.insert(id, faculty, major, year);
                        }
                    }
                    catch(IOException i){
                        i.printStackTrace();
                    }

                }
			}
		});
        b2.addActionListener(new ActionListener() {             // Create the event for add entry button
			@Override
			public void actionPerformed(ActionEvent e) {                // Opens new frame for text input
                JFrame prompt = new JFrame("New Student Entry Prompt"); // Format the new frame
                prompt.setLayout(new GridLayout(4,1));
                JPanel topp = new JPanel();
                JPanel midd = new JPanel();
                JPanel middlower = new JPanel();
                JPanel bott = new JPanel();

                topp.setLayout(new FlowLayout(FlowLayout.CENTER));          // Set layout
                middlower.setLayout(new FlowLayout(FlowLayout.CENTER));
                midd.setLayout(new FlowLayout(FlowLayout.CENTER));
                bott.setLayout(new FlowLayout(FlowLayout.CENTER));

                topp.add(new JLabel("Insert a New Student Record"));
                midd.add(new JLabel("Enter the ID:"));
                JTextField idfield = new JTextField(7);
                midd.add(idfield);

                midd.add(new JLabel("Enter Faculty:"));
                JTextField facultyfield = new JTextField(7);
                midd.add(facultyfield);
                
                middlower.add(new JLabel("Enter Student Major:"));
                JTextField majorfield = new JTextField(7);
                middlower.add(majorfield);

                middlower.add(new JLabel("Enter Year:"));
                JTextField yearfield = new JTextField(7);
                middlower.add(yearfield);
                JButton done = new JButton("Insert");
                done.addActionListener(new ActionListener(){            // Insert button takes all fields and adds Node to tree
                    @Override
                    public void actionPerformed(ActionEvent i){
                        tree.insert(idfield.getText(),facultyfield.getText(),majorfield.getText(),yearfield.getText());
                        prompt.dispose();
                    }
                });
                JButton exit = new JButton("Return to Main Window");    // Create button and event to return to main menu
                exit.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent i){
                        prompt.dispose();
                    }
                });
                bott.add(done);                                         // Add components to frame
                bott.add(exit);
                prompt.add(topp);
                prompt.add(midd);
                prompt.add(middlower);
                prompt.add(bott);
                prompt.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                done.setBackground(Color.GREEN);
                exit.setBackground(Color.RED);
                prompt.pack();
                prompt.setVisible(true);                                // Make frame visible
			}
		});
        b3.addActionListener(new ActionListener() {                     // Create event for searching tree

			@Override
			public void actionPerformed(ActionEvent e) {
                String searchkey = JOptionPane.showInputDialog("Please enter the search key:");
                Node searchresult = tree.find(tree.root,searchkey);
                if(searchresult != null) JOptionPane.showMessageDialog(null,searchresult.toString(),"Search Results",JOptionPane.PLAIN_MESSAGE);
                else JOptionPane.showMessageDialog(null,"No id found.","Search Results",JOptionPane.PLAIN_MESSAGE);
			}
		});
        b4.addActionListener(new ActionListener() {                     // Create event for printing the tree
			@Override
			public void actionPerformed(ActionEvent e) {
            try{

                if(!tree.empty())tree.print_tree(tree.root,t1);
            }catch(IOException o){
                o.printStackTrace();
            }
               
			}
		});
		bottom.add(b1);                                                 // Add components to final frame
        bottom.add(b2);
        bottom.add(b3);
        bottom.add(b4);
        center.add(scroll);
        top.add(new JLabel("An Application to Maintain Student Records"));
        add(scroll,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);
        add(top,BorderLayout.NORTH);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);           // Create a confirm close option
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//JFrame frame = (JFrame) e.getSource();
				int result = JOptionPane.showConfirmDialog((JFrame) e.getSource(), "Are you sure you want to exit the application?",
						"Exit Application", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION)
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	public static void main(String args[]) {                            // Main function to display frame
		// Create the frame
		ex1 frame = new ex1("Lab Excersise 1");
        frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
