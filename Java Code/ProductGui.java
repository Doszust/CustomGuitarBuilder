/**
 * @author Dylan Oszust
 *  3/12/2017
 *  This class creates the Graphical User Interface that allows management of the product objects.
 */

package guitarApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class ProductGui
{

	private JFrame frmProductBuilder;
	private JTextField txtProductID;
	private JTextField txtNeckID;
	private JTextField txtHardwareID;
	private JTextField txtCosmeticID;
	private JTextField txtCustomerID;
	private final ButtonGroup btnGroupPaidFor = new ButtonGroup();
	private JTextField txtUpdateProductID;
	private JTextField txtUpdateNeckID;
	private JTextField txtUpdateBodyID;
	private JTextField txtUpdateHardwareID;
	private JTextField txtUpdateCosmeticID;
	private JTextField txtUpdateCustomerID;
	private JTextField txtReviewProductID;
	private JTextField txtDeleteProductID;
	private final ButtonGroup btnGroupUpdatePaidFor = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void createProductGui()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ProductGui window = new ProductGui();
					window.frmProductBuilder.setVisible(true);
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
	public ProductGui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmProductBuilder = new JFrame();
		frmProductBuilder.setTitle("Product Builder");
		frmProductBuilder.setBounds(100, 100, 474, 331);
		frmProductBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProductBuilder.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmProductBuilder.setLocation(dim.width/2-frmProductBuilder.getSize().width/2, dim.height/2-frmProductBuilder.getSize().height/2); //launches window in center of the screen.

		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 458, 292);
		frmProductBuilder.getContentPane().add(tabbedPane);
		
		JPanel pnlCreateProduct = new JPanel();
		tabbedPane.addTab("Create Product", null, pnlCreateProduct, null);
		pnlCreateProduct.setLayout(null);
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductId.setBounds(38, 11, 94, 14);
		pnlCreateProduct.add(lblProductId);
		
		JLabel lblNeckId = new JLabel("Neck ID:");
		lblNeckId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNeckId.setBounds(38, 36, 94, 14);
		pnlCreateProduct.add(lblNeckId);
		
		JLabel lblBodyId = new JLabel("Body ID:");
		lblBodyId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBodyId.setBounds(38, 61, 94, 14);
		pnlCreateProduct.add(lblBodyId);
		
		JLabel lblHardwareId = new JLabel("Hardware ID:");
		lblHardwareId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHardwareId.setBounds(38, 86, 94, 14);
		pnlCreateProduct.add(lblHardwareId);
		
		JLabel lblCosmeticId = new JLabel("Cosmetic ID:");
		lblCosmeticId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCosmeticId.setBounds(38, 111, 94, 14);
		pnlCreateProduct.add(lblCosmeticId);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerId.setBounds(38, 136, 94, 14);
		pnlCreateProduct.add(lblCustomerId);
		
		JLabel lblPaidFor = new JLabel("Paid For:");
		lblPaidFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaidFor.setBounds(38, 161, 94, 14);
		pnlCreateProduct.add(lblPaidFor);
		
		txtProductID = new JTextField();
		txtProductID.setBounds(251, 10, 153, 20);
		pnlCreateProduct.add(txtProductID);
		txtProductID.setColumns(10);
		
		txtNeckID = new JTextField();
		txtNeckID.setColumns(10);
		txtNeckID.setBounds(251, 35, 153, 20);
		pnlCreateProduct.add(txtNeckID);
		
		JTextField txtBodyID = new JTextField();
		txtBodyID.setColumns(10);
		txtBodyID.setBounds(251, 60, 153, 20);
		pnlCreateProduct.add(txtBodyID);
		
		txtHardwareID = new JTextField();
		txtHardwareID.setColumns(10);
		txtHardwareID.setBounds(251, 85, 153, 20);
		pnlCreateProduct.add(txtHardwareID);
		
		txtCosmeticID = new JTextField();
		txtCosmeticID.setColumns(10);
		txtCosmeticID.setBounds(251, 110, 153, 20);
		pnlCreateProduct.add(txtCosmeticID);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setColumns(10);
		txtCustomerID.setBounds(251, 135, 153, 20);
		pnlCreateProduct.add(txtCustomerID);
		
		JRadioButton rdbtnPaidYes = new JRadioButton("Yes");
		btnGroupPaidFor.add(rdbtnPaidYes);
		rdbtnPaidYes.setBounds(251, 159, 50, 23);
		pnlCreateProduct.add(rdbtnPaidYes);
		
		JRadioButton rdbtnPaidNo = new JRadioButton("No");
		btnGroupPaidFor.add(rdbtnPaidNo);
		rdbtnPaidNo.setSelected(true);
		rdbtnPaidNo.setBounds(354, 159, 50, 23);
		pnlCreateProduct.add(rdbtnPaidNo);
		
		JButton btnProductMenu = new JButton("Product Menu");
		btnProductMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmProductBuilder.dispose();
			}
		});
		btnProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProductMenu.setBounds(251, 186, 153, 67);
		pnlCreateProduct.add(btnProductMenu);
		
		JButton btnCreateProduct = new JButton("Create Product");
		btnCreateProduct.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int productID = 0;
				int neckID = 0;
				int bodyID = 0;
				int hardwareID = 0;
				int cosmeticID = 0;
				int customerID = 0;
				char paid;
								
				try 
				{
					productID = Integer.parseInt(txtProductID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Product ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					neckID = Integer.parseInt(txtNeckID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Neck ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					bodyID = Integer.parseInt(txtBodyID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Body ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					hardwareID = Integer.parseInt(txtHardwareID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Hardware ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					cosmeticID = Integer.parseInt(txtCosmeticID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Cosmetic ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					customerID = Integer.parseInt(txtCustomerID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Customer ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
								
				if(rdbtnPaidYes.isSelected())
					paid = 'Y';
				else
				{
					paid = 'N';
				}
				
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nProduct ID: " + productID + "\nNeck ID: " + neckID + "\nBody ID: " + bodyID
						+ "\nHardware ID: " + hardwareID + "\nCosmetic ID: " + cosmeticID + "\nCustomer ID: "
						+ customerID + "\nPaid: " + paid, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0)
				{
					
					Product create= new Product(productID, neckID, bodyID, hardwareID, cosmeticID, customerID, paid); //creates Cosmetic object
					
					try
					{
						OracleJDBC.writeProduct(create); //passes to method that writes hardware to database
					}
					catch (SQLException e1)
					{
												
						if (e1.getErrorCode() == 00001) //sql error for PK constraint violation
							JOptionPane.showMessageDialog(null, "Product ID already in use",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else if(e1.getErrorCode() == 2291)
						{
							String message = e1.getMessage();
														
							if(message.contains("CUSTOMERID"))
							{
								JOptionPane.showMessageDialog(null, "Customer with ID: " +customerID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}
							else if(message.contains("COSMETICID"))
							{
								JOptionPane.showMessageDialog(null, "Cosmetics with ID: " +cosmeticID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}
							else if(message.contains("HARDWAREID"))
							{
								JOptionPane.showMessageDialog(null, "Hardware with ID: " +hardwareID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}
							else if(message.contains("BODYID"))
							{
								JOptionPane.showMessageDialog(null, "Body with ID: " +bodyID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}
							else if(message.contains("NECKID"))
							{
								JOptionPane.showMessageDialog(null, "Neck with ID: " +neckID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}						
							
						}
						else if (e1.getErrorCode() == 1438) //sql error for hardware ID too long
							JOptionPane.showMessageDialog(null, "All IDs must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					
					JOptionPane.showMessageDialog(null, "Product Created",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not create Product",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				
				
			}
		});
		btnCreateProduct.setForeground(Color.BLACK);
		btnCreateProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateProduct.setBounds(38, 186, 153, 67);
		pnlCreateProduct.add(btnCreateProduct);
		
		JPanel pnlUpdateProduct = new JPanel();
		pnlUpdateProduct.setLayout(null);
		tabbedPane.addTab("Update Product", null, pnlUpdateProduct, null);
		
		JLabel lblUpdateProductID = new JLabel("Product ID:");
		lblUpdateProductID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateProductID.setBounds(38, 11, 94, 14);
		pnlUpdateProduct.add(lblUpdateProductID);
		
		JLabel lblUpdateNeckID = new JLabel("Neck ID:");
		lblUpdateNeckID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateNeckID.setBounds(38, 36, 94, 14);
		pnlUpdateProduct.add(lblUpdateNeckID);
		
		JLabel lblUpdateBodyID = new JLabel("Body ID:");
		lblUpdateBodyID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateBodyID.setBounds(38, 61, 94, 14);
		pnlUpdateProduct.add(lblUpdateBodyID);
		
		JLabel lblUpdateHardwareID = new JLabel("Hardware ID:");
		lblUpdateHardwareID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateHardwareID.setBounds(38, 86, 94, 14);
		pnlUpdateProduct.add(lblUpdateHardwareID);
		
		JLabel lblUpdateCosmeticID = new JLabel("Cosmetic ID:");
		lblUpdateCosmeticID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateCosmeticID.setBounds(38, 111, 94, 14);
		pnlUpdateProduct.add(lblUpdateCosmeticID);
		
		JLabel lblUpdateCustomerID = new JLabel("Customer ID:");
		lblUpdateCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateCustomerID.setBounds(38, 136, 94, 14);
		pnlUpdateProduct.add(lblUpdateCustomerID);
		
		JLabel lblUpdatePaidFor = new JLabel("Paid For:");
		lblUpdatePaidFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdatePaidFor.setBounds(38, 161, 94, 14);
		pnlUpdateProduct.add(lblUpdatePaidFor);
		
		txtUpdateProductID = new JTextField();
		txtUpdateProductID.setColumns(10);
		txtUpdateProductID.setBounds(251, 10, 68, 20);
		pnlUpdateProduct.add(txtUpdateProductID);
		
		txtUpdateNeckID = new JTextField();
		txtUpdateNeckID.setColumns(10);
		txtUpdateNeckID.setBounds(251, 35, 153, 20);
		pnlUpdateProduct.add(txtUpdateNeckID);
		
		txtUpdateBodyID = new JTextField();
		txtUpdateBodyID.setColumns(10);
		txtUpdateBodyID.setBounds(251, 60, 153, 20);
		pnlUpdateProduct.add(txtUpdateBodyID);
		
		txtUpdateHardwareID = new JTextField();
		txtUpdateHardwareID.setColumns(10);
		txtUpdateHardwareID.setBounds(251, 85, 153, 20);
		pnlUpdateProduct.add(txtUpdateHardwareID);
		
		txtUpdateCosmeticID = new JTextField();
		txtUpdateCosmeticID.setColumns(10);
		txtUpdateCosmeticID.setBounds(251, 110, 153, 20);
		pnlUpdateProduct.add(txtUpdateCosmeticID);
		
		txtUpdateCustomerID = new JTextField();
		txtUpdateCustomerID.setColumns(10);
		txtUpdateCustomerID.setBounds(251, 135, 153, 20);
		pnlUpdateProduct.add(txtUpdateCustomerID);
		
		JRadioButton rdbtnUpdatePaidYes = new JRadioButton("Yes");
		btnGroupUpdatePaidFor.add(rdbtnUpdatePaidYes);
		rdbtnUpdatePaidYes.setBounds(251, 159, 50, 23);
		pnlUpdateProduct.add(rdbtnUpdatePaidYes);
		
		JRadioButton rdbtnUpdatePaidNo = new JRadioButton("No");
		btnGroupUpdatePaidFor.add(rdbtnUpdatePaidNo);
		rdbtnUpdatePaidNo.setSelected(true);
		rdbtnUpdatePaidNo.setBounds(354, 159, 50, 23);
		pnlUpdateProduct.add(rdbtnUpdatePaidNo);
		
		JButton btnUpdateProductMenu = new JButton("Product Menu");
		btnUpdateProductMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmProductBuilder.dispose();
			}
		});
		btnUpdateProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateProductMenu.setBounds(251, 186, 153, 67);
		pnlUpdateProduct.add(btnUpdateProductMenu);
		
		JButton btnUpdateProduct = new JButton("Update Product");
		btnUpdateProduct.setEnabled(false);
		btnUpdateProduct.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int productID = 0;
				int neckID = 0;
				int bodyID = 0;
				int hardwareID = 0;
				int cosmeticID = 0;
				int customerID = 0;
				char paid;
				
				try 
				{
					productID = Integer.parseInt(txtUpdateProductID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					neckID = Integer.parseInt(txtUpdateNeckID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Neck ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					bodyID = Integer.parseInt(txtUpdateBodyID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Body ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					hardwareID = Integer.parseInt(txtUpdateHardwareID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Hardware ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					cosmeticID = Integer.parseInt(txtUpdateCosmeticID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Cosmetic ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				try 
				{
					customerID = Integer.parseInt(txtUpdateCustomerID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Customer ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
								
				if(rdbtnUpdatePaidYes.isSelected())
					paid = 'Y';
				else
				{
					paid = 'N';
				}
				
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nProduct ID: " + productID + "\nNeck ID: " + neckID + "\nBody ID: " + bodyID
						+ "\nHardware ID: " + hardwareID + "\nCosmetic ID: " + cosmeticID + "\nCustomer ID: "
						+ customerID + "\nPaid: " + paid, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0)
				{
					
					Product update = new Product(productID, neckID, bodyID, hardwareID, cosmeticID, customerID, paid); //creates Cosmetic object
					
					try
					{
						OracleJDBC.updateProduct(update); //passes to method that writes hardware to database
					}
					catch (SQLException e1)
					{
												
						if (e1.getErrorCode() == 00001) //sql error for PK constraint violation
							JOptionPane.showMessageDialog(null, "Product ID already in use",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else if(e1.getErrorCode() == 2291)
						{
							String message = e1.getMessage();
														
							if(message.contains("CUSTOMERID"))
							{
								JOptionPane.showMessageDialog(null, "Customer with ID: " +customerID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}
							else if(message.contains("COSMETICID"))
							{
								JOptionPane.showMessageDialog(null, "Cosmetics with ID: " +cosmeticID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}
							else if(message.contains("HARDWAREID"))
							{
								JOptionPane.showMessageDialog(null, "Hardware with ID: " +hardwareID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}
							else if(message.contains("BODYID"))
							{
								JOptionPane.showMessageDialog(null, "Body with ID: " +bodyID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}
							else if(message.contains("NECKID"))
							{
								JOptionPane.showMessageDialog(null, "Neck with ID: " +neckID+" Does Not Exist",
			                            "Error", JOptionPane.ERROR_MESSAGE, null);
							}						
							
						}
						else if (e1.getErrorCode() == 1438) //sql error for hardware ID too long
							JOptionPane.showMessageDialog(null, "All IDs must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					
					JOptionPane.showMessageDialog(null, "Product Updated",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not update Product",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
			}
		});
		btnUpdateProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateProduct.setBounds(38, 186, 153, 67);
		pnlUpdateProduct.add(btnUpdateProduct);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int productID = 0;
				try
				{
					productID = Integer.parseInt(txtUpdateProductID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				int returnProductID = 0;
				String neckID = null;
				String bodyID = null;
				String hardwareID = null;
				String cosmeticID = null;
				String customerID = null;
				String paid = null;
				
				try
				{
					returnProductID = OracleJDBC.readProductID(productID);
					neckID = Integer.toString(OracleJDBC.readProductNeckID(productID));
					bodyID = Integer.toString(OracleJDBC.readProductBodyID(productID));
					hardwareID = Integer.toString(OracleJDBC.readProductHardwareID(productID));
					cosmeticID = Integer.toString(OracleJDBC.readProductCosmeticID(productID));
					customerID = Integer.toString(OracleJDBC.readProductCustomerID(productID));
					paid = OracleJDBC.readPaid(productID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Cosmetic Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnProductID != 0) //checks if hardware exists
				{
				
					txtUpdateNeckID.setText(neckID);
					txtUpdateBodyID.setText(bodyID);
					txtUpdateHardwareID.setText(hardwareID);
					txtUpdateCosmeticID.setText(cosmeticID);
					txtUpdateCustomerID.setText(customerID);
					
					if(paid.equals("N"))
					{
						rdbtnUpdatePaidNo.setSelected(true);
					}
					else
					{
						rdbtnUpdatePaidYes.setSelected(true);
					}
					
					btnUpdateProduct.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Product Info, Product ID " + productID +" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					
					return;
				}
			}
		});
		btnNewButton.setBounds(329, 9, 68, 23);
		pnlUpdateProduct.add(btnNewButton);
		
		JPanel pnlReviewProduct = new JPanel();
		tabbedPane.addTab("Review Product", null, pnlReviewProduct, null);
		pnlReviewProduct.setLayout(null);
		
		JLabel lblReviewProductID = new JLabel("Product ID:");
		lblReviewProductID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewProductID.setBounds(42, 12, 94, 14);
		pnlReviewProduct.add(lblReviewProductID);
		
		txtReviewProductID = new JTextField();
		txtReviewProductID.setColumns(10);
		txtReviewProductID.setBounds(255, 11, 153, 20);
		pnlReviewProduct.add(txtReviewProductID);
		
		JButton btnReviewProductMenu = new JButton("Product Menu");
		btnReviewProductMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmProductBuilder.dispose();
			}
		});
		btnReviewProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReviewProductMenu.setBounds(255, 37, 153, 67);
		pnlReviewProduct.add(btnReviewProductMenu);
		
		JLabel lblReviewNeckID = new JLabel("Neck ID:");
		lblReviewNeckID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewNeckID.setBounds(42, 115, 94, 14);
		pnlReviewProduct.add(lblReviewNeckID);
		
		JLabel lblReviewBodyID = new JLabel("Body ID:");
		lblReviewBodyID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewBodyID.setBounds(42, 140, 94, 14);
		pnlReviewProduct.add(lblReviewBodyID);
		
		JLabel lblReviewHardwareID = new JLabel("Hardware ID:");
		lblReviewHardwareID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewHardwareID.setBounds(42, 165, 94, 14);
		pnlReviewProduct.add(lblReviewHardwareID);
		
		JLabel lblReviewCosmeticID = new JLabel("Cosmetic ID:");
		lblReviewCosmeticID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewCosmeticID.setBounds(42, 190, 94, 14);
		pnlReviewProduct.add(lblReviewCosmeticID);
		
		JLabel lblReviewCustomerID = new JLabel("Customer ID:");
		lblReviewCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewCustomerID.setBounds(42, 215, 94, 14);
		pnlReviewProduct.add(lblReviewCustomerID);
		
		JLabel lblReviewPaidFor = new JLabel("Paid For:");
		lblReviewPaidFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReviewPaidFor.setBounds(42, 240, 94, 14);
		pnlReviewProduct.add(lblReviewPaidFor);
		
		JLabel lblShowNeckID = new JLabel("");
		lblShowNeckID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShowNeckID.setBounds(255, 114, 153, 14);
		pnlReviewProduct.add(lblShowNeckID);
		
		JLabel lblShowBodyID = new JLabel("");
		lblShowBodyID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShowBodyID.setBounds(255, 139, 153, 14);
		pnlReviewProduct.add(lblShowBodyID);
		
		JLabel lblShowHardwareID = new JLabel("");
		lblShowHardwareID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShowHardwareID.setBounds(255, 164, 153, 14);
		pnlReviewProduct.add(lblShowHardwareID);
		
		JLabel lblShowCosmeticID = new JLabel("");
		lblShowCosmeticID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShowCosmeticID.setBounds(255, 189, 153, 14);
		pnlReviewProduct.add(lblShowCosmeticID);
		
		JLabel lblShowCustomerID = new JLabel("");
		lblShowCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShowCustomerID.setBounds(255, 214, 153, 14);
		pnlReviewProduct.add(lblShowCustomerID);
		
		JLabel lblShowPaidFor = new JLabel("");
		lblShowPaidFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShowPaidFor.setBounds(255, 239, 153, 14);
		pnlReviewProduct.add(lblShowPaidFor);
		
		JButton btnReviewProduct = new JButton("Review Product");
		btnReviewProduct.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				int productID = 0;
				try
				{
					productID = Integer.parseInt(txtReviewProductID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				int returnProductID = 0;
				String neckID = null;
				String bodyID = null;
				String hardwareID = null;
				String cosmeticID = null;
				String customerID = null;
				String paid = null;
				
				try
				{
					returnProductID = OracleJDBC.readProductID(productID);
					neckID = Integer.toString(OracleJDBC.readProductNeckID(productID));
					bodyID = Integer.toString(OracleJDBC.readProductBodyID(productID));
					hardwareID = Integer.toString(OracleJDBC.readProductHardwareID(productID));
					cosmeticID = Integer.toString(OracleJDBC.readProductCosmeticID(productID));
					customerID = Integer.toString(OracleJDBC.readProductCustomerID(productID));
					paid = OracleJDBC.readPaid(productID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Cosmetic Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnProductID != 0) //checks if hardware exists
				{
				
					lblShowNeckID.setText(neckID);
					lblShowBodyID.setText(bodyID);
					lblShowHardwareID.setText(hardwareID);
					lblShowCosmeticID.setText(cosmeticID);
					lblShowCustomerID.setText(customerID);
					
					if(paid.equals("N"))
					{
						lblShowPaidFor.setText("No");
					}
					else
					{
						lblShowPaidFor.setText("Yes");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Product Info, Product ID " + productID +" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					
					return;
				}
			}
		});
		btnReviewProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReviewProduct.setBounds(42, 37, 153, 67);
		pnlReviewProduct.add(btnReviewProduct);
		
		JPanel pnlDeleteProduct = new JPanel();
		tabbedPane.addTab("Delete Product", null, pnlDeleteProduct, null);
		pnlDeleteProduct.setLayout(null);
		
		JLabel lblDeleteProductID = new JLabel("Product ID:");
		lblDeleteProductID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeleteProductID.setBounds(42, 12, 94, 14);
		pnlDeleteProduct.add(lblDeleteProductID);
		
		txtDeleteProductID = new JTextField();
		txtDeleteProductID.setColumns(10);
		txtDeleteProductID.setBounds(255, 11, 153, 20);
		pnlDeleteProduct.add(txtDeleteProductID);
		
		JButton btnDeleteProductMenu = new JButton("Product Menu");
		btnDeleteProductMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmProductBuilder.dispose();
			}
		});
		btnDeleteProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteProductMenu.setBounds(255, 37, 153, 67);
		pnlDeleteProduct.add(btnDeleteProductMenu);
		
		JButton btnDeleteProduct = new JButton("Delete Product");
		btnDeleteProduct.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int productID = 0;
				try
				{
					productID = Integer.parseInt(txtDeleteProductID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				int returnProductID = 0;
				String neckID = null;
				String bodyID = null;
				String hardwareID = null;
				String cosmeticID = null;
				String customerID = null;
				String paid = null;
				
				try
				{
					returnProductID = OracleJDBC.readProductID(productID);
					neckID = Integer.toString(OracleJDBC.readProductNeckID(productID));
					bodyID = Integer.toString(OracleJDBC.readProductBodyID(productID));
					hardwareID = Integer.toString(OracleJDBC.readProductHardwareID(productID));
					cosmeticID = Integer.toString(OracleJDBC.readProductCosmeticID(productID));
					customerID = Integer.toString(OracleJDBC.readProductCustomerID(productID));
					paid = OracleJDBC.readPaid(productID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Cosmetic Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if (returnProductID == 0)
				{
					JOptionPane.showMessageDialog(null, "Product with ID " + productID + " does not exist!",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
				}
				else
				{
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the following product?"
							+ "\nProduct ID: " + productID + "\nNeck ID: " + neckID + "\nBody ID: " + bodyID
							+ "\nHardware ID: " + hardwareID + "\nCosmetic ID: " + cosmeticID + "\nCustomer ID: "
							+ customerID + "\nPaid: " + paid, "Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					if(choice == 0)
					{
						try
						{
							OracleJDBC.deleteProduct(productID);
						}
						catch(SQLException e1)
						{
							JOptionPane.showMessageDialog(null, "Couldn't Delete Product", "Error", JOptionPane.ERROR_MESSAGE, null);
						}
						
						JOptionPane.showMessageDialog(null, "Product Deleted", "Success", JOptionPane.INFORMATION_MESSAGE, null);
					}
					
				}
			}
		});
		btnDeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteProduct.setBounds(42, 37, 153, 67);
		pnlDeleteProduct.add(btnDeleteProduct);
	}
}
