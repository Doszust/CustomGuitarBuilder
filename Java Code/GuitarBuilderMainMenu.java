/**
 * @author Dylan Oszust
 *  3/12/2017
 *  This is the graphical user interface for the Main Menu
 */


package guitarApp;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import guitarApp.Builder;
import guitarApp.CustomerGui;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class GuitarBuilderMainMenu
{

	private JFrame mainMenu;

	/**
	 * Launch the application.
	 */
	public static void createMainMenu()
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					GuitarBuilderMainMenu window = new GuitarBuilderMainMenu();
					window.mainMenu.setVisible(true);
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
	public GuitarBuilderMainMenu()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		mainMenu = new JFrame();
		mainMenu.setTitle("Guitar Builder");
		mainMenu.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		mainMenu.setBounds(100, 100, 300, 213);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainMenu.setLocation(dim.width/2-mainMenu.getSize().width/2, dim.height/2-mainMenu.getSize().height/2);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu.setBounds(10, 11, 260, 25);
		mainMenu.getContentPane().add(lblMainMenu);
		
		JButton btnNewButton = new JButton("Customers");
		btnNewButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CustomerGui.createCustomerGui();
				mainMenu.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 47, 125, 53);
		mainMenu.getContentPane().add(btnNewButton);
		
		JButton btnBuildAGuitar = new JButton("Builder");
		btnBuildAGuitar.setEnabled(true);
		btnBuildAGuitar.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Builder.createBuilderGui();
				mainMenu.dispose();
			}
		});
		btnBuildAGuitar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuildAGuitar.setBounds(145, 47, 125, 53);
		mainMenu.getContentPane().add(btnBuildAGuitar);
		
		JButton btnCreateReports = new JButton("Reports");
		btnCreateReports.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ReportsGui.runReportsGUI();
				mainMenu.dispose();
			}
		});
		btnCreateReports.setEnabled(true);
		btnCreateReports.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateReports.setBounds(10, 111, 125, 53);
		mainMenu.getContentPane().add(btnCreateReports);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mainMenu.dispatchEvent(new WindowEvent(mainMenu, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnClose.setBounds(145, 111, 125, 53);
		mainMenu.getContentPane().add(btnClose);
	}
}
