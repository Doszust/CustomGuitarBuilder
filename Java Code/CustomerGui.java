/**
 * Author Dylan Oszust
 * 3/12/2017
 * This class creates the window to add, update, review, and delete customers from the database,
 * and accesses the database connection driver
 */

package guitarApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CustomerGui
{

	private JFrame frmCustomers;
	private JTextField txtCustomerID;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private final ButtonGroup updateReturnCustomerButtonGroup = new ButtonGroup();
	private JTextField txtUpdateAddress;
	private JTextField txtUpdateEmail;
	private JTextField txtUpdatePhoneNumber;
	private JTextField txtUpdateLastName;
	private JTextField txtUpdateFirstName;
	private JTextField txtUpdateID;
	private JTextField txtReviewCustomerID;
	private JTextField txtDeleteCustomerID;
	private final ButtonGroup returnCustomerButtonGroup = new ButtonGroup();


	/**
	 * Launch Window
	 */
	public static void createCustomerGui()
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					CustomerGui window = new CustomerGui();
					window.frmCustomers.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the window.
	 */
	public CustomerGui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the window.
	 */
	private void initialize()
	{
				
		frmCustomers = new JFrame();
		frmCustomers.setResizable(false);
		frmCustomers.setTitle("Guitar Builder - Customers");
		frmCustomers.setBounds(100, 100, 499, 354);
		frmCustomers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomers.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmCustomers.setLocation(dim.width/2-frmCustomers.getSize().width/2, dim.height/2-frmCustomers.getSize().height/2); //launches window in center of the screen.
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP); //creates a tabbed pane
		frmCustomers.getContentPane().add(tabbedPane);
		
		//create customer tab
		JPanel pnlCreateCustomer = new JPanel();
		tabbedPane.addTab("Create Customer", null, pnlCreateCustomer, null);
		pnlCreateCustomer.setLayout(null);
		
		//lables on create customer tab
		JLabel lblCustomerID = new JLabel("Enter Customer ID:");
		lblCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerID.setBounds(10, 11, 126, 14);
		pnlCreateCustomer.add(lblCustomerID);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(10, 36, 126, 14);
		pnlCreateCustomer.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(10, 62, 126, 14);
		pnlCreateCustomer.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(10, 87, 126, 14);
		pnlCreateCustomer.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 112, 126, 14);
		pnlCreateCustomer.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(10, 137, 126, 14);
		pnlCreateCustomer.add(lblAddress);
		
		JLabel lblReturnCustomer = new JLabel("Return Customer:");
		lblReturnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReturnCustomer.setBounds(10, 162, 126, 14);
		pnlCreateCustomer.add(lblReturnCustomer);
		
		//input objects on create customer tab
		txtCustomerID = new JTextField("");
		txtCustomerID.setToolTipText("Enter a customer ID that is 5 digits or less.");
		txtCustomerID.setBounds(146, 10, 332, 20);
		pnlCreateCustomer.add(txtCustomerID);
		txtCustomerID.setColumns(10);
		
		txtFirstName = new JTextField("");
		txtFirstName.setToolTipText("Enter a First Name");
		txtFirstName.setBounds(146, 35, 332, 20);
		pnlCreateCustomer.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField("");
		txtLastName.setToolTipText("Enter a Last Name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(146, 61, 332, 20);
		pnlCreateCustomer.add(txtLastName);
		
		txtPhoneNumber = new JTextField("");
		txtPhoneNumber.setToolTipText("Enter a Phone Number");
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(146, 86, 332, 20);
		pnlCreateCustomer.add(txtPhoneNumber);
		
		txtEmail = new JTextField("");
		txtEmail.setToolTipText("Enter an Email Address");
		txtEmail.setColumns(10);
		txtEmail.setBounds(146, 111, 332, 20);
		pnlCreateCustomer.add(txtEmail);
		
		txtAddress = new JTextField("");
		txtAddress.setToolTipText("Enter an Adress");
		txtAddress.setColumns(10);
		txtAddress.setBounds(146, 136, 332, 20);
		pnlCreateCustomer.add(txtAddress);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		returnCustomerButtonGroup.add(rdbtnNo);
		rdbtnNo.setSelected(true);
		rdbtnNo.setBounds(146, 160, 45, 23);
		pnlCreateCustomer.add(rdbtnNo);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		returnCustomerButtonGroup.add(rdbtnYes);
		rdbtnYes.setBounds(193, 160, 53, 23);
		pnlCreateCustomer.add(rdbtnYes);
		
		//stores information in database 
		JButton btnCreateCustomer = new JButton("Create Customer");
		btnCreateCustomer.addActionListener(new ActionListener()
		{
			//event handler for create customer button
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				
				try
				{
					ID = Integer.parseInt(txtCustomerID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				String first = txtFirstName.getText();
				String last = txtLastName.getText();
				String phone = txtPhoneNumber.getText();
				String address = txtAddress.getText();
				String email = txtEmail.getText();
				
				if(first.isEmpty())
				{
					first = "N/A";
				}
				if(last.isEmpty())
				{
					last = "N/A";
				}
				if(phone.isEmpty())
				{
					phone = "N/A";
				}
				if(address.isEmpty())
				{
					address = "N/A";
				}
				if(email.isEmpty())
				{
					email = "N/A";
				}
				
				
				
				
				
				char returnCustomer;
				
				if(rdbtnYes.isSelected())
					returnCustomer = 'Y';
				else
				{
					returnCustomer = 'N';
				}
				
				//confirmation dialog
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nFirst Name: " + first + "\nLast Name: " + last
						+ "\nPhone Number: " + phone + "\nAddress: " + address + "\nEmail: "
						+ email + "\nReturn Customer: " + returnCustomer, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				//if information confirmed, commits data to database.
				if(choice == 0)
				{
					
					Customer create = new Customer(ID, first, last, phone, address, email, returnCustomer); //creates customer object
					
					try
					{
						OracleJDBC.writeCustomer(create); //passes to method that writes customer to database
					} 
					catch (SQLException e1)
					{
						
						if (e1.getErrorCode() == 12899) 
						{
							String message = e1.getMessage();
							
							if(message.contains("ORA-12899: value too large for column \"DYLAN\".\"CUSTOMER\".\"FIRSTNAME\""))
							{
								JOptionPane.showMessageDialog(null, "First name is too Long, Max Length = 12",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);	//sql error that email is too long
							}
							else if(message.contains("ORA-12899: value too large for column \"DYLAN\".\"CUSTOMER\".\"LASTNAME\""))
							{
								JOptionPane.showMessageDialog(null, "Last name is too Long, Max Length = 50",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);	//sql error that email is too long
							}
							else if(message.contains("ORA-12899: value too large for column \"DYLAN\".\"CUSTOMER\".\"PHONE\""))
							{
								JOptionPane.showMessageDialog(null, "Phone number is too Long, Max Length = 14",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);	//sql error that email is too long
							}
							else if(message.contains("ORA-12899: value too large for column \"DYLAN\".\"CUSTOMER\".\"ADDRESS\""))
							{
								JOptionPane.showMessageDialog(null, "Address is too Long, Max Length = 50",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);	//sql error that email is too long
							}
							else if(message.contains("ORA-12899: value too large for column \"DYLAN\".\"CUSTOMER\".\"EMAIL\""))
							{
								JOptionPane.showMessageDialog(null, "EMAIL is too Long, Max Length = 50",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);	//sql error that email is too long
							}
						}
											
						else if (e1.getErrorCode() == 00001) //sql error for PK constraint violation
							JOptionPane.showMessageDialog(null, "Customer ID already in use",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else if (e1.getErrorCode() == 1438) //sql error for customer ID too long
							JOptionPane.showMessageDialog(null, "Customer ID to long, must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Customer Created",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
					//clears form
					clearForm();
					rdbtnNo.isSelected();
				}
				else
					return;
				
				
			}
		});
		btnCreateCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreateCustomer.setBounds(10, 199, 226, 86);
		pnlCreateCustomer.add(btnCreateCustomer);
		
		//main menu button
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GuitarBuilderMainMenu.createMainMenu(); //opens main menu screen
				frmCustomers.dispose(); //closes current screen without exiting application
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMainMenu.setBounds(252, 199, 226, 86);
		pnlCreateCustomer.add(btnMainMenu);
		
		
		//update customer tab
		JPanel pnlUpdateCustomer = new JPanel();
		tabbedPane.addTab("Update Customer", null, pnlUpdateCustomer, null);
		pnlUpdateCustomer.setLayout(null);
		
		//main menu button
		JButton btnUpdateMainMenu = new JButton("Main Menu");
		btnUpdateMainMenu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GuitarBuilderMainMenu.createMainMenu(); //opens main menu screen
				frmCustomers.dispose(); //closes current screen without exiting application
			}
		});
		btnUpdateMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateMainMenu.setBounds(252, 199, 226, 86);
		pnlUpdateCustomer.add(btnUpdateMainMenu);

		
		JRadioButton radUpdateNo = new JRadioButton("No");
		radUpdateNo.setSelected(true);
		updateReturnCustomerButtonGroup.add(radUpdateNo);
		radUpdateNo.setBounds(146, 160, 45, 23);
		pnlUpdateCustomer.add(radUpdateNo);
		
		JRadioButton radUpdateYes = new JRadioButton("Yes");
		updateReturnCustomerButtonGroup.add(radUpdateYes);
		radUpdateYes.setBounds(193, 160, 57, 23);
		pnlUpdateCustomer.add(radUpdateYes);
		
		//update customer button
		JButton btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.setEnabled(false);
		btnUpdateCustomer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int ID = Integer.parseInt(txtUpdateID.getText());
				String first = txtUpdateFirstName.getText();
				String last = txtUpdateLastName.getText();
				String phone = txtUpdatePhoneNumber.getText();
				String address = txtUpdateAddress.getText();
				String email = txtUpdateEmail.getText();
				char returnCustomer;
				
				if(first.isEmpty())
				{
					first = "N/A";
				}
				if(last.isEmpty())
				{
					last = "N/A";
				}
				if(phone.isEmpty())
				{
					phone = "N/A";
				}
				if(address.isEmpty())
				{
					address = "N/A";
				}
				if(email.isEmpty())
				{
					email = "N/A";
				}
				
				if(radUpdateYes.isSelected())
					returnCustomer = 'Y';
				else
				{
					returnCustomer = 'N';
				}
				
				//confirms information
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nFirst Name: " + first + "\nLast Name: " + last
						+ "\nPhone Number: " + phone + "\nAddress: " + address + "\nEmail: "
						+ email + "\nReturn Customer: " + returnCustomer, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if(choice == 0)
				{
					
					Customer update = new Customer(ID, first, last, phone, address, email, returnCustomer);
					
					try
					{
						OracleJDBC.updateCustomer(update);
					} 
					catch (SQLException e1)
					{
							
						e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Customer Updated",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
					//clears form
					clearForm();
					rdbtnNo.isSelected();
					btnUpdateCustomer.setEnabled(false);
				}
				else
					return;
			}
		});
		btnUpdateCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateCustomer.setBounds(10, 199, 226, 86);
		pnlUpdateCustomer.add(btnUpdateCustomer);
		
		//update tab labels
		JLabel lblUpdateReturnCustomer = new JLabel("Return Customer:");
		lblUpdateReturnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateReturnCustomer.setBounds(10, 162, 126, 14);
		pnlUpdateCustomer.add(lblUpdateReturnCustomer);
		
		JLabel lblUpdateAddress = new JLabel("Address:");
		lblUpdateAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateAddress.setBounds(10, 137, 126, 14);
		pnlUpdateCustomer.add(lblUpdateAddress);
		
		JLabel lblUpdateEmail = new JLabel("Email:");
		lblUpdateEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateEmail.setBounds(10, 112, 126, 14);
		pnlUpdateCustomer.add(lblUpdateEmail);
		
		JLabel lblUpdatePhoneNumber = new JLabel("Phone Number:");
		lblUpdatePhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdatePhoneNumber.setBounds(10, 87, 126, 14);
		pnlUpdateCustomer.add(lblUpdatePhoneNumber);
		
		JLabel lblUpdateLastName = new JLabel("Last Name:");
		lblUpdateLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateLastName.setBounds(10, 62, 126, 14);
		pnlUpdateCustomer.add(lblUpdateLastName);
		
		JLabel lblUpdateFirstName = new JLabel("First Name:");
		lblUpdateFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateFirstName.setBounds(10, 36, 126, 14);
		pnlUpdateCustomer.add(lblUpdateFirstName);
		
		JLabel lblEnterCustomerId = new JLabel("Enter Customer ID For Update:");
		lblEnterCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterCustomerId.setBounds(10, 11, 204, 14);
		pnlUpdateCustomer.add(lblEnterCustomerId);
		
		//input objects for update
		txtUpdateAddress = new JTextField();
		txtUpdateAddress.setColumns(10);
		txtUpdateAddress.setBounds(146, 136, 332, 20);
		pnlUpdateCustomer.add(txtUpdateAddress);
		txtUpdateEmail = new JTextField();
		txtUpdateEmail.setColumns(10);
		txtUpdateEmail.setBounds(146, 111, 332, 20);
		pnlUpdateCustomer.add(txtUpdateEmail);
		txtUpdatePhoneNumber = new JTextField();
		txtUpdatePhoneNumber.setColumns(10);
		txtUpdatePhoneNumber.setBounds(146, 86, 332, 20);
		pnlUpdateCustomer.add(txtUpdatePhoneNumber);
		txtUpdateLastName = new JTextField();
		txtUpdateLastName.setColumns(10);
		txtUpdateLastName.setBounds(146, 61, 332, 20);
		pnlUpdateCustomer.add(txtUpdateLastName);
		txtUpdateFirstName = new JTextField();
		txtUpdateFirstName.setColumns(10);
		txtUpdateFirstName.setBounds(146, 35, 332, 20);
		pnlUpdateCustomer.add(txtUpdateFirstName);
		txtUpdateID = new JTextField();
		txtUpdateID.setColumns(10);
		txtUpdateID.setBounds(224, 10, 180, 20);
		pnlUpdateCustomer.add(txtUpdateID);
		
		//brings current info into text fields for editing, and enables the update button
		JButton btnUpdateEnterID = new JButton("Enter");
		btnUpdateEnterID.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int ID = Integer.parseInt(txtUpdateID.getText());
				int returnID = 0;
				String first = null;
				String last = null;
				String phone = null;
				String address = null;
				String email = null;
				String returnCustomer = null; 
				
				//gets current info
				try
				{
					returnID = OracleJDBC.readCustomerID(ID);
					first = OracleJDBC.readCustomerFirstName(ID);
					last = OracleJDBC.readCustomerLastName(ID);
					phone = OracleJDBC.readCustomerPhoneNumber(ID);
					address = OracleJDBC.readCustomerAddress(ID);
					email = OracleJDBC.readCustomerEmail(ID);
					returnCustomer = OracleJDBC.readReturnCustomer(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Customer Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnID != 0) //checks if customer exists
				{
				
					txtUpdateFirstName.setText(first);
					txtUpdateLastName.setText(last);
					txtUpdatePhoneNumber.setText(phone);
					txtUpdateAddress.setText(address);
					txtUpdateEmail.setText(email);
					
					if(returnCustomer.equals("Y"))
					{
						radUpdateYes.setSelected(true);
					}
					
					btnUpdateCustomer.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Customer Info, Customer ID " + ID +" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					
					clearForm();
					return;
				}
					
			}
		});
		btnUpdateEnterID.setBounds(414, 9, 64, 21);
		pnlUpdateCustomer.add(btnUpdateEnterID);
		
		JPanel pnlReviewCustomer = new JPanel();
		tabbedPane.addTab("Review Customer", null, pnlReviewCustomer, null);
		pnlReviewCustomer.setLayout(null);
		
		JLabel lblReviewCustomerID = new JLabel("Enter Customer ID To Review Information");
		lblReviewCustomerID.setHorizontalAlignment(SwingConstants.CENTER);
		lblReviewCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewCustomerID.setBounds(10, 12, 468, 19);
		pnlReviewCustomer.add(lblReviewCustomerID);
		
		txtReviewCustomerID = new JTextField();
		txtReviewCustomerID.setHorizontalAlignment(SwingConstants.CENTER);
		txtReviewCustomerID.setColumns(10);
		txtReviewCustomerID.setBounds(10, 34, 468, 20);
		pnlReviewCustomer.add(txtReviewCustomerID);
		
		JLabel lblReviewFirstName = new JLabel("First Name:");
		lblReviewFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewFirstName.setBounds(10, 130, 74, 14);
		pnlReviewCustomer.add(lblReviewFirstName);
		
		JLabel lblReviewLastName = new JLabel("Last Name:");
		lblReviewLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewLastName.setBounds(10, 156, 74, 14);
		pnlReviewCustomer.add(lblReviewLastName);
		
		JLabel lblReviewPhoneNumber = new JLabel("Phone Number:");
		lblReviewPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewPhoneNumber.setBounds(10, 181, 97, 14);
		pnlReviewCustomer.add(lblReviewPhoneNumber);
		
		JLabel lblReviewEmail = new JLabel("Email:");
		lblReviewEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewEmail.setBounds(10, 206, 44, 14);
		pnlReviewCustomer.add(lblReviewEmail);
		
		JLabel lblReviewAddress = new JLabel("Address:");
		lblReviewAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewAddress.setBounds(10, 231, 74, 14);
		pnlReviewCustomer.add(lblReviewAddress);
		
		JLabel lblReviewReturnCustomer = new JLabel("Return Customer:");
		lblReviewReturnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewReturnCustomer.setBounds(10, 256, 117, 14);
		pnlReviewCustomer.add(lblReviewReturnCustomer);
		
		JLabel lblShowFirstName = new JLabel("");
		lblShowFirstName.setBackground(Color.WHITE);
		lblShowFirstName.setBounds(94, 130, 356, 14);
		pnlReviewCustomer.add(lblShowFirstName);
		
		JLabel lblShowLastName = new JLabel("");
		lblShowLastName.setBackground(Color.WHITE);
		lblShowLastName.setBounds(94, 158, 356, 14);
		pnlReviewCustomer.add(lblShowLastName);
		
		JLabel lblShowPhoneNumber = new JLabel("");
		lblShowPhoneNumber.setBackground(Color.WHITE);
		lblShowPhoneNumber.setBounds(117, 183, 333, 14);
		pnlReviewCustomer.add(lblShowPhoneNumber);
		
		JLabel lblShowEmail = new JLabel("");
		lblShowEmail.setBackground(Color.WHITE);
		lblShowEmail.setBounds(64, 206, 386, 14);
		pnlReviewCustomer.add(lblShowEmail);
		
		JLabel lblShowAddress = new JLabel("");
		lblShowAddress.setBackground(Color.WHITE);
		lblShowAddress.setBounds(74, 233, 376, 14);
		pnlReviewCustomer.add(lblShowAddress);
		
		JLabel lblShowReturnCustomer = new JLabel("");
		lblShowReturnCustomer.setBackground(Color.WHITE);
		lblShowReturnCustomer.setBounds(123, 258, 327, 14);
		pnlReviewCustomer.add(lblShowReturnCustomer);
		
		//gets data from database 
		JButton btnReviewCustomer = new JButton("Review Customer");
		btnReviewCustomer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int ID = Integer.parseInt(txtReviewCustomerID.getText());
				int returnID = 0;
				String first = null;
				String last = null;
				String phone = null;
				String address = null;
				String email = null;
				String returnCustomer = null; 
				try
				{
					returnID = OracleJDBC.readCustomerID(ID);
					first = OracleJDBC.readCustomerFirstName(ID);
					last = OracleJDBC.readCustomerLastName(ID);
					phone = OracleJDBC.readCustomerPhoneNumber(ID);
					address = OracleJDBC.readCustomerAddress(ID);
					email = OracleJDBC.readCustomerEmail(ID);
					returnCustomer = OracleJDBC.readReturnCustomer(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Customer First Name",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnID != 0) //checks if customer exists
				{
					lblShowFirstName.setText(first);
					lblShowLastName.setText(last);
					lblShowPhoneNumber.setText(phone);
					lblShowAddress.setText(address);
					lblShowEmail.setText(email);
					if(returnCustomer.equals("N"))
					{
						lblShowReturnCustomer.setText("No");
					}
					else
					{
						lblShowReturnCustomer.setText("Yes");
					};
				}
				else //customer does not exist
				{
					JOptionPane.showMessageDialog(null, "Customer with ID "+ID+" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
			}
		});
		btnReviewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReviewCustomer.setBounds(10, 65, 227, 54);
		pnlReviewCustomer.add(btnReviewCustomer);
		
		JButton btnReviewMainMenu = new JButton("Main Menu");
		btnReviewMainMenu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GuitarBuilderMainMenu.createMainMenu();
				frmCustomers.dispose();
			}
		});
		btnReviewMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReviewMainMenu.setBounds(251, 65, 227, 54);
		pnlReviewCustomer.add(btnReviewMainMenu);
		
		JPanel pnlDeleteCustomer = new JPanel();
		tabbedPane.addTab("Delete Customer", null, pnlDeleteCustomer, null);
		pnlDeleteCustomer.setLayout(null);
		
		JLabel lblDeleteCustomerID = new JLabel("Enter Customer ID To Delete");
		lblDeleteCustomerID.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeleteCustomerID.setBounds(10, 11, 468, 19);
		pnlDeleteCustomer.add(lblDeleteCustomerID);
		
		txtDeleteCustomerID = new JTextField();
		txtDeleteCustomerID.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeleteCustomerID.setColumns(10);
		txtDeleteCustomerID.setBounds(10, 33, 468, 20);
		pnlDeleteCustomer.add(txtDeleteCustomerID);
		
		JButton btnDeleteCustomer = new JButton("Delete Customer");
		btnDeleteCustomer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
							
				int ID = Integer.parseInt(txtDeleteCustomerID.getText());
				int returnID = 0;
				String first = null;
				String last = null;
				String phone = null;
				String address = null;
				String email = null;
				String returnCustomer = null; 
				try
				{
					returnID = OracleJDBC.readCustomerID(ID);
					first = OracleJDBC.readCustomerFirstName(ID);
					last = OracleJDBC.readCustomerLastName(ID);
					phone = OracleJDBC.readCustomerPhoneNumber(ID);
					address = OracleJDBC.readCustomerAddress(ID);
					email = OracleJDBC.readCustomerEmail(ID);
					returnCustomer = OracleJDBC.readReturnCustomer(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Delete Customer",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if (returnID == 0)
				{
					JOptionPane.showMessageDialog(null, "Customer with ID " + ID + " does not exist!",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
				}
				else
				{
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the following customer?"
							+ "\nID: " + returnID + "\nFirst Name: " + first + "\nLast Name: " + last
							+ "\nPhone Number: " + phone + "\nAddress: " + address + "\nEmail: "
							+ email + "\nReturn Customer: " + returnCustomer, "Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					
					if (choice == 0)
					{
						try
						{
							OracleJDBC.deleteCustomer(ID);
						} 
						catch (SQLException e1)
						{
							JOptionPane.showMessageDialog(null, "Couldn't Delete Customer", "Error", JOptionPane.ERROR_MESSAGE, null);
						}
						
						JOptionPane.showMessageDialog(null, "Customer Deleted", "Sucess", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else
					{
						return;
					}
				}
				
				
				
			}
		});
		btnDeleteCustomer.setBackground(UIManager.getColor("Button.background"));
		btnDeleteCustomer.setForeground(Color.RED);
		btnDeleteCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteCustomer.setBounds(10, 64, 226, 73);
		pnlDeleteCustomer.add(btnDeleteCustomer);
		
		JButton btnDeleteMainMenu = new JButton("Main Menu");
		btnDeleteMainMenu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GuitarBuilderMainMenu.createMainMenu();
				frmCustomers.dispose();
			}
		});
		btnDeleteMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteMainMenu.setBounds(252, 64, 226, 73);
		pnlDeleteCustomer.add(btnDeleteMainMenu);
	}
	
	private void clearForm()
	{
		txtUpdateID.setText("");
		txtUpdateFirstName.setText("");
		txtUpdateLastName.setText("");
		txtUpdatePhoneNumber.setText("");
		txtUpdateAddress.setText("");
		txtUpdateEmail.setText("");
		txtFirstName.setText("");
		txtCustomerID.setText("");
		txtLastName.setText("");
		txtPhoneNumber.setText("");
		txtEmail.setText("");
		txtAddress.setText("");
		
	}
}
