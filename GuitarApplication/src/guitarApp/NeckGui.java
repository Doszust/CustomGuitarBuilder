/**
 * @author Dylan Oszust
 *  3/12/2017
 *  This class creates the Graphical User Interface for management of Neck Objects
 */

package guitarApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;


public class NeckGui
{

	private JFrame frmNeck;
	private JTextField txtNeckID;
	private JTextField txtReviewNeckID;
	private JTextField txtDeleteNeckID;
	private JTextField txtUpdateID;

	/**
	 * Launch the window.
	 */
	public static void createNeckGui()
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					NeckGui window = new NeckGui();
					window.frmNeck.setVisible(true);
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
	public NeckGui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmNeck = new JFrame();
		frmNeck.setResizable(false);
		frmNeck.setTitle("Guitar Builder - Neck");
		frmNeck.setBounds(100, 100, 403, 311);
		frmNeck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNeck.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmNeck.setLocation(dim.width/2-frmNeck.getSize().width/2, dim.height/2-frmNeck.getSize().height/2); //centers the window
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 0, 397, 282);
		frmNeck.getContentPane().add(tabbedPane);
		
		//create neck tab and objects
		JPanel pnlCreateNeck = new JPanel();
		tabbedPane.addTab("Create Neck", null, pnlCreateNeck, null);
		pnlCreateNeck.setLayout(null);
		JLabel lblEnterNeckId = new JLabel("Enter Neck ID: ");
		lblEnterNeckId.setBounds(10, 14, 164, 14);
		pnlCreateNeck.add(lblEnterNeckId);
		JLabel lblSelectNeckWood = new JLabel("Select Neck Wood:");
		lblSelectNeckWood.setBounds(10, 39, 164, 14);
		pnlCreateNeck.add(lblSelectNeckWood);
		JLabel lbl = new JLabel("Select Finger Board:");
		lbl.setBounds(10, 64, 164, 14);
		pnlCreateNeck.add(lbl);
		JLabel lblSelectScale = new JLabel("Select Scale:");
		lblSelectScale.setBounds(10, 89, 164, 14);
		pnlCreateNeck.add(lblSelectScale);
		JLabel lblSelectNumberOfFrets = new JLabel("Select Number Of Frets:");
		lblSelectNumberOfFrets.setBounds(10, 114, 164, 14);
		pnlCreateNeck.add(lblSelectNumberOfFrets);
		JLabel lblSelectNeckJoint = new JLabel("Select Neck Joint:");
		lblSelectNeckJoint.setBounds(10, 139, 164, 14);
		pnlCreateNeck.add(lblSelectNeckJoint);
		
		txtNeckID = new JTextField();
		txtNeckID.setHorizontalAlignment(SwingConstants.TRAILING);
		txtNeckID.setBounds(216, 11, 166, 20);
		pnlCreateNeck.add(txtNeckID);
		txtNeckID.setColumns(10);
		
		JComboBox cmbBoxNeckWood = new JComboBox();
		cmbBoxNeckWood.setModel(new DefaultComboBoxModel(new String[] {"Mahogany", "Maple", "Cedar"}));
		cmbBoxNeckWood.setBounds(216, 36, 166, 20);
		pnlCreateNeck.add(cmbBoxNeckWood);
		JComboBox cmbBoxFingerBoard = new JComboBox();
		cmbBoxFingerBoard.setModel(new DefaultComboBoxModel(new String[] {"Rosewood", "Maple", "Ebony"}));
		cmbBoxFingerBoard.setBounds(216, 61, 166, 20);
		pnlCreateNeck.add(cmbBoxFingerBoard);
		JComboBox cmbBoxScale = new JComboBox();
		cmbBoxScale.setModel(new DefaultComboBoxModel(new String[] {"24.62", "24.75", "24.90", "25.50"}));
		cmbBoxScale.setBounds(216, 86, 166, 20);
		pnlCreateNeck.add(cmbBoxScale);
		JComboBox cmbBoxFrets = new JComboBox();
		cmbBoxFrets.setModel(new DefaultComboBoxModel(new String[] {"21", "22", "23", "24"}));
		cmbBoxFrets.setBounds(216, 111, 166, 20);
		pnlCreateNeck.add(cmbBoxFrets);
		JComboBox cmbBoxJoint = new JComboBox();
		cmbBoxJoint.setModel(new DefaultComboBoxModel(new String[] {"Bolt On", "Set", "Through"}));
		cmbBoxJoint.setBounds(216, 136, 166, 20);
		pnlCreateNeck.add(cmbBoxJoint);
		
		JButton btnCreateNeck = new JButton("Create Neck"); //creates the neck and enters data into database
		btnCreateNeck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				
				try
				{
					ID = Integer.parseInt(txtNeckID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				String neckWood = (String)cmbBoxNeckWood.getSelectedItem();
				String fingerBoard = (String)cmbBoxFingerBoard.getSelectedItem();
				double scale = Double.parseDouble((String)cmbBoxScale.getSelectedItem());
				int numberOfFrets = Integer.parseInt((String)cmbBoxFrets.getSelectedItem());
				String neckJoint = (String)cmbBoxJoint.getSelectedItem();
				
				//confirmation dialog
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nNeck Wood: " + neckWood + "\nFinger Board: " + fingerBoard
						+ "\nScale: " + scale + "\nNumber of Frets: " + numberOfFrets + "\nNeck Joint: "
						+ neckJoint, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				//if information confirmed, commits data to database.
				if(choice == 0)
				{
					
					Neck create = new Neck(ID, neckWood, fingerBoard, scale, numberOfFrets, neckJoint); //creates neck object
					
					try
					{
						OracleJDBC.writeNeck(create); //passes to method that writes neck to database
					} 
					catch (SQLException e1)
					{
						
									
						if (e1.getErrorCode() == 00001) //sql error for PK constraint violation
							JOptionPane.showMessageDialog(null, "Neck ID already in use",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else if (e1.getErrorCode() == 1438) //sql error for neck ID too long
							JOptionPane.showMessageDialog(null, "Neck ID to long, must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Neck Created",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not create Neck",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				
				
			}
		});
		btnCreateNeck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateNeck.setBounds(10, 164, 166, 69);
		pnlCreateNeck.add(btnCreateNeck);
		
		JButton btnProductMenu = new JButton("Product Menu");
		btnProductMenu.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Builder.createBuilderGui();
				frmNeck.dispose();
			}
		});
		btnProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProductMenu.setBounds(216, 164, 166, 69);
		pnlCreateNeck.add(btnProductMenu);
		
		//update neck tab and objects
		JPanel pnlUpdateNeck = new JPanel();
		tabbedPane.addTab("Update Neck", null, pnlUpdateNeck, null);
		pnlUpdateNeck.setBounds(0,0,300,5);
		pnlUpdateNeck.setLayout(null);
		JLabel lblUpdateFrets = new JLabel("Select Number Of Frets:");
		lblUpdateFrets.setBounds(10, 114, 186, 14);
		pnlUpdateNeck.add(lblUpdateFrets);
		JLabel lblUpdateNeckID = new JLabel("Enter Neck ID For Update: ");
		lblUpdateNeckID.setBounds(10, 14, 186, 14);
		pnlUpdateNeck.add(lblUpdateNeckID);
		JLabel lblUpdateNeckWood = new JLabel("Select Neck Wood:");
		lblUpdateNeckWood.setBounds(10, 39, 186, 14);
		pnlUpdateNeck.add(lblUpdateNeckWood);
		JLabel lblUpdateFingerBoard = new JLabel("Select Finger Board:");
		lblUpdateFingerBoard.setBounds(10, 64, 186, 14);
		pnlUpdateNeck.add(lblUpdateFingerBoard);
		JLabel lblUpdateScale = new JLabel("Select Scale:");
		lblUpdateScale.setBounds(10, 89, 186, 14);
		pnlUpdateNeck.add(lblUpdateScale);
		JLabel lblUpdateJoint = new JLabel("Select Neck Joint:");
		lblUpdateJoint.setBounds(10, 139, 186, 14);
		pnlUpdateNeck.add(lblUpdateJoint);
		
		JComboBox cmbBoxUpdateJoint = new JComboBox();
		cmbBoxUpdateJoint.setModel(new DefaultComboBoxModel(new String[] {"Bolt On", "Set", "Through"}));
		cmbBoxUpdateJoint.setBounds(216, 136, 166, 20);
		pnlUpdateNeck.add(cmbBoxUpdateJoint);
		JComboBox cmbBoxUpdateFrets = new JComboBox();
		cmbBoxUpdateFrets.setModel(new DefaultComboBoxModel(new String[] {"21", "22", "23", "24"}));
		cmbBoxUpdateFrets.setBounds(216, 111, 166, 20);
		pnlUpdateNeck.add(cmbBoxUpdateFrets);
		JComboBox cmbBoxUpdateScale = new JComboBox();
		cmbBoxUpdateScale.setModel(new DefaultComboBoxModel(new String[] {"24.62", "24.75", "24.90", "25.50"}));
		cmbBoxUpdateScale.setBounds(216, 86, 166, 20);
		pnlUpdateNeck.add(cmbBoxUpdateScale);
		JComboBox cmbBoxUpdateFingerBoard = new JComboBox();
		cmbBoxUpdateFingerBoard.setModel(new DefaultComboBoxModel(new String[] {"Rosewood", "Maple", "Ebony"}));
		cmbBoxUpdateFingerBoard.setBounds(216, 61, 166, 20);
		pnlUpdateNeck.add(cmbBoxUpdateFingerBoard);
		JComboBox cmbBoxUpdateNeckWood = new JComboBox();
		cmbBoxUpdateNeckWood.setModel(new DefaultComboBoxModel(new String[] {"Mahogany", "Maple", "Cedar"}));
		cmbBoxUpdateNeckWood.setBounds(216, 36, 166, 20);
		pnlUpdateNeck.add(cmbBoxUpdateNeckWood);
		
		txtUpdateID = new JTextField();
		txtUpdateID.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUpdateID.setColumns(10);
		txtUpdateID.setBounds(216, 11, 97, 20);
		pnlUpdateNeck.add(txtUpdateID);
		
		JButton btnUpdateNeck = new JButton("Update Neck"); //updates neck data
		btnUpdateNeck.setEnabled(false);
		btnUpdateNeck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try
				{
					ID = Integer.parseInt(txtUpdateID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				String neckWood = (String)cmbBoxUpdateNeckWood.getSelectedItem();
				String fingerBoard = (String)cmbBoxUpdateFingerBoard.getSelectedItem();
				double scale = Double.parseDouble((String)cmbBoxUpdateScale.getSelectedItem());
				int numberOfFrets = Integer.parseInt((String)cmbBoxUpdateFrets.getSelectedItem());
				String neckJoint = (String)cmbBoxUpdateJoint.getSelectedItem();
				
				
				//confirmation dialog
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nNeck Wood: " + neckWood + "\nFinger Board: " + fingerBoard
						+ "\nScale: " + scale + "\nNumber of Frets: " + numberOfFrets + "\nNeck Joint: "
						+ neckJoint, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if(choice == 0)
				{
					
					Neck update = new Neck(ID, neckWood, fingerBoard, scale, numberOfFrets, neckJoint); //creates neck object
					
					try
					{
						OracleJDBC.updateNeck(update); //passes to method that writes neck to database
					} 
					catch (SQLException e1)
					{
							e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Neck Updated",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not update Neck",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
			}
		});
		btnUpdateNeck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateNeck.setBounds(10, 164, 166, 69);
		pnlUpdateNeck.add(btnUpdateNeck);
		
		JButton btnUpdateProductMenu = new JButton("Product Menu");
		btnUpdateProductMenu.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmNeck.dispose();
			}
		});
		btnUpdateProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateProductMenu.setBounds(216, 164, 166, 69);
		pnlUpdateNeck.add(btnUpdateProductMenu);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try
				{
					ID = Integer.parseInt(txtUpdateID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				int returnID = 0;
				String neckWood = null;
				String fingerBoard = null;
				String scale = null;
				String numberOfFrets = null;
				String neckJoint = null;
				
				try
				{
					returnID = OracleJDBC.readNeckID(ID);
					neckWood = OracleJDBC.readNeckWood(ID);
					fingerBoard = OracleJDBC.readFingerBoard(ID);
					scale = OracleJDBC.readScale(ID);
					numberOfFrets = OracleJDBC.readNumberOfFrets(ID);
					neckJoint = OracleJDBC.readNeckJoint(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Neck Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnID != 0) //checks if neck exists
				{
				
					cmbBoxUpdateNeckWood.setSelectedItem(neckWood);
					cmbBoxUpdateFingerBoard.setSelectedItem(fingerBoard);
					cmbBoxUpdateScale.setSelectedItem(scale);
					cmbBoxUpdateFrets.setSelectedItem(numberOfFrets);
					cmbBoxUpdateJoint.setSelectedItem(neckJoint);
					
					btnUpdateNeck.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Neck Info, Neck ID " + ID +" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					
					return;
				}
			}
		});
		btnEnter.setBounds(313, 10, 69, 21);
		pnlUpdateNeck.add(btnEnter);
		
		//review neck tab and objects
		JPanel pnlReviewNeck = new JPanel();
		tabbedPane.addTab("Review Neck", null, pnlReviewNeck, null);
		pnlReviewNeck.setLayout(null);
		
		JButton btnReviewProductMenu = new JButton("Product Menu");
		btnReviewProductMenu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmNeck.dispose();
			}
		});
		btnReviewProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReviewProductMenu.setBounds(208, 39, 174, 72);
		pnlReviewNeck.add(btnReviewProductMenu);
		
		JLabel lblNeckJoint = new JLabel("Neck Joint:");
		lblNeckJoint.setBounds(10, 222, 174, 14);
		pnlReviewNeck.add(lblNeckJoint);
		JLabel lblNumberOfFrets = new JLabel("Number Of Frets:");
		lblNumberOfFrets.setBounds(10, 197, 174, 14);
		pnlReviewNeck.add(lblNumberOfFrets);
		JLabel lblScale = new JLabel("Scale:");
		lblScale.setBounds(10, 172, 174, 14);
		pnlReviewNeck.add(lblScale);
		JLabel lblFingerBoard = new JLabel("Finger Board:");
		lblFingerBoard.setBounds(10, 147, 174, 14);
		pnlReviewNeck.add(lblFingerBoard);
		JLabel lblNeckWood = new JLabel("Neck Wood:");
		lblNeckWood.setBounds(10, 122, 174, 14);
		pnlReviewNeck.add(lblNeckWood);
		JLabel label_11 = new JLabel("Enter Neck ID: ");
		label_11.setBounds(10, 17, 174, 14);
		pnlReviewNeck.add(label_11);
		
		txtReviewNeckID = new JTextField();
		txtReviewNeckID.setHorizontalAlignment(SwingConstants.TRAILING);
		txtReviewNeckID.setColumns(10);
		txtReviewNeckID.setBounds(208, 14, 174, 20);
		pnlReviewNeck.add(txtReviewNeckID);
		
		JLabel lblShowNeckWood = new JLabel("");
		lblShowNeckWood.setBounds(208, 122, 174, 14);
		pnlReviewNeck.add(lblShowNeckWood);
		JLabel lblShowFingerBoard = new JLabel("");
		lblShowFingerBoard.setBounds(208, 147, 174, 14);
		pnlReviewNeck.add(lblShowFingerBoard);
		JLabel lblShowScale = new JLabel("");
		lblShowScale.setBounds(208, 172, 174, 14);
		pnlReviewNeck.add(lblShowScale);
		JLabel lblShowFrets = new JLabel("");
		lblShowFrets.setBounds(208, 197, 174, 14);
		pnlReviewNeck.add(lblShowFrets);
		JLabel lblShowJoint = new JLabel("");
		lblShowJoint.setBounds(208, 222, 174, 14);
		pnlReviewNeck.add(lblShowJoint);
		
		JButton btnReviewNeck = new JButton("Review Neck");
		btnReviewNeck.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try
				{
					ID = Integer.parseInt(txtReviewNeckID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				int returnID = 0;
				String neckWood = null;
				String fingerBoard = null;
				String scale = null;
				String numberOfFrets = null;
				String neckJoint = null;
				
				try
				{
					returnID = OracleJDBC.readNeckID(ID);
					neckWood = OracleJDBC.readNeckWood(ID);
					fingerBoard = OracleJDBC.readFingerBoard(ID);
					scale = OracleJDBC.readScale(ID);
					numberOfFrets = OracleJDBC.readNumberOfFrets(ID);
					neckJoint = OracleJDBC.readNeckJoint(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Neck Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnID != 0) //checks if neck exists
				{
				
					lblShowNeckWood.setText(neckWood);
					lblShowFingerBoard.setText(fingerBoard);
					lblShowScale.setText(scale);
					lblShowFrets.setText(numberOfFrets);
					lblShowJoint.setText(neckJoint);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Neck Info, Neck ID " + ID +" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					
					return;
				}
			}
		});
		btnReviewNeck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReviewNeck.setBounds(10, 39, 174, 72);
		pnlReviewNeck.add(btnReviewNeck);
		
		//delete neck tab and objects
		JPanel pnlDeleteNeck = new JPanel();
		tabbedPane.addTab("Delete Neck", null, pnlDeleteNeck, null);
		pnlDeleteNeck.setLayout(null);
		
		JLabel label_6 = new JLabel("Enter Neck ID: ");
		label_6.setBounds(10, 17, 174, 14);
		pnlDeleteNeck.add(label_6);
		
		txtDeleteNeckID = new JTextField();
		txtDeleteNeckID.setHorizontalAlignment(SwingConstants.TRAILING);
		txtDeleteNeckID.setColumns(10);
		txtDeleteNeckID.setBounds(208, 14, 174, 20);
		pnlDeleteNeck.add(txtDeleteNeckID);
		
		JButton btnDeleteNeck = new JButton("DELETE NECK");
		btnDeleteNeck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try
				{
					ID = Integer.parseInt(txtDeleteNeckID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				int returnID = 0;
				String neckWood = null;
				String fingerBoard = null;
				String scale = null;
				String numberOfFrets = null;
				String neckJoint = null;
				
				try
				{
					returnID = OracleJDBC.readNeckID(ID);
					neckWood = OracleJDBC.readNeckWood(ID);
					fingerBoard = OracleJDBC.readFingerBoard(ID);
					scale = OracleJDBC.readScale(ID);
					numberOfFrets = OracleJDBC.readNumberOfFrets(ID);
					neckJoint = OracleJDBC.readNeckJoint(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Neck Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if (returnID == 0)
				{
					JOptionPane.showMessageDialog(null, "Neck with ID " + ID + " does not exist!",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
				}
				else
				{
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the following neck?"
							+ "\nID: " + returnID + "\nNeck Wood: " + neckWood + "\nFinger Board: " + fingerBoard
							+ "\nScale: " + scale + "\nNumber of Frets: " + numberOfFrets + "\nNeck Joint: "
							+ neckJoint, "Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					
					if (choice == 0)
					{
						try
						{
							OracleJDBC.deleteNeck(ID);
						} 
						catch (SQLException e1)
						{
							JOptionPane.showMessageDialog(null, "Couldn't Delete Neck", "Error", JOptionPane.ERROR_MESSAGE, null);
						}
						
						JOptionPane.showMessageDialog(null, "Neck Deleted", "Sucess", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else
					{
						return;
					}
				}
			}
		});
		btnDeleteNeck.setForeground(new Color(204, 0, 0));
		btnDeleteNeck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteNeck.setBounds(10, 39, 174, 72);
		pnlDeleteNeck.add(btnDeleteNeck);
		
		JButton btnDeleteProductMenu = new JButton("Product Menu");
		btnDeleteProductMenu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmNeck.dispose();
			}
		});
		btnDeleteProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteProductMenu.setBounds(208, 39, 174, 72);
		pnlDeleteNeck.add(btnDeleteProductMenu);
	}
}
