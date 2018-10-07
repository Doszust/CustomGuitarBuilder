package guitarApp;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import guitarApp.CosmeticsGui;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Builder
{

	private JFrame productsMenu;

	/**
	 * Launch the application.
	 */
	public static void createBuilderGui()
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					Builder window = new Builder();
					window.productsMenu.setVisible(true);
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
	public Builder()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		productsMenu = new JFrame();
		productsMenu.setResizable(false);
		productsMenu.setTitle("Guitar Builder");
		productsMenu.setBounds(100, 100, 274, 224);
		productsMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		productsMenu.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		productsMenu.setLocation(dim.width/2-productsMenu.getSize().width/2, dim.height/2-productsMenu.getSize().height/2);
		
		JButton btnCreateANeck = new JButton("Neck");
		btnCreateANeck.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				NeckGui.createNeckGui();
				productsMenu.dispose();
			}
		});
		btnCreateANeck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateANeck.setBounds(10, 11, 120, 48);
		productsMenu.getContentPane().add(btnCreateANeck);
		
		JButton btnCreateABody = new JButton("Body");
		btnCreateABody.setEnabled(true);
		btnCreateABody.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				BodyGui.createBodyGUI();
				productsMenu.dispose();
			}
		});
		btnCreateABody.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateABody.setBounds(140, 11, 118, 48);
		productsMenu.getContentPane().add(btnCreateABody);
		
		JButton btnSelectHardware = new JButton("Hardware");
		btnSelectHardware.setEnabled(true);
		btnSelectHardware.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				HardwareGui.createHardwareGUI();
				productsMenu.dispose();
			}
		});
		btnSelectHardware.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSelectHardware.setBounds(10, 70, 120, 48);
		productsMenu.getContentPane().add(btnSelectHardware);
		
		JButton btnSelectCosmetics = new JButton("Cosmetics");
		btnSelectCosmetics.setEnabled(true);
		btnSelectCosmetics.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CosmeticsGui.createCosmeticsGUI();
				productsMenu.dispose();
			}
		});
		btnSelectCosmetics.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSelectCosmetics.setBounds(140, 70, 118, 48);
		productsMenu.getContentPane().add(btnSelectCosmetics);
		
		JButton btnAssembleAGuitar = new JButton("Products");
		btnAssembleAGuitar.setEnabled(true);
		btnAssembleAGuitar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				ProductGui.createProductGui();
				productsMenu.dispose();
			}
		});
		btnAssembleAGuitar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAssembleAGuitar.setBounds(10, 129, 120, 48);
		productsMenu.getContentPane().add(btnAssembleAGuitar);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GuitarBuilderMainMenu.createMainMenu();
				productsMenu.dispose();
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMainMenu.setBounds(140, 129, 118, 48);
		productsMenu.getContentPane().add(btnMainMenu);
	}

}
