/**
 * @author Dylan Oszust
 * 3/12/2017
 * This class is the login screen to allow the user to login to the system
 */

package guitarApp;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class GuitarBuilderLoginScreen {

	private JFrame login;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					GuitarBuilderLoginScreen window = new GuitarBuilderLoginScreen();
					window.login.setVisible(true);
					
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuitarBuilderLoginScreen()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		login = new JFrame();
		login.setResizable(false);
		login.setTitle("Guitar Builder");
		login.setBounds(100, 100, 247, 223);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		login.setLocation(dim.width/2-login.getSize().width/2, dim.height/2-login.getSize().height/2);
		
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 221, 25);
		login.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(10, 47, 77, 25);
		login.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(10, 83, 77, 25);
		login.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setText("");
		username.setBounds(97, 51, 134, 20);
		login.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setText("");
		password.setColumns(10);
		password.setBounds(97, 87, 134, 20);
		login.getContentPane().add(password);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				String conUsername = username.getText();
				String conPassword = password.getText();
				
				try
				{
					//OracleJDBC.connect(conUsername, conPassword);
					OracleJDBC.connect(conUsername, conPassword);
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password",
                            null, JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
					return;
				} 
				catch (ClassNotFoundException e1)
				{
					JOptionPane.showMessageDialog(null, "JDBC Driver not found", "Error",
			                     JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				         return;
				}
				
				GuitarBuilderMainMenu.createMainMenu();
				login.dispose();
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(10, 119, 221, 54);
		login.getContentPane().add(btnLogin);
	}
}
