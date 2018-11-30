/*
 * Author Dylan Oszust
 * 3/12/2017
 * This code accesses the database, and modifies it, or reads it.
 */

package guitarApp;

import java.awt.Component;
import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class OracleJDBC 
{
	static Connection connection = null;
	static Scanner scanner = new Scanner(System.in);
	
	/**
	 * 
	 * @param username
	 * Username entered on system login.  Must match database username
	 * @param password
	 * Password entered on system login.  Must match database password
	 * @throws SQLException
	 * gets thrown if login is unsuccessful
	 * @throws ClassNotFoundException
	 * gets thrown if ojdbc7.jar is not found
	 */
	public static void connect(String username, String password) throws SQLException, ClassNotFoundException
	{
			
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	
	         
	         connection = DriverManager.getConnection(
	                 "jdbc:oracle:thin:@localhost:1521:xe", username, password);
	
	}

	/************************************MANAGE CUSTOMER INFORMATION************************************/
	
	/**
	 * Writes customer to database
	 * 
	 * @param obj
	 * incoming customer object to be written to database
	 * @throws SQLException
	 * thrown if write was unsuccessful
	 */
	public static void writeCustomer(Customer obj) throws SQLException
	{
		//Retrieve customer attributes to store in DB
		int ID = obj.getID();
		String first = obj.getFirst();
		String last = obj.getlast();
		String phone = obj.getPhone();
		String adress = obj.getAddress();
		String email = obj.getemail();
		char returnCustomer = obj.getreturnCustomer();
			
		Statement st = connection.createStatement();
			
		//Writes to database
		st.executeUpdate("INSERT INTO CUSTOMER VALUES ("+ ID + ", '" + first + 
				"', '" + last + "', '" + phone+ "', '" +adress+ "', '" + email +"', '" +returnCustomer+"')");
			
		st.close();
	}
	
	/**
	 * Retrieves first name from customer using ID
	 * 
	 * @param ID
	 * ID of customer to retrieve info
	 * @return first
	 * @throws SQLException
	 * thrown on unsuccessful read
	 */
	public static String readCustomerFirstName(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select FIRSTNAME FROM Customer where CUSTOMERID ="+ ID);
		ResultSet rs = st.executeQuery(sql);
		String first = null;
		
		if (rs.next())
		{
			first = rs.getString("FIRSTNAME");
		}
		st.close(); rs.close();
		return first;
	}
	public static String readCustomerLastName(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select LASTNAME FROM Customer where CUSTOMERID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String last = null;
		
		if (rs.next())
		{
			last = rs.getString("LASTNAME");
		}
		st.close(); rs.close();
		return last;
	}
	public static String readCustomerPhoneNumber(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select PHONE FROM Customer where CUSTOMERID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String phone = null;
		
		if (rs.next())
		{
			phone = rs.getString("PHONE");
		}
		st.close(); rs.close();
		return phone;
	}
	public static String readCustomerAddress(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select ADDRESS FROM Customer where CUSTOMERID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String address = null;
		
		if (rs.next())
		{
			address = rs.getString("ADDRESS");
		}
		st.close(); rs.close();
		return address;
	}
	public static String readCustomerEmail(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select EMAIL FROM Customer where CUSTOMERID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String email = null;
		
		if (rs.next())
		{
			email = rs.getString("EMAIL");
		}
		st.close(); rs.close();
		return email;
	}
	public static String readReturnCustomer(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select RETURNCUSTOMER FROM Customer where CUSTOMERID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String returnCustomer = null;
		
		if (rs.next())
		{
			returnCustomer = rs.getString("RETURNCUSTOMER");
		}
		st.close(); rs.close();
		return returnCustomer;
	}
	public static void updateCustomer(Customer obj) throws SQLException
	{
		int ID = obj.getID();
		String first = obj.getFirst();
		String last = obj.getlast();
		String phone = obj.getPhone();
		String adress = obj.getAddress();
		String email = obj.getemail();
		char returnCustomer = obj.getreturnCustomer();
		
		Statement st = connection.createStatement();
		
		st.executeUpdate("UPDATE CUSTOMER SET FIRSTNAME = '" + first + 
				"', LASTNAME = '" + last + "', PHONE = '" + phone + 
				"', ADDRESS = '" +adress+ "', EMAIL = '" + email +
				"', RETURNCUSTOMER = '" +returnCustomer+"' WHERE CUSTOMERID = " + ID);
		st.close();
	}
	
	public static void deleteCustomer(int ID) throws SQLException
	{
	
		Statement st = connection.createStatement();
		
		st.executeUpdate("DELETE FROM CUSTOMER WHERE CUSTOMERID = " + ID);
		st.close();
	}
	
	public static int readCustomerID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select CUSTOMERID FROM Customer where CUSTOMERID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		int CustomerID = 0;
		
		if (rs.next())
		{
			CustomerID = rs.getInt("CUSTOMERID");
		}
		st.close(); rs.close();
		return CustomerID;
	}
	
	/************************************MANAGE NECK INFORMATION************************************/
	public static void writeNeck(Neck obj) throws SQLException
	{
		
			int ID = obj.getID();
			String neckWood = obj.getNeckWood();
			String fingerBoard = obj.getFingerBoard();
			double scale = obj.getScale();
			int numberOfFrets = obj.getFrets();
			String neckJoint = obj.getJoint();
			
			Statement st = connection.createStatement();
			
			st.executeUpdate("INSERT INTO NECK VALUES ("+ ID + ", '" + neckWood + 
					"', '" + fingerBoard + "', '" + scale + "', '" + numberOfFrets + "', '" + neckJoint +"')");
			st.close();
	}
	
	public static void updateNeck(Neck obj) throws SQLException
	{
		int ID = obj.getID();
		String neckWood = obj.getNeckWood();
		String fingerBoard = obj.getFingerBoard();
		double scale = obj.getScale();
		int numberOfFrets = obj.getFrets();
		String neckJoint = obj.getJoint();
		
		Statement st = connection.createStatement();
		
		st.executeUpdate("UPDATE NECK SET NECKWOOD = '" + neckWood + "', FINGERBOARD = '" + fingerBoard
				+ "', SCALE = '" + scale + "', NUMBEROFFRETS = '" + numberOfFrets
				+"', NECKJOINT = '" +neckJoint+"' WHERE NECKID = " + ID);
		st.close();
	}
	
	public static String readNeckWood(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select NeckWood FROM NECK where NECKID ="+ ID);
		ResultSet rs = st.executeQuery(sql);
		String neckWood = null;
		
		if (rs.next())
		{
			neckWood = rs.getString("NECKWOOD");
		}
		st.close(); rs.close();
		return neckWood;
	}
	public static String readFingerBoard(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select FingerBoard FROM NECK where NECKID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String fingerBoard = null;
		
		if (rs.next())
		{
			fingerBoard = rs.getString("FINGERBOARD");
		}
		st.close(); rs.close();
		return fingerBoard;
	}
	public static String readScale(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select Scale FROM NECK where NECKID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String scale = null;
		
		if (rs.next())
		{
			scale = rs.getString("SCALE");
		}
		st.close(); rs.close();
		return scale;
	}
	public static String readNumberOfFrets(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select NumberOfFrets FROM NECK where NECKID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String numberOfFrets = null;
		
		if (rs.next())
		{
			numberOfFrets = rs.getString("NUMBEROFFRETS");
		}
		st.close(); rs.close();
		return numberOfFrets;
	}
	public static String readNeckJoint(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select NeckJoint FROM NECK where NECKID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String joint = null;
		
		if (rs.next())
		{
			joint = rs.getString("NECKJOINT");
		}
		st.close(); rs.close();
		return joint;
	}
	
	public static int readNeckID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select NECKID FROM NECK where NECKID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		int neckID = 0;
		
		if (rs.next())
		{
			neckID = rs.getInt("neckID");
		}
		st.close(); rs.close();
		return neckID;
	}
	
	public static void deleteNeck(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		
		st.executeUpdate("DELETE FROM NECK WHERE NECKID = " + ID);
		st.close();
	}
	
	/************************************MANAGE HARDWARE INFORMATION************************************/
	public static void writeHardware(Hardware obj) throws SQLException
	{
		
			int ID = obj.getID();
			String neckPickup = obj.getNeckPickup();
			if(neckPickup == "No Neck Pickup")
			{
				neckPickup = "N/A";
			}
			String middlePickup = obj.getMiddlePickup();
			if(middlePickup == "No Middle Pickup")
			{
				middlePickup = "N/A";
			}
			String bridgePickup = obj.getBridgePickup();
			if(bridgePickup == "No Bridge Pickup")
			{
				bridgePickup = "N/A";
			}
			String knobs = obj.getKnobs();
			String bridge = obj.getBridge();
			String tuners = obj.getTuners();
			
			Statement st = connection.createStatement();
			
			st.executeUpdate("INSERT INTO Hardware VALUES ("+ ID + ", '" + neckPickup + 
					"', '" + middlePickup + "', '" + bridgePickup + "', '" + knobs + "', '" + bridge +"', '" + tuners + "')");
			st.close();
	}
	
	public static void updateHardware(Hardware obj) throws SQLException
	{
		int ID = obj.getID();
		String neckPickup = obj.getNeckPickup();
		String middlePickup = obj.getMiddlePickup();
		String bridgePickup = obj.getBridgePickup();
		String knobs = obj.getKnobs();
		String bridge = obj.getBridge();
		String tuners = obj.getTuners();
		
		Statement st = connection.createStatement();
		
		st.executeUpdate("UPDATE Hardware SET neckPickup = '" + neckPickup + "', middlePickup = '" + middlePickup
				+ "', bridgePickup = '" + bridgePickup + "', tonevolknobs = '" + knobs
				+"', bridge = '" +bridge+"', tuners = '" +tuners+"' WHERE HardwareID = " + ID);
		st.close(); 
	}
	
	public static String readNeckPickup(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select neckPickup FROM Hardware where HardwareID ="+ ID);
		ResultSet rs = st.executeQuery(sql);
		String neckPickup = null;
		
		if (rs.next())
		{
			neckPickup = rs.getString("neckPickup");
		}
		st.close(); rs.close();
		return neckPickup;
	}
	public static String readMiddlePickup(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select middlePickup FROM Hardware where HardwareID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String middlePickup = null;
		
		if (rs.next())
		{
			middlePickup = rs.getString("middlePickup");
		}
		st.close(); rs.close();
		return middlePickup;
	}
	public static String readBridgePickup(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select bridgePickup FROM Hardware where HardwareID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String bridgePickup = null;
		
		if (rs.next())
		{
			bridgePickup = rs.getString("bridgePickup");
		}
		st.close(); rs.close();
		return bridgePickup;
	}
	public static String readKnobs(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select tonevolknobs FROM Hardware where HardwareID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String knobs = null;
		
		if (rs.next())
		{
			knobs = rs.getString("tonevolknobs");
		}
		st.close(); rs.close();
		return knobs;
	}
	public static String readBridge(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select bridge FROM Hardware where HardwareID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String bridge = null;
		
		if (rs.next())
		{
			bridge = rs.getString("bridge");
		}
		st.close(); rs.close();
		return bridge;
	}
	public static String readTuners(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select tuners FROM Hardware where HardwareID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String tuners = null;
		
		if (rs.next())
		{
			tuners = rs.getString("tuners");
		}
		st.close(); rs.close();
		return tuners;
	}
	
	public static int readHardwareID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select HardwareID FROM Hardware where HardwareID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		int HardwareID = 0;
		
		if (rs.next())
		{
			HardwareID = rs.getInt("HardwareID");
		}
		st.close(); rs.close();
		return HardwareID;
	}
	
	public static void deleteHardware(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		
		st.executeUpdate("DELETE FROM Hardware WHERE HardwareID = " + ID);
		st.close();
	}
	
	/************************************MANAGE BODY INFORMATION************************************/
	public static void writeBody(Body obj) throws SQLException
	{
		
			int ID = obj.getID();
			String bodyWood = obj.getBodyWood();
			String topWood = obj.getTopWood();
			String shape = obj.getShape();
			char carveTop = obj.getCarveTop();
			char hollowBody = obj.getHollowBody();
			
			Statement st = connection.createStatement();
			
			st.executeUpdate("INSERT INTO Body VALUES ("+ ID + ", '" + bodyWood + 
					"', '" + topWood + "', '" + shape + "', '" + carveTop + "', '" + hollowBody + "')");
			st.close(); 
	}
	
	public static void updateBody(Body obj) throws SQLException
	{
		int ID = obj.getID();
		String bodyWood = obj.getBodyWood();
		String topWood = obj.getTopWood();
		String shape = obj.getShape();
		char carveTop = obj.getCarveTop();
		char hollowBody = obj.getHollowBody();
		
		Statement st = connection.createStatement();
		
		st.executeUpdate("UPDATE Body SET bodyWood = '" + bodyWood + "', topWood = '" + topWood
				+ "', bodyshape = '" + shape + "', carveTop = '" + carveTop
				+"', hollowBody = '" +hollowBody+"' WHERE BodyID = " + ID);
		st.close();
	}
	
	public static String readBodyWood(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select bodyWood FROM Body where BodyID ="+ ID);
		ResultSet rs = st.executeQuery(sql);
		String bodyWood = null;
		
		if (rs.next())
		{
			bodyWood = rs.getString("bodyWood");
		}
		st.close(); rs.close();
		return bodyWood;
	}
	public static String readTopWood(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select topWood FROM Body where BodyID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String topWood = null;
		
		if (rs.next())
		{
			topWood = rs.getString("topWood");
		}
		st.close(); rs.close();
		return topWood;
	}
	public static String readShape(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select bodyshape FROM Body where BodyID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String shape = null;
		
		if (rs.next())
		{
			shape = rs.getString("bodyshape");
		}
		st.close(); rs.close();
		return shape;
	}
	public static String readCarveTop(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select carveTop FROM Body where BodyID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String carveTop = null;
		
		if (rs.next())
		{
			carveTop = rs.getString("carveTop");
		}
		st.close(); rs.close();
		return carveTop;
	}
	public static String readHollowBody(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select hollowBody FROM Body where BodyID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String hollowBody = null;
		
		if (rs.next())
		{
			hollowBody = rs.getString("hollowBody");
		}
		st.close(); rs.close();
		return hollowBody;
	}
	
	
	public static int readBodyID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select BodyID FROM Body where BodyID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		int BodyID = 0;
		
		if (rs.next())
		{
			BodyID = rs.getInt("BodyID");
		}
		st.close(); rs.close();
		return BodyID;
	}
	
	public static void deleteBody(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		
		st.executeUpdate("DELETE FROM Body WHERE BodyID = " + ID);
		st.close();
	}
	/************************************MANAGE COSMETIC INFORMATION************************************/
	public static void writeCosmetic(Cosmetics obj) throws SQLException
	{
		
		int ID = obj.getID();
		String bodyColor = obj.getBodyColor();
		String neckColor = obj.getNeckColor();
		String hardwareColor = obj.getHardwareColor();
		String bindingColor = obj.getBindingColor();
		char fretMarkers = obj.getFretMarkers();
		String markerType = obj.getMarkerType();
		String markerColor = obj.getMarkerColor();
			
			Statement st = connection.createStatement();
			
			st.executeUpdate("INSERT INTO Cosmetic VALUES ("+ ID + ", '" + bodyColor + 
					"', '" + neckColor + "', '" + hardwareColor + "', '" + bindingColor +
					"', '" + fretMarkers + "', '" + markerType +"', '" + markerColor +"')");
			st.close();
	}
	
	public static void updateCosmetic(Cosmetics obj) throws SQLException
	{
		int ID = obj.getID();
		String bodyColor = obj.getBodyColor();
		String neckColor = obj.getNeckColor();
		String hardwareColor = obj.getHardwareColor();
		String bindingColor = obj.getBindingColor();
		char fretMarkers = obj.getFretMarkers();
		String markerType = obj.getMarkerType();
		String markerColor = obj.getMarkerColor();
		
		Statement st = connection.createStatement();
		
		st.executeUpdate("UPDATE Cosmetic SET bodyColor = '" + bodyColor + "', neckColor = '" + neckColor
				+ "', hardwareColor = '" + hardwareColor + "', bindingColor = '" + bindingColor
				+"', FretMarkers = '" + fretMarkers	+"', markerType = '" +markerType+
				"', markerColor = '" +markerColor+"' WHERE CosmeticID = " + ID);
		st.close();
	}
	
	public static String readBodyColor(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select BodyColor FROM Cosmetic where CosmeticID ="+ ID);
		ResultSet rs = st.executeQuery(sql);
		String bodyColor = null;
		
		if (rs.next())
		{
			bodyColor = rs.getString("bodyColor");
		}
		st.close(); rs.close();
		return bodyColor;
	}
	public static String readNeckColor(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select NeckColor FROM Cosmetic where CosmeticID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String neckColor = null;
		
		if (rs.next())
		{
			neckColor = rs.getString("neckColor");
		}
		st.close(); rs.close();
		return neckColor;
	}
	public static String readHardwareColor(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select HardwareColor FROM Cosmetic where CosmeticID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String hardwareColor = null;
		
		if (rs.next())
		{
			hardwareColor = rs.getString("HardwareColor");
		}
		st.close(); rs.close();
		return hardwareColor;
	}
	public static String readBindingColor(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select BindingColor FROM Cosmetic where CosmeticID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String bindingColor = null;
		
		if (rs.next())
		{
			bindingColor = rs.getString("bindingColor");
		}
		st.close(); rs.close();
		return bindingColor;
	}
	public static String readFretMarkers(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select FretMarkers FROM Cosmetic where CosmeticID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		String fretMarkers = null;
		
		if (rs.next())
		{
			fretMarkers = rs.getString("FretMarkers");
		}
		st.close(); rs.close();
		return fretMarkers;
	}
	
	public static String readMarkerType(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select MarkerType FROM Cosmetic where CosmeticID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String markerType = null;
		
		if (rs.next())
		{
			markerType = rs.getString("MarkerType");
		}
		st.close(); rs.close();
		return markerType;
	}
	
	public static String readMarkerColor(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select MarkerColor FROM Cosmetic where CosmeticID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String markerColor = null;
		
		if (rs.next())
		{
			markerColor = rs.getString("MarkerColor");
		}
		st.close(); rs.close();
		return markerColor;
	}
	
	public static int readCosmeticID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select CosmeticID FROM Cosmetic where CosmeticID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		int CosmeticID = 0;
		
		if (rs.next())
		{
			CosmeticID = rs.getInt("CosmeticID");
		}
		st.close(); rs.close();
		return CosmeticID;
	}
	
	public static void deleteCosmetic(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		
		st.executeUpdate("DELETE FROM Cosmetic WHERE CosmeticID = " + ID);
		st.close();
	}
	/************************************MANAGE PRODUCT INFORMATION************************************/
	public static void writeProduct(Product obj) throws SQLException
	{
		
		int productID = obj.getProductID();
		int neckID = obj.getNeckID();
		int bodyID = obj.getBodyID();
		int hardwareID = obj.getHardwareID();
		int cosmeticID = obj.getCosmeticID();
		int customerID = obj.getCustomerID();
		char paid  = obj.getPaid();
			
			Statement st = connection.createStatement();
			
			st.executeUpdate("INSERT INTO Product VALUES ("+ productID + ", '" + neckID + 
					"', '" + bodyID + "', '" + hardwareID + "', '" + cosmeticID +
					"', '" + customerID + "', '" + paid +"')");
			st.close();
	}
	
	public static void updateProduct(Product obj) throws SQLException
	{
		int productID = obj.getProductID();
		int neckID = obj.getNeckID();
		int bodyID = obj.getBodyID();
		int hardwareID = obj.getHardwareID();
		int cosmeticID = obj.getCosmeticID();
		int customerID = obj.getCustomerID();
		char paid  = obj.getPaid();
		
		Statement st = connection.createStatement();
		
		st.executeUpdate("UPDATE Product SET neckID = '" + neckID + "', bodyID = '" + bodyID
				+ "', hardwareID = '" + hardwareID + "', cosmeticID = '" + cosmeticID
				+"', customerID = '" + customerID +"', paid = '" +paid+"' WHERE ProductID = " + productID);
		st.close();
	}
	
	public static int readProductNeckID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select neckID FROM Product where ProductID ="+ ID);
		ResultSet rs = st.executeQuery(sql);
		int neckID = 0;
		
		if (rs.next())
		{
			neckID = rs.getInt("neckID");
		}
		st.close(); rs.close();
		return neckID;
	}
	public static int readProductBodyID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select bodyID FROM Product where ProductID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		int bodyID = 0;
		
		if (rs.next())
		{
			bodyID = rs.getInt("bodyID");
		}
		st.close(); rs.close();
		return bodyID;
	}
	public static int readProductHardwareID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select HardwareID FROM Product where ProductID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		int hardwareID = 0;
		
		if (rs.next())
		{
			hardwareID = rs.getInt("HardwareID");
		}
		st.close(); rs.close();
		return hardwareID;
	}
	public static int readProductCosmeticID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select cosmeticID FROM Product where ProductID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		int cosmeticID = 0;
		
		if (rs.next())
		{
			cosmeticID = rs.getInt("cosmeticID");
		}
		st.close(); rs.close();
		return cosmeticID;
	}
	public static int readProductCustomerID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select customerID FROM Product where ProductID = " + ID);
		ResultSet rs = st.executeQuery(sql);
		int customerID = 0;
		
		if (rs.next())
		{
			customerID = rs.getInt("customerID");
		}
		st.close(); rs.close();
		return customerID;
	}
	
	public static String readPaid(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select paid FROM Product where ProductID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		String paid = null;
		
		if (rs.next())
		{
			paid = rs.getString("paid");
		}
		st.close(); rs.close();
		return paid;
	}
	
	
	public static int readProductID(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = ("Select ProductID FROM Product where ProductID = "+ ID);
		ResultSet rs = st.executeQuery(sql);
		int ProductID = 0;
		
		if (rs.next())
		{
			ProductID = rs.getInt("ProductID");
		}
		st.close(); rs.close();
		return ProductID;
	}
	
	public static void deleteProduct(int ID) throws SQLException
	{
		Statement st = connection.createStatement();
		
		st.executeUpdate("DELETE FROM Product WHERE ProductID = " + ID);
		st.close();
	}
	/******************************************DISPLAY DATA*******************************/
	public static JTable displayDetailedContent() throws SQLException //displays detailed product information
	{
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select PRODUCTID, NECKWOOD, FINGERBOARD, SCALE, NUMBEROFFRETS, NECKJOINT, BODYWOOD, TOPWOOD, BODYSHAPE, "
					+ "CARVETOP, HOLLOWBODY, NECKPICKUP, MIDDLEPICKUP, BRIDGEPICKUP, TONEVOLKNOBS, BRIDGE, TUNERS, "
				+ "BODYCOLOR, NECKCOLOR, HARDWARECOLOR, BINDINGCOLOR, FRETMARKERS, MARKERTYPE, MARKERCOLOR, PAID "
				+ "FROM PRODUCT JOIN NECK USING(NECKID) "
				+ "JOIN BODY USING(BODYID) "
				+ "JOIN HARDWARE USING (HARDWAREID) "
				+ "JOIN COSMETIC USING (COSMETICID) ");
	    JTable table = new JTable(buildTableModel(rs));
	    st.close(); rs.close();
	    
	    //formats table to auto resize so no information is cut off.
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    for (int column = 0; column < table.getColumnCount(); column++)
		{
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();
			Object value = tableColumn.getHeaderValue();
			TableCellRenderer renderer = tableColumn.getHeaderRenderer();
	
			if (renderer == null)
			{
				renderer = table.getTableHeader().getDefaultRenderer();
			}
	
			Component h = renderer.getTableCellRendererComponent(table, value, false, false, -1, column);
			int headerSize = h.getPreferredSize().width;
	
		    for (int row = 0; row < table.getRowCount(); row++)
		    {
		        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		        Component c = table.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);
		        preferredWidth = Math.max(preferredWidth, headerSize);
	
		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		    tableColumn.setPreferredWidth( preferredWidth + 6 );
		}
	    
	    return table;
	    
	}
	public static JTable displayShippingContent() throws SQLException //displays Shipping data
	{
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select CUSTOMERID, PRODUCTID, FIRSTNAME, LASTNAME, ADDRESS, PAID "
				+ "FROM CUSTOMER JOIN PRODUCT USING(CUSTOMERID) ");
	    JTable table = new JTable(buildTableModel(rs));
	    st.close(); rs.close();
	   
	    //formats table to auto resize so no information is cut off.
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    for (int column = 0; column < table.getColumnCount(); column++)
		{
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();
			Object value = tableColumn.getHeaderValue();
			TableCellRenderer renderer = tableColumn.getHeaderRenderer();
	
			if (renderer == null)
			{
				renderer = table.getTableHeader().getDefaultRenderer();
			}
	
			Component h = renderer.getTableCellRendererComponent(table, value, false, false, -1, column);
			int headerSize = h.getPreferredSize().width;
	
		    for (int row = 0; row < table.getRowCount(); row++)
		    {
		        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		        Component c = table.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);
		        preferredWidth = Math.max(preferredWidth, headerSize);
	
		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		     tableColumn.setPreferredWidth( preferredWidth + 6 );
		}
	    return table;
	    
	}
	public static JTable displayContent(String selection) throws SQLException //displays all other content
	{
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from " + selection);
	    JTable table = new JTable(buildTableModel(rs));
	    st.close(); rs.close();
	    
	    //formats table to auto resize so no information is cut off.
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    for (int column = 0; column < table.getColumnCount(); column++)
		{
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();
			Object value = tableColumn.getHeaderValue();
			TableCellRenderer renderer = tableColumn.getHeaderRenderer();
	
			if (renderer == null)
			{
				renderer = table.getTableHeader().getDefaultRenderer();
			}
	
			Component h = renderer.getTableCellRendererComponent(table, value, false, false, -1, column);
			int headerSize = h.getPreferredSize().width;
	
		    for (int row = 0; row < table.getRowCount(); row++)
		    {
		        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		        Component c = table.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);
		        preferredWidth = Math.max(preferredWidth, headerSize);
	
		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		    tableColumn.setPreferredWidth( preferredWidth + 6 );
		}
	    return table;
	    
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)throws SQLException
	{
	
	    ResultSetMetaData metaData = rs.getMetaData();
	
	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }
	
	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	
	    return new DefaultTableModel(data, columnNames);
	
	}
}
