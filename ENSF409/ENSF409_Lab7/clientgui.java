
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clientgui extends JFrame {


	
	private static final long serialVersionUID = 1L;
	private JTextField txtSearchparam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientgui frame = new clientgui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public clientgui() {
		
		super("Client Managment Screen");
        
       
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
        setSize(798,787);
        setResizable(false);
        
        JPanel topleft = new JPanel();
        
        JPanel botleft = new JPanel();
        
        JPanel right = new JPanel();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(botleft, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(topleft, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(right, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(23)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(right, GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(topleft, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(botleft, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        
        JLabel lblClientInformation = new JLabel("Client Information");
        lblClientInformation.setFont(new Font("Dialog", Font.BOLD, 14));
        GroupLayout gl_right = new GroupLayout(right);
        gl_right.setHorizontalGroup(
        	gl_right.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_right.createSequentialGroup()
        			.addContainerGap(118, Short.MAX_VALUE)
        			.addComponent(lblClientInformation)
        			.addGap(89))
        );
        gl_right.setVerticalGroup(
        	gl_right.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_right.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblClientInformation)
        			.addContainerGap(723, Short.MAX_VALUE))
        );
        right.setLayout(gl_right);
        
        JLabel lblSearchResults = new JLabel("Search Results");
        
        JTextArea resultstextarea = new JTextArea();
        resultstextarea.setEditable(false);
        GroupLayout gl_botleft = new GroupLayout(botleft);
        gl_botleft.setHorizontalGroup(
        	gl_botleft.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_botleft.createSequentialGroup()
        			.addGroup(gl_botleft.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_botleft.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblSearchResults))
        				.addGroup(gl_botleft.createSequentialGroup()
        					.addGap(22)
        					.addComponent(resultstextarea, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(27, Short.MAX_VALUE))
        );
        gl_botleft.setVerticalGroup(
        	gl_botleft.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_botleft.createSequentialGroup()
        			.addComponent(lblSearchResults)
        			.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        			.addComponent(resultstextarea, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        botleft.setLayout(gl_botleft);
        
        JLabel lblSearchClients = new JLabel("Search Clients");
        lblSearchClients.setFont(new Font("Dialog", Font.BOLD, 14));
        
        JLabel lblSelectTypeOf = new JLabel("Select type of search to be performed:");
        
        JRadioButton rdbtnClientId = new JRadioButton("Client ID");
        
        JRadioButton rdbtnLastName = new JRadioButton("Last Name");
        
        JRadioButton rdbtnClientType = new JRadioButton("Client Type");
        
        JLabel lblEnterTheSearch = new JLabel("Enter the search parameter below:");
        
        txtSearchparam = new JTextField();
        txtSearchparam.setColumns(10);
        
        JButton btnSearch = new JButton("Search");
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        GroupLayout gl_topleft = new GroupLayout(topleft);
        gl_topleft.setHorizontalGroup(
        	gl_topleft.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_topleft.createSequentialGroup()
        			.addContainerGap(114, Short.MAX_VALUE)
        			.addComponent(lblSearchClients)
        			.addGap(157))
        		.addGroup(gl_topleft.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblSelectTypeOf)
        			.addContainerGap(99, Short.MAX_VALUE))
        		.addGroup(gl_topleft.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(rdbtnClientId)
        			.addContainerGap(293, Short.MAX_VALUE))
        		.addGroup(gl_topleft.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(rdbtnLastName)
        			.addContainerGap(277, Short.MAX_VALUE))
        		.addGroup(gl_topleft.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(rdbtnClientType)
        			.addContainerGap(273, Short.MAX_VALUE))
        		.addGroup(gl_topleft.createSequentialGroup()
        			.addGap(30)
        			.addGroup(gl_topleft.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblEnterTheSearch)
        				.addGroup(gl_topleft.createSequentialGroup()
        					.addComponent(txtSearchparam, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_topleft.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(btnClear, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(btnSearch, Alignment.TRAILING))))
        			.addContainerGap(48, Short.MAX_VALUE))
        );
        gl_topleft.setVerticalGroup(
        	gl_topleft.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_topleft.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblSearchClients)
        			.addGap(56)
        			.addComponent(lblSelectTypeOf)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(rdbtnClientId)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(rdbtnLastName)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(rdbtnClientType)
        			.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
        			.addComponent(lblEnterTheSearch)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_topleft.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtSearchparam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnSearch))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnClear)
        			.addGap(46))
        );
        topleft.setLayout(gl_topleft);
        getContentPane().setLayout(groupLayout);
        setVisible(true);
	}
}
