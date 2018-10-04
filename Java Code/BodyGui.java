package guitarApp;
/**
 * @author Dylan Oszust
 * 
 * User interface to create a body object
 * 
 */
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BodyGui
{

	private JFrame frmBody;
	private JTextField txtBodyID;
	private final ButtonGroup btnGroupCarveTop = new ButtonGroup(); //holds yes/no buttons for carve top option
	private final ButtonGroup btnGroupHollowBody = new ButtonGroup(); // holds yes/no buttons for hollow body option
	private JTextField txtUpdateBodyID; //enter ID for body to update
	private JTextField txtReviewBodyID; //enter ID for body to review
	private JTextField txtDeleteBodyID; //enter ID for body to delete
	private final ButtonGroup btnGroupUpdateCarveTop = new ButtonGroup(); //holds yes/no buttons for updating carve top
	private final ButtonGroup btnGroupUpdateHollowBody = new ButtonGroup(); // holds yes/no buttons for updating hollow body

	/**
	 * Launch the window.
	 */
	public static void createBodyGUI()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					BodyGui window = new BodyGui();
					window.frmBody.setVisible(true);
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
	public BodyGui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		//initialize body wood options
		String bodyWood[] = new String[] {"Mahogany", "Maple", "Cedar", "Ash", "Alder", "Basswood", "Korina", "Poplar", "Walnut"};
		DefaultComboBoxModel bodyWoodOptions = new DefaultComboBoxModel(bodyWood);
		
		//initialize top wood options
		String topWood[] = new String[] {"Buckeye", "Maple", "Ebony", "Manchinga", "Myrtle", "Sapele", "Cedar", "Zebra Wood", "None"};
		DefaultComboBoxModel topWoodOptions = new DefaultComboBoxModel(topWood);
		
		//initialize shape options
		String shape[] = new String[] {"Strat", "Tele", "LP", "Mockingbird", "Warlock", "SG", "Explorer", "V", "V-2", "Star", "Iceman", "Firebird", "Jaguar", "Mustang", "Jagstang"};
		DefaultComboBoxModel shapeOptions = new DefaultComboBoxModel(shape);
		
		frmBody = new JFrame();
		frmBody.setResizable(false); //does not allow the user to resize
		frmBody.setTitle("Guitar Builder - Body"); //sets title
		frmBody.setBounds(100, 100, 406, 324); //set size
		frmBody.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes on clicking the close button
		frmBody.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmBody.setLocation(dim.width/2-frmBody.getSize().width/2, dim.height/2-frmBody.getSize().height/2); //centers the app in the middle of the screen
		
		//initialize and add tabbed panes
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 404, 287);
		frmBody.getContentPane().add(tabbedPane);
		
		//Create body panel
		JPanel pnlCreateBody = new JPanel();
		tabbedPane.addTab("Create Body", null, pnlCreateBody, null);
		pnlCreateBody.setLayout(null);
		
		//Create body labels
		JLabel lblEnterBodyId = new JLabel("Enter Body ID:");
		lblEnterBodyId.setBounds(22, 12, 105, 20);
		pnlCreateBody.add(lblEnterBodyId);
		
		JLabel lblSelectBodyWood = new JLabel("Select Body Wood:");
		lblSelectBodyWood.setBounds(22, 40, 133, 20);
		pnlCreateBody.add(lblSelectBodyWood);
		
		JLabel lblSelectTopWood = new JLabel("Select Top Wood:");
		lblSelectTopWood.setBounds(22, 68, 126, 20);
		pnlCreateBody.add(lblSelectTopWood);
		
		JLabel lblSelectBodyShape = new JLabel("Select Body Shape:");
		lblSelectBodyShape.setBounds(22, 96, 135, 20);
		pnlCreateBody.add(lblSelectBodyShape);
		
		JLabel lblSelectCarvetopOption = new JLabel("Select Carvetop Option:");
		lblSelectCarvetopOption.setBounds(22, 124, 168, 20);
		pnlCreateBody.add(lblSelectCarvetopOption);
		
		JLabel lblSelectHollowBody = new JLabel("Select Hollow Body Option:");
		lblSelectHollowBody.setBounds(22, 152, 194, 20);
		pnlCreateBody.add(lblSelectHollowBody);
		
		//enter body ID
		txtBodyID = new JTextField();
		txtBodyID.setBounds(231, 12, 141, 20);
		pnlCreateBody.add(txtBodyID);
		txtBodyID.setColumns(10);
		
		//ALL COMBOBOXES ARE USING RAW TYPE JCOMBO BOX FOR WINDOWBUILDER, WHICH DOES NOT COMPILE GENERIC TYPE 
		
		//Select body wood combo box
		JComboBox cmbBoxBodyWood = new JComboBox();
		cmbBoxBodyWood.setModel(bodyWoodOptions);
		cmbBoxBodyWood.setBounds(231, 37, 141, 26);
		pnlCreateBody.add(cmbBoxBodyWood);
		
		//Select top wood combo box
		JComboBox cmbBoxTopWood = new JComboBox();
		cmbBoxTopWood.setModel(topWoodOptions);
		cmbBoxTopWood.setBounds(231, 65, 141, 26);
		pnlCreateBody.add(cmbBoxTopWood);
		
		//Select body shape combo box
		JComboBox cmbBoxShape = new JComboBox();
		cmbBoxShape.setModel(shapeOptions);
		cmbBoxShape.setBounds(231, 93, 141, 26);
		pnlCreateBody.add(cmbBoxShape);
		
		//Select carve top option yes
		JRadioButton rdbtnCarvetopYes = new JRadioButton("Yes");
		rdbtnCarvetopYes.setSelected(true);
		btnGroupCarveTop.add(rdbtnCarvetopYes);
		rdbtnCarvetopYes.setBounds(239, 120, 57, 29);
		pnlCreateBody.add(rdbtnCarvetopYes);
		
		//Select carvetop option no
		JRadioButton rdbtnCarvetopNo = new JRadioButton("No");
		btnGroupCarveTop.add(rdbtnCarvetopNo);
		rdbtnCarvetopNo.setBounds(317, 120, 53, 29);
		pnlCreateBody.add(rdbtnCarvetopNo);
		
		//Select hollow body option yes
		JRadioButton rdbtnHollowBodyYes = new JRadioButton("Yes");
		rdbtnHollowBodyYes.setSelected(true);
		btnGroupHollowBody.add(rdbtnHollowBodyYes);
		rdbtnHollowBodyYes.setBounds(239, 148, 57, 29);
		pnlCreateBody.add(rdbtnHollowBodyYes);
		
		//Select hollow body option no
		JRadioButton rdbtnHollowBodyNo = new JRadioButton("No");
		btnGroupHollowBody.add(rdbtnHollowBodyNo);
		rdbtnHollowBodyNo.setBounds(317, 148, 53, 29);
		pnlCreateBody.add(rdbtnHollowBodyNo);
		
		
		//Create Body Button
		JButton btnCreateBody = new JButton("Create Body");
		btnCreateBody.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;// ID starts as 0
				try 
				{
					ID = Integer.parseInt(txtBodyID.getText()); //tries to parse ID to int
				}
				catch(NumberFormatException e1) //Triggers if user enters anything other than an int
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				//Retrieve user input from form
				String bodyWood = (String)cmbBoxBodyWood.getSelectedItem();
				String topWood = (String)cmbBoxTopWood.getSelectedItem();
				String shape = (String)cmbBoxShape.getSelectedItem();
				char carveTop;
				char hollowBody;
				
				//Creates values based on user input that are suitable for database entry
				if (rdbtnCarvetopYes.isSelected())
					carveTop = 'Y';
				else
					carveTop = 'N';
				
				if (rdbtnHollowBodyYes.isSelected())
					hollowBody = 'Y';
				else
					hollowBody = 'N';				
				
				//Confirmation dialogue
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nBody Wood: " + bodyWood + "\nTop Wood: " + topWood
						+ "\nShape: " + shape + "\nCarve Top: " + carveTop + "\nHollow Body: "
						+ hollowBody, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0) //User confirms entry
				{
					
					Body create = new Body(ID, bodyWood , topWood, shape, carveTop, hollowBody); //creates body object
					
					try
					{
						OracleJDBC.writeBody(create); //passes to method that writes body to database
					} 
					catch (SQLException e1)
					{
						
									
						if (e1.getErrorCode() == 00001) //sql error for PK constraint violation
							JOptionPane.showMessageDialog(null, "Body ID already in use",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else if (e1.getErrorCode() == 1438) //sql error for body ID too long
							JOptionPane.showMessageDialog(null, "Body ID to long, must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Body Created",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null); //Alerts user that body was created and saved to DB
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not create Body",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				
				
			}
		});
		btnCreateBody.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateBody.setBounds(21, 180, 168, 69);
		pnlCreateBody.add(btnCreateBody);
		
		//Button to return user to menu
		JButton btnProductMenu = new JButton("Product Menu");
		btnProductMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Builder.createBuilderGui();
				frmBody.dispose();
			}
		});
		btnProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProductMenu.setBounds(210, 180, 168, 69);
		pnlCreateBody.add(btnProductMenu);
		
		
		//Update body panel
		JPanel pnlUpdateBody = new JPanel();
		tabbedPane.addTab("Update Body", null, pnlUpdateBody, null);
		pnlUpdateBody.setLayout(null);
		
		
		//Update body labels
		JLabel lblUpdateBodyWood = new JLabel("Update Body Wood:");
		lblUpdateBodyWood.setBounds(15, 36, 142, 20);
		pnlUpdateBody.add(lblUpdateBodyWood);
		
		JLabel lblUpdateBodyID = new JLabel("Enter Body ID For Update:");
		lblUpdateBodyID.setBounds(15, 8, 188, 20);
		pnlUpdateBody.add(lblUpdateBodyID);
		
		JLabel lblUpdateShape = new JLabel("Update Body Shape:");
		lblUpdateShape.setBounds(15, 92, 144, 20);
		pnlUpdateBody.add(lblUpdateShape);
		
		JLabel lblUpdateTopWood = new JLabel("Update Top Wood:");
		lblUpdateTopWood.setBounds(15, 64, 135, 20);
		pnlUpdateBody.add(lblUpdateTopWood);
		
		JLabel lblUpdateCarvetop = new JLabel("Update Carvetop Option:");
		lblUpdateCarvetop.setBounds(15, 120, 177, 20);
		pnlUpdateBody.add(lblUpdateCarvetop);
		
		JLabel lblUpdateHollowBody = new JLabel("Update Hollow Body Option:");
		lblUpdateHollowBody.setBounds(15, 148, 203, 20);
		pnlUpdateBody.add(lblUpdateHollowBody);
		
		//Takes ID to select body to update
		txtUpdateBodyID = new JTextField();
		txtUpdateBodyID.setColumns(10);
		txtUpdateBodyID.setBounds(228, 7, 72, 23);
		pnlUpdateBody.add(txtUpdateBodyID);
		
		//Select body wood for update
		JComboBox cmbBoxUpdateBodyWood = new JComboBox();
		cmbBoxUpdateBodyWood.setModel(bodyWoodOptions);
		cmbBoxUpdateBodyWood.setBounds(228, 33, 154, 26);
		pnlUpdateBody.add(cmbBoxUpdateBodyWood);
		
		//select top wood for update
		JComboBox cmbBoxUpdateTopWood = new JComboBox();
		cmbBoxUpdateTopWood.setModel(topWoodOptions);
		cmbBoxUpdateTopWood.setBounds(228, 61, 154, 26);
		pnlUpdateBody.add(cmbBoxUpdateTopWood);
		
		//select shape for update
		JComboBox cmbBoxUpdateShape = new JComboBox();
		cmbBoxUpdateShape.setModel(shapeOptions);
		cmbBoxUpdateShape.setBounds(228, 89, 154, 26);
		pnlUpdateBody.add(cmbBoxUpdateShape);
			
		//Select carve top for update
		JRadioButton rdbtnUpdateCarvetopYes = new JRadioButton("Yes");
		btnGroupUpdateCarveTop.add(rdbtnUpdateCarvetopYes);
		rdbtnUpdateCarvetopYes.setSelected(true);
		rdbtnUpdateCarvetopYes.setBounds(250, 116, 57, 29);
		pnlUpdateBody.add(rdbtnUpdateCarvetopYes);
		
		JRadioButton rdbtnUpdateCarvetopNo = new JRadioButton("No");
		btnGroupUpdateCarveTop.add(rdbtnUpdateCarvetopNo);
		rdbtnUpdateCarvetopNo.setBounds(329, 116, 53, 29);
		pnlUpdateBody.add(rdbtnUpdateCarvetopNo);
		
		//Select hollow body for update
		JRadioButton rdbtnUpdateHollowBodyNo = new JRadioButton("No");
		btnGroupUpdateHollowBody.add(rdbtnUpdateHollowBodyNo);
		rdbtnUpdateHollowBodyNo.setBounds(329, 144, 53, 29);
		pnlUpdateBody.add(rdbtnUpdateHollowBodyNo);
		
		JRadioButton rdbtnUpdateHollowBodyYes = new JRadioButton("Yes");
		btnGroupUpdateHollowBody.add(rdbtnUpdateHollowBodyYes);
		rdbtnUpdateHollowBodyYes.setSelected(true);
		rdbtnUpdateHollowBodyYes.setBounds(250, 144, 57, 29);
		pnlUpdateBody.add(rdbtnUpdateHollowBodyYes);
		
		//Updates the body in the database
		JButton btnUpdateBody = new JButton("Update Body");
		btnUpdateBody.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnUpdateBody.setEnabled(false);
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtUpdateBodyID.getText()); //tries to parse ID to int
				}
				catch(NumberFormatException e1) //User entered something other than an int
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				//Retrieves user inputs
				String bodyWood = (String)cmbBoxUpdateBodyWood.getSelectedItem();
				String topWood = (String)cmbBoxUpdateTopWood.getSelectedItem();
				String shape = (String)cmbBoxUpdateShape.getSelectedItem();
				char carveTop;
				char hollowBody;
				
				//Translates selections to DB compatible input
				if (rdbtnUpdateCarvetopYes.isSelected())
					carveTop = 'Y';
				else
					carveTop = 'N';
				
				if (rdbtnUpdateHollowBodyYes.isSelected())
					hollowBody = 'Y';
				else
					hollowBody = 'N';				
				
				//Conformation dialogue
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nBody Wood: " + bodyWood + "\nTop Wood: " + topWood
						+ "\nShape: " + shape + "\nCarve Top: " + carveTop + "\nHollow Body: "
						+ hollowBody, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0)//if confirmed input
				{
					
					Body update = new Body(ID, bodyWood , topWood, shape, carveTop, hollowBody); //creates body object
					
					try
					{
						OracleJDBC.updateBody(update); //passes to method that writes body to database
					} 
					catch (SQLException e1)
					{
						
									
						if (e1.getErrorCode() == 1438) //sql error for body ID too long
							JOptionPane.showMessageDialog(null, "Body ID to long, must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Body Updated",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not Update Body",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				
				
				
					
			}
		});
		btnUpdateBody.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateBody.setBounds(21, 179, 168, 69);
		btnUpdateBody.setEnabled(false);
		pnlUpdateBody.add(btnUpdateBody);
		
		//returns user to previous menu
		JButton btnUpdateProductMenu = new JButton("Product Menu");
		btnUpdateProductMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Builder.createBuilderGui();
				frmBody.dispose();
			}
		});
		btnUpdateProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateProductMenu.setBounds(210, 179, 168, 69);
		pnlUpdateBody.add(btnUpdateProductMenu);
		
		//Gets data from database and loads form with current options
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				{
					int ID = 0;
					try 
					{
						ID = Integer.parseInt(txtUpdateBodyID.getText()); //tries to parse ID as int
					}
					catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
								"Error", JOptionPane.ERROR_MESSAGE, null);
						return;
					}
					
					int returnID = 0;
					String bodyWood = null;
					String topWood = null;
					String shape = null;
					String carveTop = null;
					String hollowBody = null;
					
					try
					{
						returnID = OracleJDBC.readBodyID(ID);
						bodyWood = OracleJDBC.readBodyWood(ID);
						topWood = OracleJDBC.readTopWood(ID);
						shape = OracleJDBC.readShape(ID);
						carveTop = OracleJDBC.readCarveTop(ID);
						hollowBody = OracleJDBC.readHollowBody(ID);
						
					} 
					catch (SQLException e1)
					{
						JOptionPane.showMessageDialog(null, "Could Not Retrieve Body Info",
	                            "Error", JOptionPane.ERROR_MESSAGE, null);
						e1.printStackTrace();
					}		
					
					
					if(returnID != 0) //checks if body exists
					{
					
						cmbBoxUpdateBodyWood.setSelectedItem(bodyWood);
						cmbBoxUpdateTopWood.setSelectedItem(topWood);
						cmbBoxUpdateShape.setSelectedItem(shape);
						
						if (carveTop.equals("N"))
						{
							rdbtnUpdateCarvetopNo.setSelected(true);
						}
						else
						{
							rdbtnUpdateCarvetopYes.setSelected(true);
						}
						
						if (hollowBody.equals("N"))
						{
							rdbtnUpdateHollowBodyNo.setSelected(true);
						}
						else
						{
							rdbtnUpdateHollowBodyYes.setSelected(true);
						}
						
						btnUpdateBody.setEnabled(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Could Not Retrieve Body Info, Body ID " + ID +" does not exist",
	                            "Error", JOptionPane.ERROR_MESSAGE, null);
						
						return;
					}
				}
			}
		});
		btnEnter.setBounds(309, 7, 73, 23);
		pnlUpdateBody.add(btnEnter);
		
		JPanel pnlReviewBody = new JPanel();
		tabbedPane.addTab("Review Body", null, pnlReviewBody, null);
		pnlReviewBody.setLayout(null);
		
		JLabel lblReviewBodyID = new JLabel("Enter Body ID For Info:");
		lblReviewBodyID.setBounds(10, 8, 167, 20);
		pnlReviewBody.add(lblReviewBodyID);
		
		JLabel lblBodyWood = new JLabel("Body Wood:");
		lblBodyWood.setBounds(10, 113, 87, 20);
		pnlReviewBody.add(lblBodyWood);
		
		JLabel lblTopWood = new JLabel("Top Wood:");
		lblTopWood.setBounds(10, 141, 80, 20);
		pnlReviewBody.add(lblTopWood);
		
		JLabel lblBodyShape = new JLabel("Body Shape:");
		lblBodyShape.setBounds(10, 169, 89, 20);
		pnlReviewBody.add(lblBodyShape);
		
		JLabel lblCarvetopOption = new JLabel("Carvetop Option:");
		lblCarvetopOption.setBounds(10, 197, 122, 20);
		pnlReviewBody.add(lblCarvetopOption);
		
		JLabel lblHollowBodyOption = new JLabel("Hollow Body Option:");
		lblHollowBodyOption.setBounds(10, 225, 148, 20);
		pnlReviewBody.add(lblHollowBodyOption);
		
		txtReviewBodyID = new JTextField();
		txtReviewBodyID.setColumns(10);
		txtReviewBodyID.setBounds(209, 8, 171, 20);
		pnlReviewBody.add(txtReviewBodyID);
		
		JLabel lblShowBodyWood = new JLabel("");
		lblShowBodyWood.setBounds(210, 119, 161, 14);
		pnlReviewBody.add(lblShowBodyWood);
		
		JLabel lblShowTopWood = new JLabel("");
		lblShowTopWood.setBounds(214, 144, 157, 14);
		pnlReviewBody.add(lblShowTopWood);
		
		JLabel lblShowShape = new JLabel("");
		lblShowShape.setBounds(214, 169, 157, 14);
		pnlReviewBody.add(lblShowShape);
		
		JLabel lblShowCarvetopOption = new JLabel("");
		lblShowCarvetopOption.setBounds(214, 194, 157, 14);
		pnlReviewBody.add(lblShowCarvetopOption);
		
		JLabel lblShowHollowBody = new JLabel("");
		lblShowHollowBody.setBounds(214, 219, 157, 14);
		pnlReviewBody.add(lblShowHollowBody);
		
		JButton btnGetInfo = new JButton("Get Info");
		btnGetInfo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				{
					int ID = 0;
					try 
					{
						ID = Integer.parseInt(txtReviewBodyID.getText());
					}
					catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
								"Error", JOptionPane.ERROR_MESSAGE, null);
						return;
					}
					
					int returnID = 0;
					String bodyWood = null;
					String topWood = null;
					String shape = null;
					String carveTop = null;
					String hollowBody = null;
					
					try
					{
						returnID = OracleJDBC.readBodyID(ID);
						bodyWood = OracleJDBC.readBodyWood(ID);
						topWood = OracleJDBC.readTopWood(ID);
						shape = OracleJDBC.readShape(ID);
						carveTop = OracleJDBC.readCarveTop(ID);
						hollowBody = OracleJDBC.readHollowBody(ID);
						
					} 
					catch (SQLException e1)
					{
						JOptionPane.showMessageDialog(null, "Could Not Retrieve Body Info",
	                            "Error", JOptionPane.ERROR_MESSAGE, null);
						e1.printStackTrace();
					}		
					
					
					if(returnID != 0) //checks if body exists
					{
					
						lblShowBodyWood.setText(bodyWood);
						lblShowTopWood.setText(topWood);
						lblShowShape.setText(shape);
						
						
						if (carveTop.equals("Y"))
						{
							lblShowCarvetopOption.setText("Yes");
						}
						else
						{
							lblShowCarvetopOption.setText("No");
						}
						
						if (hollowBody.equals("Y"))
						{
							lblShowHollowBody.setText("Yes");
						}
						else
						{
							lblShowHollowBody.setText("No");
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Could Not Retrieve Body Info, Body ID " + ID +" does not exist",
	                            "Error", JOptionPane.ERROR_MESSAGE, null);
						
						return;
					}
				}
			}
		});
		btnGetInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGetInfo.setBounds(10, 36, 171, 69);
		pnlReviewBody.add(btnGetInfo);
		
		JButton btnReviewProductMenu = new JButton("Product Menu");
		btnReviewProductMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmBody.dispose();
			}
		});
		btnReviewProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReviewProductMenu.setBounds(209, 36, 171, 69);
		pnlReviewBody.add(btnReviewProductMenu);
		
		
		
		JPanel pnlDeleteBody = new JPanel();
		tabbedPane.addTab("Delete Body", null, pnlDeleteBody, null);
		pnlDeleteBody.setLayout(null);
		
		JButton btnDeleteBody = new JButton("Delete Body");
		btnDeleteBody.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtDeleteBodyID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				int returnID = 0;
				String bodyWood = null;
				String topWood = null;
				String shape = null;
				String carveTop = null;
				String hollowBody = null;
				
				try
				{
					returnID = OracleJDBC.readBodyID(ID);
					bodyWood = OracleJDBC.readBodyWood(ID);
					topWood = OracleJDBC.readTopWood(ID);
					shape = OracleJDBC.readShape(ID);
					carveTop = OracleJDBC.readCarveTop(ID);
					hollowBody = OracleJDBC.readHollowBody(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Body Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}		
				
				
				if (returnID == 0)
				{
					JOptionPane.showMessageDialog(null, "Body with ID " + ID + " does not exist!",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
				}
				else
				{
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the following Body?"
							+ "\nID: " + ID + "\nBody Wood: " + bodyWood + "\nTop Wood: " + topWood
							+ "\nShape: " + shape + "\nCarve Top: " + carveTop + "\nHollow Body: "
							+ hollowBody, "Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					
					if (choice == 0)
					{
						try
						{
							OracleJDBC.deleteBody(ID);
						} 
						catch (SQLException e1)
						{
							JOptionPane.showMessageDialog(null, "Couldn't Delete Body", "Error", JOptionPane.ERROR_MESSAGE, null);
						}
						
						JOptionPane.showMessageDialog(null, "Body Deleted", "Sucess", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else
					{
						return;
					}
				}
			}
		});
		btnDeleteBody.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteBody.setBounds(19, 39, 171, 69);
		pnlDeleteBody.add(btnDeleteBody);
		
		JLabel lblDeleteID = new JLabel("Enter Body ID For Info:");
		lblDeleteID.setBounds(20, 14, 167, 20);
		pnlDeleteBody.add(lblDeleteID);
		
		JButton btnDeleteProductMenu = new JButton("Product Menu");
		btnDeleteProductMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Builder.createBuilderGui();
				frmBody.dispose();
			}
		});
		btnDeleteProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteProductMenu.setBounds(209, 39, 171, 69);
		pnlDeleteBody.add(btnDeleteProductMenu);
		
		txtDeleteBodyID = new JTextField();
		txtDeleteBodyID.setColumns(10);
		txtDeleteBodyID.setBounds(207, 14, 171, 20);
		pnlDeleteBody.add(txtDeleteBodyID);
	}
}
