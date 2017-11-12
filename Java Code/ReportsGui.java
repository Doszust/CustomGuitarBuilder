/**
 * @author Dylan Oszust
 *  3/12/2017
 *  This class creates the Graphical User Interface that allows the user to retrieve reports from the database.
 */

package guitarApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;


public class ReportsGui
{
	
	private JFrame frmDatabaseViewport;
	/**
	 * Launch the application.
	 */
	public static void runReportsGUI()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ReportsGui window = new ReportsGui();
					window.frmDatabaseViewport.setVisible(true);
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
	public ReportsGui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmDatabaseViewport = new JFrame();
		frmDatabaseViewport.setTitle("Reports");
		frmDatabaseViewport.setBounds(100, 100, 786, 392);
		frmDatabaseViewport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatabaseViewport.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmDatabaseViewport.setLocation(dim.width/2-frmDatabaseViewport.getSize().width/2, dim.height/2-frmDatabaseViewport.getSize().height/2); //launches window in center of the screen.
		
		JLabel lblView = new JLabel("Select View");
		lblView.setBounds(10, 71, 87, 14);
		lblView.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmDatabaseViewport.getContentPane().add(lblView);
		
		JComboBox cmbBoxView = new JComboBox();
		cmbBoxView.setBounds(107, 70, 120, 20);
		cmbBoxView.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Neck", "Body", "Hardware", "Cosmetic", "Product", "Product Detailed", "Shipping Info"}));
		frmDatabaseViewport.getContentPane().add(cmbBoxView);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 750, 241);
		frmDatabaseViewport.getContentPane().add(scrollPane);
		
		JButton btnDisplay = new JButton("Display"); //reads info from database, and creates a table from it
		btnDisplay.setBounds(237, 69, 89, 23);
		btnDisplay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				String selection = (String) cmbBoxView.getSelectedItem();
				
				if(selection.equals("Product Detailed"))
				{
					try
					{
						JTable detail = OracleJDBC.displayDetailedContent();
						detail.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						scrollPane.setViewportView(detail);
					} 
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
				}
				else if(selection.equals("Shipping Info"))
				{
					try
					{
						JTable shipping = OracleJDBC.displayShippingContent();
						scrollPane.setViewportView(shipping);
					} 
					catch (SQLException e1)
					{ 
						e1.printStackTrace();
					}
				}
				else
					try
					{
						JTable table = OracleJDBC.displayContent(selection);
						scrollPane.setViewportView(table);
					} 
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
			}		
		});
		frmDatabaseViewport.getContentPane().add(btnDisplay);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GuitarBuilderMainMenu.createMainMenu();
				frmDatabaseViewport.dispose();
			}
		});
		btnMainMenu.setBounds(336, 69, 101, 23);
		frmDatabaseViewport.getContentPane().add(btnMainMenu);
		
		JComboBox cmbBoxPopulate = new JComboBox();
		cmbBoxPopulate.setModel(new DefaultComboBoxModel(new String[] {"Populate", "Unpopulate"}));
		cmbBoxPopulate.setBounds(459, 70, 155, 20);
		frmDatabaseViewport.getContentPane().add(cmbBoxPopulate);
		
		JButton btnGo = new JButton("Go"); //populates/unpopulates table
		btnGo.setEnabled(false);
		btnGo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				String populate = (String)cmbBoxPopulate.getSelectedItem();
				
				if(populate.equals("Populate")) //creates test data for each table to demonstrate report
				{
					try
					{
						for(int i = 0; i < 100; i++)
						{
							
								OracleJDBC.writeCustomer(new Customer(i,"test","test","0","test","test",'N'));
								OracleJDBC.writeNeck(new Neck(i,"test","test",0.0,0,"test"));
								OracleJDBC.writeHardware(new Hardware(i,"test","test","test","test","test","test"));
								OracleJDBC.writeBody(new Body(i,"test","test","test",'N','N'));
								OracleJDBC.writeCosmetic(new Cosmetics(i,"test","test","test","test",'N',"test","test"));
								OracleJDBC.writeProduct(new Product(i,i,i,i,i,i,'N'));	
						}
						JOptionPane.showMessageDialog(null, "Database Populated");
					}
					catch (SQLException e1)
					{
						JOptionPane.showMessageDialog(null, "Database Already Populated");
					}
					
				}
				else if(populate.equals("Unpopulate")) //deletes test data for report
				{
					try
					{
						for(int i = 0; i < 100; i++)
						{
								OracleJDBC.deleteCustomer(i);
								OracleJDBC.deleteNeck(i);
								OracleJDBC.deleteHardware(i);
								OracleJDBC.deleteBody(i);
								OracleJDBC.deleteCosmetic(i);
								OracleJDBC.deleteProduct(i); 
						}
						JOptionPane.showMessageDialog(null, "Database Unpopulated");
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnGo.setBounds(624, 69, 55, 23);
		frmDatabaseViewport.getContentPane().add(btnGo);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(447, 0, 2, 111);
		frmDatabaseViewport.getContentPane().add(separator);
		
		JLabel lblDisplayReports = new JLabel("Display Reports");
		lblDisplayReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDisplayReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayReports.setBounds(10, 11, 427, 49);
		frmDatabaseViewport.getContentPane().add(lblDisplayReports);
		
		JLabel lblTestingOptions = new JLabel("Testing Options");
		lblTestingOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestingOptions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTestingOptions.setBounds(459, 11, 301, 48);
		frmDatabaseViewport.getContentPane().add(lblTestingOptions);
		
		JButton btnAbout = new JButton("About"); 
		btnAbout.addActionListener(new ActionListener() //Explains how test data works.
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "This option is to populate all of the tables with testing data."
						+ "\n This way you may test the reports without manually entering all of the data."
						+ "\n The data for all text fields will say TEST and all numeric fields will be 0."
						+ "\n The ID field for each record will be numbered 0 through 99."
						+ "\n The Options field for each record containing one will be 'N'."
						+ "\n Once you are finished testing, select 'unpopulate' to remove the testing data."
						+ "\n This should only be done on an empty database, or those that only has IDs above 100");
				
				btnGo.setEnabled(true);				
			}
		});
		btnAbout.setBounds(689, 69, 71, 23);
		frmDatabaseViewport.getContentPane().add(btnAbout);
	}
}
