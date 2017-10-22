

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Gui extends JFrame{
    public JFrame frame;
    public TicTac panel;

    public Gui(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Create a confirm close option
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //JFrame frame = (JFrame) e.getSource();
                int result = JOptionPane.showConfirmDialog((JFrame) e.getSource(),
                        "Are you sure you want to exit the application?", "Exit Application",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        frame.setSize(600,600);
        frame.setVisible(true);
    }

}