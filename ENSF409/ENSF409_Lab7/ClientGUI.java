import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.color.*;

public class ClientGUI extends JFrame {

    JPanel topleft, botleft, right;
    GridBagConstraints gbc;
    GridBagConstraints tl,bl,rt;

    public ClientGUI() {
        super("Client Managment Screen");
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        tl = new GridBagConstraints();
        bl = new GridBagConstraints();
        rt = new GridBagConstraints();

        setPanelFormat();

        JLabel searchclients = new JLabel("Search Clients");
        tl.gridx = 0;
        tl.gridy = 0;
        topleft.add(searchclients,tl);
        JLabel searchinst = new JLabel("Select type of search:");
        tl.gridx = 0;
        tl.gridy = 1;
        topleft.add(searchinst,tl);
        JButton hello = new JButton("hello");
        tl.gridx = 0;
        tl.gridy = 2;
        topleft.add(hello,tl);
        JButton h = new JButton("h");
        tl.gridx = 0;
        tl.gridy = 3;
        topleft.add(h,tl);


        setCloseOp();

        pack();
        setResizable(false);
        setVisible(true);
    }

    public void setPanelFormat() {
        topleft = new JPanel();
        topleft.setLayout(new GridBagLayout());
        topleft.setPreferredSize(new Dimension(400, 400));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        topleft.setBackground(Color.GREEN);
        add(topleft, gbc);

        botleft = new JPanel();
        botleft.setPreferredSize(new Dimension(400, 400));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        botleft.setBackground(Color.BLACK);
        ;
        add(botleft, gbc);

        right = new JPanel();
        right.setPreferredSize(new Dimension(400, 800));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        right.setBackground(Color.RED);
        add(right, gbc);
    }

    public void setCloseOp(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);                   // Create a confirm close option
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //JFrame frame = (JFrame) e.getSource();
                int result = JOptionPane.showConfirmDialog((JFrame) e.getSource(),
                        "Are you sure you want to exit the application?", "Exit Application",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) {
        ClientGUI frame = new ClientGUI();

    }
}