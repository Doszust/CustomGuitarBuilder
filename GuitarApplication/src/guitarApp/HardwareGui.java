/**
 * @author Dylan Oszust
 *  3/12/2017
 *  This class is the Graphical User Interface that allows management of Hardware Objects
 */

package guitarApp;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import guitarApp.OracleJDBC;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;


public class HardwareGui
{

	private JFrame frmHardware;
	private JTextField txtHardwareID;
	private JTextField txtUpdateHardwareID;
	private JTextField txtReviewHardwareID;
	private JTextField txtDeleteHardwareID;

	/**
	 * Launch the application.
	 */
	public static void createHardwareGUI()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					HardwareGui window = new HardwareGui();
					window.frmHardware.setVisible(true);
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
	public HardwareGui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmHardware = new JFrame();
		frmHardware.setTitle("Guitar Builder - Hardware");
		frmHardware.setResizable(false);
		frmHardware.setBounds(100, 100, 514, 326);
		frmHardware.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHardware.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmHardware.setLocation(dim.width/2-frmHardware.getSize().width/2, dim.height/2-frmHardware.getSize().height/2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 508, 297);
		frmHardware.getContentPane().add(tabbedPane);
		
		JPanel pnlSelectHardware = new JPanel();
		tabbedPane.addTab("Select Hardware", null, pnlSelectHardware, null);
		pnlSelectHardware.setLayout(null);
		
		JLabel lblHardwareId = new JLabel("Hardware ID:");
		lblHardwareId.setBounds(41, 17, 180, 14);
		pnlSelectHardware.add(lblHardwareId);
		
		JLabel lblNeckPickup = new JLabel("Neck Pickup:");
		lblNeckPickup.setBounds(41, 42, 180, 14);
		pnlSelectHardware.add(lblNeckPickup);
		
		JLabel lblMiddlePickup = new JLabel("Middle Pickup:");
		lblMiddlePickup.setBounds(41, 67, 180, 14);
		pnlSelectHardware.add(lblMiddlePickup);
		
		JLabel lblBridgePickup = new JLabel("Bridge Pickup:");
		lblBridgePickup.setBounds(41, 92, 180, 14);
		pnlSelectHardware.add(lblBridgePickup);
		
		JLabel lblTonevolKnobs = new JLabel("Tone/Vol Knobs:");
		lblTonevolKnobs.setBounds(41, 117, 180, 14);
		pnlSelectHardware.add(lblTonevolKnobs);
		
		JLabel lblBridge = new JLabel("Bridge:");
		lblBridge.setBounds(41, 142, 180, 14);
		pnlSelectHardware.add(lblBridge);
		
		JLabel lblTuners = new JLabel("Tuners:");
		lblTuners.setBounds(41, 167, 180, 14);
		pnlSelectHardware.add(lblTuners);
		
		txtHardwareID = new JTextField();
		txtHardwareID.setBounds(286, 14, 179, 20);
		pnlSelectHardware.add(txtHardwareID);
		txtHardwareID.setColumns(10);
		
		JComboBox cmbBoxNeckPickup = new JComboBox();
		cmbBoxNeckPickup.setModel(new DefaultComboBoxModel(new String[] {"No Neck Pickup", "EMG-60", "EMG-80", "EMG-81\t\t\t\t\t\t", "EMG H4", "Seymore Duncan Livewire", "Seymore Duncan AHB", "Seymore Duncan Blackouts", "Seymore Duncan Invader", "Gibson 57 classic", "DiMarzio Gravity Storm", "Lace Sensor Emerald", "Seymore Duncan Zephyr", "DiMarzio True Velvet", "DiMarzio Red Velvet", "DiMarzio Injector", "EMG SA", "DiMarzio Twang King", "Fender Fat 50s", "Fender N3 Noiseless"}));
		cmbBoxNeckPickup.setBounds(286, 39, 179, 20);
		pnlSelectHardware.add(cmbBoxNeckPickup);
		
		JComboBox cmbBoxMiddlePickup = new JComboBox();
		cmbBoxMiddlePickup.setModel(new DefaultComboBoxModel(new String[] {"No Middle Pickup", "EMG-60", "EMG-80", "EMG-81\t\t\t\t\t\t", "EMG H4", "Seymore Duncan Livewire", "Seymore Duncan AHB", "Seymore Duncan Blackouts", "Seymore Duncan Invader", "Gibson 57 classic", "DiMarzio Gravity Storm", "Lace Sensor Emerald", "Seymore Duncan Zephyr", "DiMarzio True Velvet", "DiMarzio Red Velvet", "DiMarzio Injector", "EMG SA", "DiMarzio Twang King", "Fender Fat 50s", "Fender N3 Noiseless"}));
		cmbBoxMiddlePickup.setBounds(286, 64, 179, 20);
		pnlSelectHardware.add(cmbBoxMiddlePickup);
		
		JComboBox cmbBoxBridgePickup = new JComboBox();
		cmbBoxBridgePickup.setModel(new DefaultComboBoxModel(new String[] {"No Bridge Pickup", "EMG-60", "EMG-80", "EMG-81\t\t\t\t\t\t", "EMG H4", "Seymore Duncan Livewire", "Seymore Duncan AHB", "Seymore Duncan Blackouts", "Seymore Duncan Invader", "Gibson 57 classic", "DiMarzio Gravity Storm", "Lace Sensor Emerald", "Seymore Duncan Zephyr", "DiMarzio True Velvet", "DiMarzio Red Velvet", "DiMarzio Injector", "EMG SA", "DiMarzio Twang King", "Fender Fat 50s", "Fender N3 Noiseless"}));
		cmbBoxBridgePickup.setBounds(286, 89, 179, 20);
		pnlSelectHardware.add(cmbBoxBridgePickup);
		
		JComboBox cmbBoxKnobs = new JComboBox();
		cmbBoxKnobs.setModel(new DefaultComboBoxModel(new String[] {"Top Hat", "Speed", "Dome", "Jazz", "Chicken Head"}));
		cmbBoxKnobs.setBounds(286, 114, 179, 20);
		pnlSelectHardware.add(cmbBoxKnobs);
		
		JComboBox cmbBoxBridge = new JComboBox();
		cmbBoxBridge.setModel(new DefaultComboBoxModel(new String[] {"Stop Tail", "Floyd Rose", "Hipshot", "Vibrato"}));
		cmbBoxBridge.setBounds(286, 139, 179, 20);
		pnlSelectHardware.add(cmbBoxBridge);
		
		JComboBox cmbBoxTuners = new JComboBox();
		cmbBoxTuners.setModel(new DefaultComboBoxModel(new String[] {"Locking", "Vintage", "Open Gear", "Hipshot Locking", "Trim-Lok"}));
		cmbBoxTuners.setBounds(286, 164, 179, 20);
		pnlSelectHardware.add(cmbBoxTuners);
		
		JButton btnNewButton = new JButton("Create Hardware");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtHardwareID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				String neckPickup = (String)cmbBoxNeckPickup.getSelectedItem();
				String middlePickup = (String)cmbBoxMiddlePickup.getSelectedItem();
				String bridgePickup = (String)cmbBoxBridgePickup.getSelectedItem();
				String knobs = (String)cmbBoxKnobs.getSelectedItem();
				String bridge = (String)cmbBoxBridge.getSelectedItem();
				String tuners = (String)cmbBoxTuners.getSelectedItem();
				
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nNeck Pickup: " + neckPickup + "\nMiddle Pickup: " + middlePickup
						+ "\nBridge Pickup: " + bridgePickup + "\nKnobs: " + knobs + "\nBridge: "
						+ bridge + "\nTuners: " + tuners, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0)
				{
					
					Hardware create = new Hardware(ID, neckPickup , middlePickup, bridgePickup, knobs, bridge, tuners); //creates Hardware object
					
					try
					{
						OracleJDBC.writeHardware(create); //passes to method that writes hardware to database
					} 
					catch (SQLException e1)
					{
						
									
						if (e1.getErrorCode() == 00001) //sql error for PK constraint violation
							JOptionPane.showMessageDialog(null, "Hardware ID already in use",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else if (e1.getErrorCode() == 1438) //sql error for hardware ID too long
							JOptionPane.showMessageDialog(null, "Hardware ID to long, must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Hardware Created",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not create Hardware",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				
				
			}
		});
		btnNewButton.setBounds(41, 192, 180, 56);
		pnlSelectHardware.add(btnNewButton);
		
		JButton btnProductMenu_1 = new JButton("Product Menu");
		btnProductMenu_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmHardware.dispose();
			}
		});
		btnProductMenu_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProductMenu_1.setBounds(285, 192, 180, 56);
		pnlSelectHardware.add(btnProductMenu_1);
		
		JPanel pnlUpdateHardware = new JPanel();
		tabbedPane.addTab("Update Hardware", null, pnlUpdateHardware, null);
		pnlUpdateHardware.setLayout(null);
		
		JLabel lblHardwareIdFor = new JLabel("Hardware ID For Update:");
		lblHardwareIdFor.setBounds(42, 17, 180, 14);
		pnlUpdateHardware.add(lblHardwareIdFor);
		
		JLabel lblUpdateNeckPickup = new JLabel("Update Neck Pickup:");
		lblUpdateNeckPickup.setBounds(42, 42, 180, 14);
		pnlUpdateHardware.add(lblUpdateNeckPickup);
		
		JLabel lblUpdateMiddlePickup = new JLabel("Update Middle Pickup:");
		lblUpdateMiddlePickup.setBounds(42, 67, 180, 14);
		pnlUpdateHardware.add(lblUpdateMiddlePickup);
		
		JLabel lblUpdateBridgePickup = new JLabel("Update Bridge Pickup:");
		lblUpdateBridgePickup.setBounds(42, 92, 180, 14);
		pnlUpdateHardware.add(lblUpdateBridgePickup);
		
		JLabel lblUpdateTonevolKnobs = new JLabel("Update Tone/Vol Knobs:");
		lblUpdateTonevolKnobs.setBounds(42, 117, 180, 14);
		pnlUpdateHardware.add(lblUpdateTonevolKnobs);
		
		JLabel lblUpdateBridge = new JLabel("Update Bridge:");
		lblUpdateBridge.setBounds(41, 142, 180, 14);
		pnlUpdateHardware.add(lblUpdateBridge);
		
		JLabel lblUpdateTuners = new JLabel("Update Tuners:");
		lblUpdateTuners.setBounds(41, 167, 180, 14);
		pnlUpdateHardware.add(lblUpdateTuners);
		
		
		
		JButton btnProductMenu = new JButton("Product Menu");
		btnProductMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmHardware.dispose();
			}
		});
		btnProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProductMenu.setBounds(285, 192, 180, 56);
		pnlUpdateHardware.add(btnProductMenu);
		
		JComboBox cmbBoxUpdateTuners = new JComboBox();
		cmbBoxUpdateTuners.setModel(new DefaultComboBoxModel(new String[] {"Locking", "Vintage", "Open Gear", "Hipshot Locking", "Trim-Lok"}));
		cmbBoxUpdateTuners.setBounds(286, 164, 179, 20);
		pnlUpdateHardware.add(cmbBoxUpdateTuners);
		
		JComboBox cmbBoxUpdateBridge = new JComboBox();
		cmbBoxUpdateBridge.setModel(new DefaultComboBoxModel(new String[] {"Stop Tail", "Floyd Rose", "Hipshot", "Vibrato"}));
		cmbBoxUpdateBridge.setBounds(285, 139, 179, 20);
		pnlUpdateHardware.add(cmbBoxUpdateBridge);
		
		JComboBox cmbBoxUpdateKnobs = new JComboBox();
		cmbBoxUpdateKnobs.setModel(new DefaultComboBoxModel(new String[] {"Top Hat", "Speed", "Dome", "Jazz", "Chicken Head"}));
		cmbBoxUpdateKnobs.setBounds(286, 114, 179, 20);
		pnlUpdateHardware.add(cmbBoxUpdateKnobs);
		
		JComboBox cmbBoxUpdateBridgePickup = new JComboBox();
		cmbBoxUpdateBridgePickup.setModel(new DefaultComboBoxModel(new String[] {"No Bridge Pickup", "EMG-60", "EMG-80", "EMG-81\t\t\t\t\t\t", "EMG H4", "Seymore Duncan Livewire", "Seymore Duncan AHB", "Seymore Duncan Blackouts", "Seymore Duncan Invader", "Gibson 57 classic", "DiMarzio Gravity Storm", "Lace Sensor Emerald", "Seymore Duncan Zephyr", "DiMarzio True Velvet", "DiMarzio Red Velvet", "DiMarzio Injector", "EMG SA", "DiMarzio Twang King", "Fender Fat 50s", "Fender N3 Noiseless"}));
		cmbBoxUpdateBridgePickup.setBounds(286, 89, 179, 20);
		pnlUpdateHardware.add(cmbBoxUpdateBridgePickup);
		
		JComboBox cmbBoxUpdateMiddlePickup = new JComboBox();
		cmbBoxUpdateMiddlePickup.setModel(new DefaultComboBoxModel(new String[] {"No Middle Pickup", "EMG-60", "EMG-80", "EMG-81\t\t\t\t\t\t", "EMG H4", "Seymore Duncan Livewire", "Seymore Duncan AHB", "Seymore Duncan Blackouts", "Seymore Duncan Invader", "Gibson 57 classic", "DiMarzio Gravity Storm", "Lace Sensor Emerald", "Seymore Duncan Zephyr", "DiMarzio True Velvet", "DiMarzio Red Velvet", "DiMarzio Injector", "EMG SA", "DiMarzio Twang King", "Fender Fat 50s", "Fender N3 Noiseless"}));
		cmbBoxUpdateMiddlePickup.setBounds(285, 64, 179, 20);
		pnlUpdateHardware.add(cmbBoxUpdateMiddlePickup);
		
		JComboBox cmbBoxUpdateNeckPickup = new JComboBox();
		cmbBoxUpdateNeckPickup.setModel(new DefaultComboBoxModel(new String[] {"No Neck Pickup", "EMG-60", "EMG-80", "EMG-81\t\t\t\t\t\t", "EMG H4", "Seymore Duncan Livewire", "Seymore Duncan AHB", "Seymore Duncan Blackouts", "Seymore Duncan Invader", "Gibson 57 classic", "DiMarzio Gravity Storm", "Lace Sensor Emerald", "Seymore Duncan Zephyr", "DiMarzio True Velvet", "DiMarzio Red Velvet", "DiMarzio Injector", "EMG SA", "DiMarzio Twang King", "Fender Fat 50s", "Fender N3 Noiseless"}));
		cmbBoxUpdateNeckPickup.setBounds(286, 39, 179, 20);
		pnlUpdateHardware.add(cmbBoxUpdateNeckPickup);
		
		txtUpdateHardwareID = new JTextField();
		txtUpdateHardwareID.setColumns(10);
		txtUpdateHardwareID.setBounds(285, 14, 96, 20);
		pnlUpdateHardware.add(txtUpdateHardwareID);
		
		JButton btnUpdateHardware = new JButton("Update Hardware");
		btnUpdateHardware.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtUpdateHardwareID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				String neckPickup = (String)cmbBoxUpdateNeckPickup.getSelectedItem();
				String middlePickup = (String)cmbBoxUpdateMiddlePickup.getSelectedItem();
				String bridgePickup = (String)cmbBoxUpdateBridgePickup.getSelectedItem();
				String knobs = (String)cmbBoxUpdateKnobs.getSelectedItem();
				String bridge = (String)cmbBoxUpdateBridge.getSelectedItem();
				String tuners = (String)cmbBoxUpdateTuners.getSelectedItem();
				
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nNeck Pickup: " + neckPickup + "\nMiddle Pickup: " + middlePickup
						+ "\nBridge Pickup: " + bridgePickup + "\nKnobs: " + knobs + "\nBridge: "
						+ bridge + "\nTuners: " + tuners, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0)
				{
					
					Hardware update = new Hardware(ID, neckPickup , middlePickup, bridgePickup, knobs, bridge, tuners); //creates hardware object
					
					try
					{
						OracleJDBC.updateHardware(update); //passes to method that writes hardware to database
					} 
					catch (SQLException e1)
					{
						
									
						if (e1.getErrorCode() == 00001) //sql error for PK constraint violation
							JOptionPane.showMessageDialog(null, "Hardware ID already in use",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else if (e1.getErrorCode() == 1438) //sql error for hardware ID too long
							JOptionPane.showMessageDialog(null, "Hardware ID to long, must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Hardware Updated",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not update Hardware",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				
				
			}
		});
		btnUpdateHardware.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateHardware.setBounds(41, 192, 180, 56);
		pnlUpdateHardware.add(btnUpdateHardware);
		btnUpdateHardware.setEnabled(false);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try
				{
					ID = Integer.parseInt(txtUpdateHardwareID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				int returnID = 0;
				String neckPickup = null;
				String middlePickup = null;
				String bridgePickup = null;
				String knobs = null;
				String bridge = null;
				String tuners = null;
				
				try
				{
					returnID = OracleJDBC.readHardwareID(ID);
					neckPickup = OracleJDBC.readNeckPickup(ID);
					middlePickup = OracleJDBC.readMiddlePickup(ID);
					bridgePickup = OracleJDBC.readBridgePickup(ID);
					knobs = OracleJDBC.readKnobs(ID);
					bridge = OracleJDBC.readBridge(ID);
					tuners = OracleJDBC.readTuners(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Hardware Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnID != 0) //checks if hardware exists
				{
				
					cmbBoxUpdateNeckPickup.setSelectedItem(neckPickup);
					cmbBoxUpdateMiddlePickup.setSelectedItem(middlePickup);
					cmbBoxUpdateBridgePickup.setSelectedItem(bridgePickup);
					cmbBoxUpdateKnobs.setSelectedItem(knobs);
					cmbBoxUpdateBridge.setSelectedItem(bridge);
					cmbBoxUpdateTuners.setSelectedItem(tuners);
					
					btnUpdateHardware.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Hardware Info, Hardware ID " + ID +" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					
					return;
				}
			}
		});
		btnEnter.setBounds(391, 13, 74, 23);
		pnlUpdateHardware.add(btnEnter);
		
		JPanel pnlReviewHardware = new JPanel();
		tabbedPane.addTab("Review Hardware", null, pnlReviewHardware, null);
		pnlReviewHardware.setLayout(null);
		
		JButton btnReviewProductMenu = new JButton("Product Menu");
		btnReviewProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReviewProductMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmHardware.dispose();
			}
		});
		btnReviewProductMenu.setBounds(264, 36, 198, 56);
		pnlReviewHardware.add(btnReviewProductMenu);
		
		JLabel lblReviewTuners = new JLabel("Tuners:");
		lblReviewTuners.setBounds(45, 228, 180, 14);
		pnlReviewHardware.add(lblReviewTuners);
		
		JLabel lblReviewBridge = new JLabel("Bridge:");
		lblReviewBridge.setBounds(45, 203, 180, 14);
		pnlReviewHardware.add(lblReviewBridge);
		
		JLabel lblReviewTonevolKnobs = new JLabel("Tone/Vol Knobs:");
		lblReviewTonevolKnobs.setBounds(45, 178, 180, 14);
		pnlReviewHardware.add(lblReviewTonevolKnobs);
		
		JLabel lblReviewBridgePickup = new JLabel("Bridge Pickup:");
		lblReviewBridgePickup.setBounds(45, 153, 180, 14);
		pnlReviewHardware.add(lblReviewBridgePickup);
		
		JLabel lblReviewMiddlePickup = new JLabel("Middle Pickup:");
		lblReviewMiddlePickup.setBounds(45, 128, 180, 14);
		pnlReviewHardware.add(lblReviewMiddlePickup);
		
		JLabel lblReviewNeckPickup = new JLabel("Neck Pickup:");
		lblReviewNeckPickup.setBounds(45, 103, 180, 14);
		pnlReviewHardware.add(lblReviewNeckPickup);
		
		JLabel lblUpdateHardwareId = new JLabel("Hardware ID For Update:");
		lblUpdateHardwareId.setBounds(45, 14, 198, 14);
		pnlReviewHardware.add(lblUpdateHardwareId);
		
		txtReviewHardwareID = new JTextField();
		txtReviewHardwareID.setColumns(10);
		txtReviewHardwareID.setBounds(265, 11, 197, 20);
		pnlReviewHardware.add(txtReviewHardwareID);
		
		JLabel lblShowNeckPickup = new JLabel("");
		lblShowNeckPickup.setBounds(264, 103, 198, 14);
		pnlReviewHardware.add(lblShowNeckPickup);
		
		JLabel lblShowMiddlePickup = new JLabel("");
		lblShowMiddlePickup.setBounds(264, 128, 198, 14);
		pnlReviewHardware.add(lblShowMiddlePickup);
		
		JLabel lblShowBridgePickup = new JLabel("");
		lblShowBridgePickup.setBounds(264, 153, 198, 14);
		pnlReviewHardware.add(lblShowBridgePickup);
		
		JLabel lblShowKnobs = new JLabel("");
		lblShowKnobs.setBounds(264, 178, 198, 14);
		pnlReviewHardware.add(lblShowKnobs);
		
		JLabel lblShowBridge = new JLabel("");
		lblShowBridge.setBounds(264, 203, 198, 14);
		pnlReviewHardware.add(lblShowBridge);
		
		JLabel lblShowTuners = new JLabel("");
		lblShowTuners.setBounds(264, 228, 198, 14);
		pnlReviewHardware.add(lblShowTuners);
		
		JButton btnShowInformation = new JButton("Show Info");
		btnShowInformation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtReviewHardwareID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				int returnID = 0;
				String neckPickup = null;
				String middlePickup = null;
				String bridgePickup = null;
				String knobs = null;
				String bridge = null;
				String tuners = null;
				
				try
				{
					returnID = OracleJDBC.readHardwareID(ID);
					neckPickup = OracleJDBC.readNeckPickup(ID);
					middlePickup = OracleJDBC.readMiddlePickup(ID);
					bridgePickup = OracleJDBC.readBridgePickup(ID);
					knobs = OracleJDBC.readKnobs(ID);
					bridge = OracleJDBC.readBridge(ID);
					tuners = OracleJDBC.readTuners(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Hardware Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnID != 0) //checks if Hardware exists
				{
				
					lblShowNeckPickup.setText(neckPickup);
					lblShowMiddlePickup.setText(middlePickup);
					lblShowBridgePickup.setText(bridgePickup);
					lblShowKnobs.setText(knobs);
					lblShowBridge.setText(bridge);
					lblShowTuners.setText(tuners);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Hardware Info, Hardware ID " + ID +" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					
					return;
				}
				
				
			}
		});
		btnShowInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShowInformation.setBounds(45, 36, 198, 56);
		pnlReviewHardware.add(btnShowInformation);
		
		
		
		JPanel pnlDeleteHardware = new JPanel();
		tabbedPane.addTab("Delete Hardware", null, pnlDeleteHardware, null);
		pnlDeleteHardware.setLayout(null);
		
		JButton btnDeleteHardware = new JButton("Delete Hardware");
		btnDeleteHardware.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtDeleteHardwareID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				int returnID = 0;
				String neckPickup = null;
				String middlePickup = null;
				String bridgePickup = null;
				String knobs = null;
				String bridge = null;
				String tuners = null;
				
				try
				{
					returnID = OracleJDBC.readHardwareID(ID);
					neckPickup = OracleJDBC.readNeckPickup(ID);
					middlePickup = OracleJDBC.readMiddlePickup(ID);
					bridgePickup = OracleJDBC.readBridgePickup(ID);
					knobs = OracleJDBC.readKnobs(ID);
					bridge = OracleJDBC.readBridge(ID);
					tuners = OracleJDBC.readTuners(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Hardware Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if (returnID == 0)
				{
					JOptionPane.showMessageDialog(null, "Hardware with ID " + ID + " does not exist!",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
				}
				else
				{
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the following hardware?"
							+ "\nID: " + returnID + "\nNeck Pickup: " + neckPickup + "\nBridge Pickup: " + middlePickup
							+ "\nBridge pickup: " + bridgePickup + "\nKnobs: " + knobs + "\nBridge: "
							+ bridge+ "\nTuners: " + tuners, "Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					
					if (choice == 0)
					{
						try
						{
							OracleJDBC.deleteHardware(ID);
						} 
						catch (SQLException e1)
						{
							JOptionPane.showMessageDialog(null, "Couldn't Delete Hardware", "Error", JOptionPane.ERROR_MESSAGE, null);
						}
						
						JOptionPane.showMessageDialog(null, "Hardware Deleted", "Success", JOptionPane.INFORMATION_MESSAGE, null);
					}
					else
					{
						return;
					}
				}
			}
		});
		btnDeleteHardware.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteHardware.setBounds(45, 36, 198, 56);
		pnlDeleteHardware.add(btnDeleteHardware);
		
		JButton btnDeleteProductMenu = new JButton("Product Menu");
		btnDeleteProductMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmHardware.dispose();
			}
		});
		btnDeleteProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteProductMenu.setBounds(264, 36, 198, 56);
		pnlDeleteHardware.add(btnDeleteProductMenu);
		
		txtDeleteHardwareID = new JTextField();
		txtDeleteHardwareID.setColumns(10);
		txtDeleteHardwareID.setBounds(265, 11, 197, 20);
		pnlDeleteHardware.add(txtDeleteHardwareID);
		
		JLabel lblDeleteHardwareID = new JLabel("Hardware ID To Delete:");
		lblDeleteHardwareID.setBounds(45, 14, 180, 14);
		pnlDeleteHardware.add(lblDeleteHardwareID);
	}
}
