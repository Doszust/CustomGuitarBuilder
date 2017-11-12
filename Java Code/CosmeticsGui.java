/**
 * @author Dylan Oszust
 * 3/12/2017
 * This is the graphical user interface to manage cosmetics
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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CosmeticsGui
{

	private JFrame frmCosmetics;
	private JTextField txtCosmeticID;
	private JTextField txtUpdateCosmeticID;
	private JTextField txtReviewCosmeticID;
	private JTextField txtDeleteCosmeticID;
	private final ButtonGroup selectFretMarker = new ButtonGroup();
	private final ButtonGroup updateFretMarker = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void createCosmeticsGUI()
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					CosmeticsGui window = new CosmeticsGui();
					window.frmCosmetics.setVisible(true);
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
	public CosmeticsGui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmCosmetics = new JFrame();
		frmCosmetics.setResizable(false);
		frmCosmetics.setTitle("Guitar Builder - Cosmetics");
		frmCosmetics.setBounds(100, 100, 561, 366);
		frmCosmetics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCosmetics.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmCosmetics.setLocation(dim.width/2-frmCosmetics.getSize().width/2, dim.height/2-frmCosmetics.getSize().height/2);
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 0, 555, 337);
		frmCosmetics.getContentPane().add(tabbedPane);
		
		JPanel pnlSelectCosmetics = new JPanel();
		tabbedPane.addTab("Select Cosmetics", null, pnlSelectCosmetics, null);
		pnlSelectCosmetics.setLayout(null);
		
		JLabel lblCosmeticId = new JLabel("Cosmetic ID:");
		lblCosmeticId.setBounds(10, 14, 186, 14);
		pnlSelectCosmetics.add(lblCosmeticId);
		
		JLabel lblBodyColor = new JLabel("Body Color:");
		lblBodyColor.setBounds(10, 39, 186, 14);
		pnlSelectCosmetics.add(lblBodyColor);
		
		JLabel lblNeckColor = new JLabel("Neck Color:");
		lblNeckColor.setBounds(10, 64, 186, 14);
		pnlSelectCosmetics.add(lblNeckColor);
		
		JLabel lblHardwareColor = new JLabel("Hardware Color:");
		lblHardwareColor.setBounds(10, 89, 186, 14);
		pnlSelectCosmetics.add(lblHardwareColor);
		
		JLabel lblBindingColor = new JLabel("Binding Color:");
		lblBindingColor.setBounds(10, 114, 186, 14);
		pnlSelectCosmetics.add(lblBindingColor);
		
		JLabel lblFretMarkers = new JLabel("Fret Markers:");
		lblFretMarkers.setBounds(10, 139, 186, 14);
		pnlSelectCosmetics.add(lblFretMarkers);
		
		JLabel lblMarkerType = new JLabel("Marker Type:");
		lblMarkerType.setBounds(10, 164, 186, 14);
		pnlSelectCosmetics.add(lblMarkerType);
		
		JLabel lblMarkerColor = new JLabel("Marker Color:");
		lblMarkerColor.setBounds(10, 189, 186, 14);
		pnlSelectCosmetics.add(lblMarkerColor);
		
		txtCosmeticID = new JTextField();
		txtCosmeticID.setBounds(305, 11, 235, 20);
		pnlSelectCosmetics.add(txtCosmeticID);
		txtCosmeticID.setColumns(10);
		
		JComboBox cmbBoxBodyColor = new JComboBox();
		cmbBoxBodyColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "Red", "Blue", "Silver", "Gold", "Green", "White", "Sunburst"}));
		cmbBoxBodyColor.setBounds(305, 36, 235, 20);
		pnlSelectCosmetics.add(cmbBoxBodyColor);
		
		JComboBox cmbBoxNeckColor = new JComboBox();
		cmbBoxNeckColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "Red", "Blue", "Silver", "Gold", "Green", "White", "Sunburst"}));
		cmbBoxNeckColor.setBounds(305, 61, 235, 20);
		pnlSelectCosmetics.add(cmbBoxNeckColor);
		
		JComboBox cmbBoxHardwareColor = new JComboBox();
		cmbBoxHardwareColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "Silver", "Gold", "White"}));
		cmbBoxHardwareColor.setBounds(305, 86, 235, 20);
		pnlSelectCosmetics.add(cmbBoxHardwareColor);
		
		JComboBox cmbBoxBindingColor = new JComboBox();
		cmbBoxBindingColor.setModel(new DefaultComboBoxModel(new String[] {"No Binding", "Black", "Red", "Blue", "Silver", "Gold", "Green", "White"}));
		cmbBoxBindingColor.setBounds(305, 111, 235, 20);
		pnlSelectCosmetics.add(cmbBoxBindingColor);
		
		JComboBox cmbBoxMarkerType = new JComboBox();
		cmbBoxMarkerType.setModel(new DefaultComboBoxModel(new String[] {"Dots", "Diamonds", "Cross", "Trapezoid", "Rectangle", "Wedge"}));
		cmbBoxMarkerType.setBounds(305, 161, 235, 20);
		pnlSelectCosmetics.add(cmbBoxMarkerType);
		
		JComboBox cmbBoxMarkerColor = new JComboBox();
		cmbBoxMarkerColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "Red", "Blue", "Silver", "Gold", "Pearl", "White"}));
		cmbBoxMarkerColor.setBounds(305, 186, 235, 20);
		pnlSelectCosmetics.add(cmbBoxMarkerColor);
		
		JRadioButton radbtnMarkersNo = new JRadioButton("No");
		selectFretMarker.add(radbtnMarkersNo);
		radbtnMarkersNo.setBounds(360, 135, 53, 23);
		pnlSelectCosmetics.add(radbtnMarkersNo);
		
		JRadioButton rdbtnMarkersYes = new JRadioButton("Yes");
		selectFretMarker.add(rdbtnMarkersYes);
		rdbtnMarkersYes.setBounds(305, 135, 53, 23);
		pnlSelectCosmetics.add(rdbtnMarkersYes);
		
		JButton btnNewButton = new JButton("Create Cosmetics");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtCosmeticID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				String bodyColor = (String)cmbBoxBodyColor.getSelectedItem();
				String neckColor = (String)cmbBoxNeckColor.getSelectedItem();
				String hardwareColor = (String)cmbBoxHardwareColor.getSelectedItem();
				String bindingColor = (String)cmbBoxBindingColor.getSelectedItem();
				char fretMarkers;
				String markerType = (String)cmbBoxMarkerType.getSelectedItem();
				String markerColor = (String)cmbBoxMarkerColor.getSelectedItem();
				
				if(rdbtnMarkersYes.isSelected())
					fretMarkers = 'Y';
				else
				{
					fretMarkers = 'N';
					markerType = null;
					markerColor = null;
				}
				
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nBody Color: " + bodyColor + "\nNeck Color: " + neckColor
						+ "\nHardware Color: " + hardwareColor + "\nBinding Color: " + bindingColor + "\nfretMarkers: "
						+ fretMarkers + "\nMarker Type: " + markerType + "\nMarker Color: " + markerColor, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0)
				{
					
					Cosmetics create = new Cosmetics(ID, bodyColor, neckColor, hardwareColor, bindingColor, fretMarkers, markerType, markerColor); //creates Cosmetic object
					
					try
					{
						OracleJDBC.writeCosmetic(create); //passes to method that writes hardware to database
					} 
					catch (SQLException e1)
					{
						
									
						if (e1.getErrorCode() == 00001) //sql error for PK constraint violation
							JOptionPane.showMessageDialog(null, "Cosmetic ID already in use",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else if (e1.getErrorCode() == 1438) //sql error for hardware ID too long
							JOptionPane.showMessageDialog(null, "Cosmetic ID to long, must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Cosmetics Created",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not create Cosmetics",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 214, 235, 64);
		pnlSelectCosmetics.add(btnNewButton);
		
		JButton btnProductMenu = new JButton("Product Menu");
		btnProductMenu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmCosmetics.dispose();
			}
		});
		btnProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProductMenu.setBounds(305, 214, 235, 64);
		pnlSelectCosmetics.add(btnProductMenu);
		
		JPanel pnlUpdateCosmetics = new JPanel();
		tabbedPane.addTab("Update Cosmetics", null, pnlUpdateCosmetics, null);
		pnlUpdateCosmetics.setLayout(null);
		
		
		
		
		JLabel lblUpdateMarkerColor = new JLabel("Update Marker Color:");
		lblUpdateMarkerColor.setBounds(10, 189, 186, 14);
		pnlUpdateCosmetics.add(lblUpdateMarkerColor);
		
		JLabel lblUpdateMarkerType = new JLabel("Update Marker Type:");
		lblUpdateMarkerType.setBounds(10, 164, 186, 14);
		pnlUpdateCosmetics.add(lblUpdateMarkerType);
		
		JLabel lblUpdateFretMarkers = new JLabel("Update Fret Markers:");
		lblUpdateFretMarkers.setBounds(10, 139, 186, 14);
		pnlUpdateCosmetics.add(lblUpdateFretMarkers);
		
		JLabel lblUpdateBindingColor = new JLabel("Update Binding Color:");
		lblUpdateBindingColor.setBounds(10, 114, 186, 14);
		pnlUpdateCosmetics.add(lblUpdateBindingColor);
		
		JLabel lblUpdateHardwareColor = new JLabel("Update Hardware Color:");
		lblUpdateHardwareColor.setBounds(10, 89, 186, 14);
		pnlUpdateCosmetics.add(lblUpdateHardwareColor);
		
		JLabel lblUpdateNeckColor = new JLabel("Update Neck Color:");
		lblUpdateNeckColor.setBounds(10, 64, 186, 14);
		pnlUpdateCosmetics.add(lblUpdateNeckColor);
		
		JLabel lblUpdateBodyColor = new JLabel("Update Body Color:");
		lblUpdateBodyColor.setBounds(10, 39, 186, 14);
		pnlUpdateCosmetics.add(lblUpdateBodyColor);
		
		JLabel lblUpdateCosmeticID = new JLabel("Cosmetic ID For Update:");
		lblUpdateCosmeticID.setBounds(10, 14, 186, 14);
		pnlUpdateCosmetics.add(lblUpdateCosmeticID);
		
		txtUpdateCosmeticID = new JTextField();
		txtUpdateCosmeticID.setColumns(10);
		txtUpdateCosmeticID.setBounds(305, 11, 152, 20);
		pnlUpdateCosmetics.add(txtUpdateCosmeticID);
		
		JComboBox cmbBoxUpdateBodyColor = new JComboBox();
		cmbBoxUpdateBodyColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "Red", "Blue", "Silver", "Gold", "Green", "White", "Sunburst"}));
		cmbBoxUpdateBodyColor.setBounds(305, 36, 234, 20);
		pnlUpdateCosmetics.add(cmbBoxUpdateBodyColor);
		
		JComboBox cmbBoxUpdateNeckColor = new JComboBox();
		cmbBoxUpdateNeckColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "Red", "Blue", "Silver", "Gold", "Green", "White", "Sunburst"}));
		cmbBoxUpdateNeckColor.setBounds(305, 61, 234, 20);
		pnlUpdateCosmetics.add(cmbBoxUpdateNeckColor);
		
		JComboBox cmbBoxUpdateHardwareColor = new JComboBox();
		cmbBoxUpdateHardwareColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "Silver", "Gold", "White"}));
		cmbBoxUpdateHardwareColor.setBounds(305, 86, 234, 20);
		pnlUpdateCosmetics.add(cmbBoxUpdateHardwareColor);
		
		JComboBox cmbBoxUpdateBindingColor = new JComboBox();
		cmbBoxUpdateBindingColor.setModel(new DefaultComboBoxModel(new String[] {"No Binding", "Black", "Red", "Blue", "Silver", "Gold", "Green", "White"}));
		cmbBoxUpdateBindingColor.setBounds(305, 111, 234, 20);
		pnlUpdateCosmetics.add(cmbBoxUpdateBindingColor);
		
		JComboBox cmbBoxUpdateMarkerType = new JComboBox();
		cmbBoxUpdateMarkerType.setModel(new DefaultComboBoxModel(new String[] {"Dots", "Diamonds", "Cross", "Trapezoid", "Rectangle", "Wedge"}));
		cmbBoxUpdateMarkerType.setBounds(305, 161, 234, 20);
		pnlUpdateCosmetics.add(cmbBoxUpdateMarkerType);
		
		JComboBox cmbBoxUpdateMarkerColor = new JComboBox();
		cmbBoxUpdateMarkerColor.setModel(new DefaultComboBoxModel(new String[] {"Black", "Red", "Blue", "Silver", "Gold", "Pearl", "White"}));
		cmbBoxUpdateMarkerColor.setBounds(305, 186, 234, 20);
		pnlUpdateCosmetics.add(cmbBoxUpdateMarkerColor);
		
		JButton btnUpdateProductMenu = new JButton("Product Menu");
		btnUpdateProductMenu.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmCosmetics.dispose();
			}
		});
		btnUpdateProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateProductMenu.setBounds(305, 214, 235, 64);
		pnlUpdateCosmetics.add(btnUpdateProductMenu);
		
		JRadioButton rdbtnUpdateMarkerYes = new JRadioButton("Yes");
		rdbtnUpdateMarkerYes.setSelected(true);
		updateFretMarker.add(rdbtnUpdateMarkerYes);
		rdbtnUpdateMarkerYes.setBounds(305, 135, 53, 23);
		pnlUpdateCosmetics.add(rdbtnUpdateMarkerYes);
		
		JRadioButton rdbtnUpdateMarkerNo = new JRadioButton("No");
		updateFretMarker.add(rdbtnUpdateMarkerNo);
		rdbtnUpdateMarkerNo.setBounds(360, 135, 53, 23);
		pnlUpdateCosmetics.add(rdbtnUpdateMarkerNo);
		
		JButton btnUpdateCosmetics = new JButton("Update Cosmetics");
		btnUpdateCosmetics.setEnabled(false);
		btnUpdateCosmetics.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtUpdateCosmeticID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				String bodyColor = (String)cmbBoxUpdateBodyColor.getSelectedItem();
				String neckColor = (String)cmbBoxUpdateNeckColor.getSelectedItem();
				String hardwareColor = (String)cmbBoxUpdateHardwareColor.getSelectedItem();
				String bindingColor = (String)cmbBoxUpdateBindingColor.getSelectedItem();
				char fretMarkers;
				String markerType = (String)cmbBoxUpdateMarkerType.getSelectedItem();
				String markerColor = (String)cmbBoxUpdateMarkerColor.getSelectedItem();
				
				if(rdbtnUpdateMarkerYes.isSelected())
					fretMarkers = 'Y';
				else
				{
					fretMarkers = 'N';
					markerType = null;
					markerColor = null;
				}
				
				int choice = JOptionPane.showConfirmDialog(null, "Is The Following Information Correct?"
						+ "\nID: " + ID + "\nBody Color: " + bodyColor + "\nNeck Color: " + neckColor
						+ "\nHardware Color: " + hardwareColor + "\nBinding Color: " + bindingColor + "\nfretMarkers: "
						+ fretMarkers + "\nMarker Type: " + markerType + "\nMarker Color: " + markerColor, "Confirmation",
						JOptionPane.YES_NO_OPTION);
				
				if(choice == 0)
				{
					
					Cosmetics update = new Cosmetics(ID, bodyColor, neckColor, hardwareColor, bindingColor, fretMarkers, markerType, markerColor); //creates Cosmetic object
					
					try
					{
						OracleJDBC.updateCosmetic(update); //passes to method that writes hardware to database
					} 
					catch (SQLException e1)
					{
						
									
						if (e1.getErrorCode() == 00001) //sql error for PK constraint violation
							JOptionPane.showMessageDialog(null, "Cosmetic ID already in use",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else if (e1.getErrorCode() == 1438) //sql error for Cosmetic ID too long
							JOptionPane.showMessageDialog(null, "Cosmetic ID to long, must be 5 digits or less",
		                            "Error", JOptionPane.ERROR_MESSAGE, null);
						else //unaccounted for error (should not happen)
							e1.printStackTrace();
						
						return;
					}
					
					JOptionPane.showMessageDialog(null, "Cosmetics Updated",
	                        "Success", JOptionPane.INFORMATION_MESSAGE, null);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Unresolved Error, Could not update Cosmetics",
	                        "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
			}
		});
		btnUpdateCosmetics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateCosmetics.setBounds(10, 214, 235, 64);
		pnlUpdateCosmetics.add(btnUpdateCosmetics);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try
				{
					ID = Integer.parseInt(txtUpdateCosmeticID.getText());
				}
				catch(NumberFormatException e1) //ensures ID is integer
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				int returnID = 0;
				String bodyColor = null;
				String neckColor = null;
				String hardwareColor = null;
				String bindingColor = null;
				String fretMarkers = null;
				String markerType = null;
				String markerColor = null;
				
				try
				{
					returnID = OracleJDBC.readCosmeticID(ID);
					bodyColor = OracleJDBC.readBodyColor(ID);
					neckColor = OracleJDBC.readNeckColor(ID);
					hardwareColor = OracleJDBC.readHardwareColor(ID);
					bindingColor = OracleJDBC.readBindingColor(ID);
					fretMarkers = OracleJDBC.readFretMarkers(ID);
					markerType = OracleJDBC.readMarkerType(ID);
					markerColor = OracleJDBC.readMarkerColor(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Cosmetic Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnID != 0) //checks if hardware exists
				{
				
					cmbBoxUpdateBodyColor.setSelectedItem(bodyColor);
					cmbBoxUpdateNeckColor.setSelectedItem(neckColor);
					cmbBoxUpdateHardwareColor.setSelectedItem(hardwareColor);
					cmbBoxUpdateBindingColor.setSelectedItem(bindingColor);
					cmbBoxUpdateMarkerType.setSelectedItem(markerType);
					cmbBoxUpdateMarkerColor.setSelectedItem(markerColor);
					
					if(fretMarkers.equals("N"))
					{
						rdbtnUpdateMarkerNo.setSelected(true);
					}
					else
					{
						rdbtnUpdateMarkerYes.setSelected(true);
					}
					
					btnUpdateCosmetics.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Cosmetic Info, Cosmetic ID " + ID +" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					
					return;
				}
			}
		});
		btnEnter.setBounds(467, 10, 73, 23);
		pnlUpdateCosmetics.add(btnEnter);
		
		JPanel pnlReviewCosmetics = new JPanel();
		tabbedPane.addTab("Review Cosmetics", null, pnlReviewCosmetics, null);
		pnlReviewCosmetics.setLayout(null);
		
		JLabel lblReviewCosmeticID = new JLabel("Cosmetic ID For Review:");
		lblReviewCosmeticID.setBounds(10, 14, 186, 14);
		pnlReviewCosmetics.add(lblReviewCosmeticID);
		
		JLabel lblReviewBodyColor = new JLabel("Body Color:");
		lblReviewBodyColor.setBounds(10, 134, 186, 14);
		pnlReviewCosmetics.add(lblReviewBodyColor);
		
		JLabel lblReviewNeckColor = new JLabel("Neck Color:");
		lblReviewNeckColor.setBounds(10, 159, 186, 14);
		pnlReviewCosmetics.add(lblReviewNeckColor);
		
		JLabel lblReviewHardwareColor = new JLabel("Hardware Color:");
		lblReviewHardwareColor.setBounds(10, 184, 186, 14);
		pnlReviewCosmetics.add(lblReviewHardwareColor);
		
		JLabel lblRevieBindingColor = new JLabel("Binding Color:");
		lblRevieBindingColor.setBounds(10, 209, 186, 14);
		pnlReviewCosmetics.add(lblRevieBindingColor);
		
		JLabel lblReviewFretMarkers = new JLabel("Fret Markers:");
		lblReviewFretMarkers.setBounds(10, 234, 186, 14);
		pnlReviewCosmetics.add(lblReviewFretMarkers);
		
		JLabel lblReviewMarkerType = new JLabel("Marker Type:");
		lblReviewMarkerType.setBounds(10, 259, 186, 14);
		pnlReviewCosmetics.add(lblReviewMarkerType);
		
		JLabel lblReviewMarkerColor = new JLabel("Marker Color:");
		lblReviewMarkerColor.setBounds(10, 284, 186, 14);
		pnlReviewCosmetics.add(lblReviewMarkerColor);
		
		JLabel lblShowBodyColor = new JLabel("");
		lblShowBodyColor.setBounds(300, 133, 240, 14);
		pnlReviewCosmetics.add(lblShowBodyColor);
		
		JLabel lblShowNeckColor = new JLabel("");
		lblShowNeckColor.setBounds(300, 158, 240, 14);
		pnlReviewCosmetics.add(lblShowNeckColor);
		
		JLabel lblShowHardwareColor = new JLabel("");
		lblShowHardwareColor.setBounds(300, 183, 240, 14);
		pnlReviewCosmetics.add(lblShowHardwareColor);
		
		JLabel lblShowBindingColor = new JLabel("");
		lblShowBindingColor.setBounds(300, 208, 240, 14);
		pnlReviewCosmetics.add(lblShowBindingColor);
		
		JLabel lblShowFretMarkers = new JLabel("");
		lblShowFretMarkers.setBounds(300, 233, 240, 14);
		pnlReviewCosmetics.add(lblShowFretMarkers);
		
		JLabel lblShowMarkerType = new JLabel("");
		lblShowMarkerType.setBounds(300, 258, 240, 14);
		pnlReviewCosmetics.add(lblShowMarkerType);
		
		JLabel lblShowMarkerColor = new JLabel("");
		lblShowMarkerColor.setBounds(300, 284, 240, 14);
		pnlReviewCosmetics.add(lblShowMarkerColor);
		
		txtReviewCosmeticID = new JTextField();
		txtReviewCosmeticID.setColumns(10);
		txtReviewCosmeticID.setBounds(300, 11, 240, 20);
		pnlReviewCosmetics.add(txtReviewCosmeticID);
		
		JButton btnShowInfo = new JButton("Show Info");
		btnShowInfo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtReviewCosmeticID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				int returnID = 0;
				String bodyColor = null;
				String neckColor = null;
				String hardwareColor = null;
				String bindingColor = null;
				String fretMarkers = null;
				String markerType = null;
				String markerColor = null;
				
				try
				{
					returnID = OracleJDBC.readCosmeticID(ID);
					bodyColor = OracleJDBC.readBodyColor(ID);
					neckColor = OracleJDBC.readNeckColor(ID);
					hardwareColor = OracleJDBC.readHardwareColor(ID);
					bindingColor = OracleJDBC.readBindingColor(ID);
					fretMarkers = OracleJDBC.readFretMarkers(ID);
					markerType = OracleJDBC.readMarkerType(ID);
					markerColor = OracleJDBC.readMarkerColor(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Cosmetic Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if(returnID != 0) //checks if Hardware exists
				{
					lblShowBodyColor.setText(bodyColor);
					lblShowNeckColor.setText(neckColor);
					lblShowHardwareColor.setText(hardwareColor);
					lblShowBindingColor.setText(bindingColor);
					lblShowFretMarkers.setText(fretMarkers);
					lblShowMarkerType.setText(markerType);
					lblShowMarkerColor.setText(markerColor);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Cosmetic Info, Cosmetic ID " + ID +" does not exist",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					
					return;
				}
			}
		});
		btnShowInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowInfo.setBounds(10, 42, 240, 80);
		pnlReviewCosmetics.add(btnShowInfo);
		
		JButton btnReviewProductMenu = new JButton("Product Menu");
		btnReviewProductMenu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmCosmetics.dispose();
			}
		});
		btnReviewProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReviewProductMenu.setBounds(300, 42, 240, 80);
		pnlReviewCosmetics.add(btnReviewProductMenu);
		
		JPanel pnlDeleteCosmetics = new JPanel();
		tabbedPane.addTab("Delete Cosmetics", null, pnlDeleteCosmetics, null);
		pnlDeleteCosmetics.setLayout(null);
		
		JLabel lblDeleteID = new JLabel("Cosmetic ID For Delete:");
		lblDeleteID.setBounds(10, 14, 186, 14);
		pnlDeleteCosmetics.add(lblDeleteID);
		
		JButton btnDeleteCosmetics = new JButton("Delete Cosmetics");
		btnDeleteCosmetics.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int ID = 0;
				try 
				{
					ID = Integer.parseInt(txtDeleteCosmeticID.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "ID must consist of only numbers",
							"Error", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				
				int returnID = 0;
				String bodyColor = null;
				String neckColor = null;
				String hardwareColor = null;
				String bindingColor = null;
				String fretMarkers = null;
				String markerType = null;
				String markerColor = null;
				
				try
				{
					returnID = OracleJDBC.readCosmeticID(ID);
					bodyColor = OracleJDBC.readBodyColor(ID);
					neckColor = OracleJDBC.readNeckColor(ID);
					hardwareColor = OracleJDBC.readHardwareColor(ID);
					bindingColor = OracleJDBC.readBindingColor(ID);
					fretMarkers = OracleJDBC.readFretMarkers(ID);
					markerType = OracleJDBC.readMarkerType(ID);
					markerColor = OracleJDBC.readMarkerColor(ID);
					
				} 
				catch (SQLException e1)
				{
					JOptionPane.showMessageDialog(null, "Could Not Retrieve Cosmetic Info",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
					e1.printStackTrace();
				}
				
				if (returnID == 0)
				{
					JOptionPane.showMessageDialog(null, "Cosmetics with ID " + ID + " does not exist!",
                            "Error", JOptionPane.ERROR_MESSAGE, null);
				}
				else
				{
					int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the following cosmetics?"
							+ "\nID: " + ID + "\nBody Color: " + bodyColor + "\nNeck Color: " + neckColor
							+ "\nHardware Color: " + hardwareColor + "\nBinding Color: " + bindingColor + "\nfretMarkers: "
							+ fretMarkers + "\nMarker Type: " + markerType + "\nMarker Color: " + markerColor, "Confirmation",
							JOptionPane.YES_NO_OPTION);
					
					if(choice == 0)
					{
						try
						{
							OracleJDBC.deleteCosmetic(ID);
						}
						catch(SQLException e1)
						{
							JOptionPane.showMessageDialog(null, "Couldn't Delete Cosmetics", "Error", JOptionPane.ERROR_MESSAGE, null);
						}
						
						JOptionPane.showMessageDialog(null, "Cosmetics Deleted", "Success", JOptionPane.INFORMATION_MESSAGE, null);
					}
					
				}
				
				
			}
		});
		btnDeleteCosmetics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteCosmetics.setBounds(10, 42, 240, 80);
		pnlDeleteCosmetics.add(btnDeleteCosmetics);
		
		JButton btnDeleteProductMenu = new JButton("Product Menu");
		btnDeleteProductMenu.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Builder.createBuilderGui();
				frmCosmetics.dispose();
			}
		});
		btnDeleteProductMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteProductMenu.setBounds(300, 42, 240, 80);
		pnlDeleteCosmetics.add(btnDeleteProductMenu);
		
		txtDeleteCosmeticID = new JTextField();
		txtDeleteCosmeticID.setColumns(10);
		txtDeleteCosmeticID.setBounds(300, 11, 240, 20);
		pnlDeleteCosmetics.add(txtDeleteCosmeticID);
	}
}
