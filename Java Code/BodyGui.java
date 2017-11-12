package guitarApp;

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
	private final ButtonGroup btnGroupCarveTop = new ButtonGroup();
	private final ButtonGroup btnGroupHollowBody = new ButtonGroup();
	private JTextField txtUpdateBodyID;
	private JTextField txtReviewBodyID;
	private JTextField txtDeleteBodyID;
	private final ButtonGroup btnGroupUpdateCarveTop = new ButtonGroup();
	private final ButtonGroup btnGroupUpdateHollowBody = new ButtonGroup();

	/**
	 * Launch the application.
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
	 * Create the application.
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
		frmBody = new JFrame();
		frmBody.setResizable(false);
		frmBody.setTitle("Guitar Builder - Body");
		frmBody.setBounds(100, 100, 402, 311);
		frmBody.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBody.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmBody.setLocation(dim.width/2-frmBody.getSize().width/2, dim.height/2-frmBody.getSize().height/2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 396, 282);
		frmBody.getContentPane().add(tabbedPane);
		
		JPanel pnlCreateBody = new JPanel();
		tabbedPane.addTab("Create Body", null, pnlCreateBody, null);
		pnlCreateBody.setLayout(null);
		
		JLabel lblEnterBodyId = new JLabel("Enter Body ID:");
		lblEnterBodyId.setBounds(37, 14, 141, 14);
		pnlCreateBody.add(lblEnterBodyId);
		
		JLabel lblSelectBodyWood = new JLabel("Select Body Wood:");
		lblSelectBodyWood.setBounds(37, 39, 141, 14);
		pnlCreateBody.add(lblSelectBodyWood);
		
		JLabel lblSelectTopWood = new JLabel("Select Top Wood:");
		lblSelectTopWood.setBounds(37, 64, 141, 14);
		pnlCreateBody.add(lblSelectTopWood);
		
		JLabel lblSelectBodyShape = new JLabel("Select Body Shape:");
		lblSelectBodyShape.setBounds(37, 89, 141, 14);
		pnlCreateBody.add(lblSelectBodyShape);
		
		JLabel lblSelectCarvetopOption = new JLabel("Select Carvetop Option:");
		lblSelectCarvetopOption.setBounds(37, 114, 168, 14);
		pnlCreateBody.add(lblSelectCarvetopOption);
		
		JLabel lblSelectHollowBody = new JLabel("Select Hollow Body Option:");
		lblSelectHollowBody.setBounds(37, 139, 168, 14);
		pnlCreateBody.add(lblSelectHollowBody);
		
		txtBodyID = new JTextField();
		txtBodyID.setBounds(204, 11, 141, 20);
		pnlCreateBody.add(txtBodyID);
		txtBodyID.setColumns(10);
		
		JComboBox cmbBoxBodyWood = new JComboBox();
		cmbBoxBodyWood.setModel(new DefaultComboBoxModel(new String[] {"Mahogany", "Maple", "Cedar", "Ash", "Alder", "Basswood", "Korina", "Poplar", "Walnut"}));
		cmbBoxBodyWood.setBounds(204, 36, 141, 20);
		pnlCreateBody.add(cmbBoxBodyWood);
		
		JComboBox cmbBoxTopWood = new JComboBox();
		cmbBoxTopWood.setModel(new DefaultComboBoxModel(new String[] {"Buckeye", "Maple", "Ebony", "Manchinga", "Myrtle", "Sapele", "Cedar", "Zebra Wood", "None"}));
		cmbBoxTopWood.setBounds(204, 61, 141, 20);
		pnlCreateBody.add(cmbBoxTopWood);
		
		JComboBox cmbBoxShape = new JComboBox();
		cmbBoxShape.setModel(new DefaultComboBoxModel(new String[] {"Strat", "Tele", "LP", "Mockingbird", "Warlock", "SG", "Explorer", "V", "V-2", "Star", "Iceman", "Firebird", "Jaguar", "Mustang", "Jagstang"}));
		cmbBoxShape.setBounds(204, 86, 141, 20);
		pnlCreateBody.add(cmbBoxShape);
		
		JRadioButton rdbtnCarvetopYes = new JRadioButton("Yes");
		rdbtnCarvetopYes.setSelected(true);
		btnGroupCarveTop.add(rdbtnCarvetopYes);
		rdbtnCarvetopYes.setBounds(244, 112, 56, 18);
		pnlCreateBody.add(rdbtnCarvetopYes);
		
		JRadioButton rdbtnCarvetopNo = new JRadioButton("No");
		btnGroupCarveTop.add(rdbtnCarvetopNo);
		rdbtnCarvetopNo.setBounds(302, 112, 43, 18);
		pnlCreateBody.add(rdbtnCarvetopNo);
		
		JRadioButton rdbtnHollowBodyNo = new JRadioButton("No");
		btnGroupHollowBody.add(rdbtnHollowBodyNo);
		rdbtnHollowBodyNo.setBounds(302, 139, 43, 14);
		pnlCreateBody.add(rdbtnHollowBodyNo);
		
		JRadioButton rdbtnHollowBodyYes = new JRadioButton("Yes");
		rdbtnHollowBodyYes.setSelected(true);
		btnGroupHollowBody.add(rdbtnHollowBodyYes);
		rdbtnHollowBodyYes.setBounds(243, 139, 57, 14);
		pnlCreateBody.add(rdbtnHollowBodyYes);
		
		JButton btnCreateBody = new JButton("Create Body");
		btnCreateBody.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtBodyID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				String bodyWood = (String)cmbBoxBodyWood.getSelectedItem();
				String topWood = (String)cmbBoxTopWood.getSelectedItem();
				String shape = (String)cmbBoxShape.getSelectedItem();
				char carveTop;
				char hollowBody;
				
				if (rdbtnCarvetopYes.isSelected())
					carveTop = 'Y';
				else
					carveTop = 'N';
				
				if (rdbtnHollowBodyYes.isSelected())
					hollowBody = 'Y';
				else
					hollowBody = 'N';				
				
				
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nBody Wood: " + bodyWood + "\nTop Wood: " + topWood
						+ "\nShape: " + shape + "\nCarve Top: " + carveTop + "\nHollow Body: "
						+ hollowBody, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0)
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
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not create Body",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				
				
			}
		});
		btnCreateBody.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateBody.setBounds(10, 164, 168, 69);
		pnlCreateBody.add(btnCreateBody);
		
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
		btnProductMenu.setBounds(203, 164, 168, 69);
		pnlCreateBody.add(btnProductMenu);
		
		JPanel pnlUpdateBody = new JPanel();
		tabbedPane.addTab("Update Body", null, pnlUpdateBody, null);
		pnlUpdateBody.setLayout(null);
		
		JLabel lblUpdateBodyWood = new JLabel("Update Body Wood:");
		lblUpdateBodyWood.setBounds(37, 39, 138, 14);
		pnlUpdateBody.add(lblUpdateBodyWood);
		
		JLabel lblUpdateBodyID = new JLabel("Enter Body ID For Update:");
		lblUpdateBodyID.setBounds(37, 14, 138, 14);
		pnlUpdateBody.add(lblUpdateBodyID);
		
		txtUpdateBodyID = new JTextField();
		txtUpdateBodyID.setColumns(10);
		txtUpdateBodyID.setBounds(203, 11, 72, 20);
		pnlUpdateBody.add(txtUpdateBodyID);
		
		JComboBox cmbBoxUpdateBodyWood = new JComboBox();
		cmbBoxUpdateBodyWood.setModel(new DefaultComboBoxModel(new String[] {"Mahogany", "Maple", "Cedar", "Ash", "Alder", "Basswood", "Korina", "Poplar", "Walnut"}));
		cmbBoxUpdateBodyWood.setBounds(204, 39, 154, 20);
		pnlUpdateBody.add(cmbBoxUpdateBodyWood);
		
		JComboBox cmbBoxUpdateTopWood = new JComboBox();
		cmbBoxUpdateTopWood.setModel(new DefaultComboBoxModel(new String[] {"Buckeye", "Maple", "Ebony", "Manchinga", "Myrtle", "Sapele", "Cedar", "Zebra Wood", "None"}));
		cmbBoxUpdateTopWood.setBounds(204, 64, 154, 20);
		pnlUpdateBody.add(cmbBoxUpdateTopWood);
		
		JComboBox cmbBoxUpdateShape = new JComboBox();
		cmbBoxUpdateShape.setModel(new DefaultComboBoxModel(new String[] {"Strat", "Tele", "LP", "Mockingbird", "Warlock", "SG", "Explorer", "V", "V-2", "Star", "Iceman", "Firebird", "Jaguar", "Mustang", "Jagstang"}));
		cmbBoxUpdateShape.setBounds(204, 89, 154, 20);
		pnlUpdateBody.add(cmbBoxUpdateShape);
		
		JLabel lblUpdateShape = new JLabel("Update Body Shape:");
		lblUpdateShape.setBounds(37, 89, 138, 14);
		pnlUpdateBody.add(lblUpdateShape);
		
		JLabel lblUpdateTopWood = new JLabel("Update Top Wood:");
		lblUpdateTopWood.setBounds(37, 64, 138, 14);
		pnlUpdateBody.add(lblUpdateTopWood);
		
		JLabel lblUpdateCarvetop = new JLabel("Update Carvetop Option:");
		lblUpdateCarvetop.setBounds(37, 114, 168, 14);
		pnlUpdateBody.add(lblUpdateCarvetop);
		
		JRadioButton rdbtnUpdateCarvetopYes = new JRadioButton("Yes");
		btnGroupUpdateCarveTop.add(rdbtnUpdateCarvetopYes);
		rdbtnUpdateCarvetopYes.setSelected(true);
		rdbtnUpdateCarvetopYes.setBounds(226, 114, 63, 15);
		pnlUpdateBody.add(rdbtnUpdateCarvetopYes);
		
		JRadioButton rdbtnUpdateCarvetopNo = new JRadioButton("No");
		btnGroupUpdateCarveTop.add(rdbtnUpdateCarvetopNo);
		rdbtnUpdateCarvetopNo.setBounds(315, 116, 43, 15);
		pnlUpdateBody.add(rdbtnUpdateCarvetopNo);
		
		JRadioButton rdbtnUpdateHollowBodyNo = new JRadioButton("No");
		btnGroupUpdateHollowBody.add(rdbtnUpdateHollowBodyNo);
		rdbtnUpdateHollowBodyNo.setBounds(315, 139, 43, 14);
		pnlUpdateBody.add(rdbtnUpdateHollowBodyNo);
		
		JRadioButton rdbtnUpdateHollowBodyYes = new JRadioButton("Yes");
		btnGroupUpdateHollowBody.add(rdbtnUpdateHollowBodyYes);
		rdbtnUpdateHollowBodyYes.setSelected(true);
		rdbtnUpdateHollowBodyYes.setBounds(226, 139, 63, 14);
		pnlUpdateBody.add(rdbtnUpdateHollowBodyYes);
		
		JLabel lblUpdateHollowBody = new JLabel("Update Hollow Body Option:");
		lblUpdateHollowBody.setBounds(37, 139, 168, 14);
		pnlUpdateBody.add(lblUpdateHollowBody);
		
		JButton btnUpdateBody = new JButton("Update Body");
		btnUpdateBody.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnUpdateBody.setEnabled(false);
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtUpdateBodyID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				String bodyWood = (String)cmbBoxUpdateBodyWood.getSelectedItem();
				String topWood = (String)cmbBoxUpdateTopWood.getSelectedItem();
				String shape = (String)cmbBoxUpdateShape.getSelectedItem();
				char carveTop;
				char hollowBody;
				
				if (rdbtnUpdateCarvetopYes.isSelected())
					carveTop = 'Y';
				else
					carveTop = 'N';
				
				if (rdbtnUpdateHollowBodyYes.isSelected())
					hollowBody = 'Y';
				else
					hollowBody = 'N';				
				
				
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nBody Wood: " + bodyWood + "\nTop Wood: " + topWood
						+ "\nShape: " + shape + "\nCarve Top: " + carveTop + "\nHollow Body: "
						+ hollowBody, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0)
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
		btnUpdateBody.setBounds(10, 164, 168, 69);
		btnUpdateBody.setEnabled(false);
		pnlUpdateBody.add(btnUpdateBody);
		
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
		btnUpdateProductMenu.setBounds(203, 164, 168, 69);
		pnlUpdateBody.add(btnUpdateProductMenu);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				{
					int ID = 0;
					try 
					{
						ID = Integer.parseInt(txtUpdateBodyID.getText());
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
		btnEnter.setBounds(285, 10, 73, 23);
		pnlUpdateBody.add(btnEnter);
		
		JPanel pnlReviewBody = new JPanel();
		tabbedPane.addTab("Review Body", null, pnlReviewBody, null);
		pnlReviewBody.setLayout(null);
		
		JLabel lblReviewBodyID = new JLabel("Enter Body ID For Info:");
		lblReviewBodyID.setBounds(10, 14, 128, 14);
		pnlReviewBody.add(lblReviewBodyID);
		
		JLabel lblBodyWood = new JLabel("Body Wood:");
		lblBodyWood.setBounds(10, 119, 105, 14);
		pnlReviewBody.add(lblBodyWood);
		
		JLabel lblTopWood = new JLabel("Top Wood:");
		lblTopWood.setBounds(10, 144, 105, 14);
		pnlReviewBody.add(lblTopWood);
		
		JLabel lblBodyShape = new JLabel("Body Shape:");
		lblBodyShape.setBounds(10, 169, 105, 14);
		pnlReviewBody.add(lblBodyShape);
		
		JLabel lblCarvetopOption = new JLabel("Carvetop Option:");
		lblCarvetopOption.setBounds(10, 194, 105, 14);
		pnlReviewBody.add(lblCarvetopOption);
		
		JLabel lblHollowBodyOption = new JLabel("Hollow Body Option:");
		lblHollowBodyOption.setBounds(10, 219, 128, 14);
		pnlReviewBody.add(lblHollowBodyOption);
		
		txtReviewBodyID = new JTextField();
		txtReviewBodyID.setColumns(10);
		txtReviewBodyID.setBounds(214, 11, 157, 20);
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
		btnGetInfo.setBounds(10, 39, 171, 69);
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
		btnReviewProductMenu.setBounds(200, 39, 171, 69);
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
		btnDeleteBody.setBounds(10, 39, 171, 69);
		pnlDeleteBody.add(btnDeleteBody);
		
		JLabel lblDeleteID = new JLabel("Enter Body ID For Info:");
		lblDeleteID.setBounds(10, 14, 128, 14);
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
		btnDeleteProductMenu.setBounds(200, 39, 171, 69);
		pnlDeleteBody.add(btnDeleteProductMenu);
		
		txtDeleteBodyID = new JTextField();
		txtDeleteBodyID.setColumns(10);
		txtDeleteBodyID.setBounds(200, 11, 171, 20);
		pnlDeleteBody.add(txtDeleteBodyID);
	}
}
