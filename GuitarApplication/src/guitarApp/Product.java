/**
 * @author Dylan Oszust
 *  3/12/2017
 *  This class creates Product Objects
 */

package guitarApp;


public class Product
{
	private int productID;
	private int neckID;
	private int bodyID;
	private int hardwareID;
	private int cosmeticID;
	private int customerID;
	private char paid;
	
	public Product()
	{
		productID = 0;
		neckID = 0;
		bodyID = 0;
		hardwareID = 0;
		cosmeticID = 0;
		customerID = 0;
		paid = 'N';
	}
	public Product(int productID, int neckID, int bodyID, int hardwareID, int cosmeticID, int customerID, char paid)
	{
		this.productID = productID;
		this.neckID = neckID;
		this.bodyID = bodyID;
		this.hardwareID = hardwareID;
		this.cosmeticID = cosmeticID;
		this.customerID = customerID;
		this.paid = paid;
	}
	public void setProductID(int productID)
	{
		this.productID = productID;
	}
	public int getProductID()
	{
		return this.productID;
	}
	public void setNeckID(int neckID)
	{
		this.neckID = neckID;
	}
	public int getNeckID()
	{
		return this.neckID;
	}
	public void setBodyID(int bodyID)
	{
		this.bodyID = bodyID;
	}
	public int getBodyID()
	{
		return this.bodyID;
	}
	public void setHardwareID(int hardwareID)
	{
		this.hardwareID = hardwareID;
	}
	public int getHardwareID()
	{
		return this.hardwareID;
	}
	public void setCosmeticID(char cosmeticID)
	{
		this.cosmeticID = cosmeticID;
	}
	public int getCosmeticID()
	{
		return this.cosmeticID;
	}
	public void setCustomerID(int customerID)
	{
		this.customerID = customerID;
	}
	public int getCustomerID()
	{
		return this.customerID;
	}
	public void setPaid(char paid)
	{
		this.paid = paid;
	}
	public char getPaid()
	{
		return this.paid;
	}
	
}
