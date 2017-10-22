import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MyFrame3 extends JFrame {
	JButton b1, b2;

	public MyFrame3(String s) {
		super(s);
		setLayout(new BorderLayout());
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Do Something");
			}
		});
		b2.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Do Something Else");
			}
		});
		add("North", b1);
		add("Center", b2);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // set initially
																// to do nothing
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

	public static void main(String args[]) {
		// Create the frame
		MyFrame3 frame = new MyFrame3("Frame 1");
		frame.pack();
		frame.setVisible(true);
	}
}
