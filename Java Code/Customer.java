/*
 * Author Dylan Oszust
 * 3/12/2017
 * This class creates the customer objects which are created from the GUI, then called upon from the connection file
 */

package guitarApp;

public class Customer
{
	private int ID;
	private String phone;
	private String first;
	private String last;
	private String address;
	private String email;
	private char returnCustomer;
	
	public Customer()
	{
		this.ID = 0;
		this.phone = null;
		this.first = null;
		this.last = null;
		this.address = null;
		this.email = null;
		this.returnCustomer = 'N';
	}
	public Customer(int ID, String first, String last, String phone, String address, String email, char returnCustomer)
	{
		this.ID = ID;
		this.phone = phone;
		this.first = first;
		this.last = last;
		this.address = address;
		this.email = email;
		this.returnCustomer = returnCustomer;
	}
	public void setID(int ID)
	{
		this.ID = ID;
	}
	public int getID()
	{
		return this.ID;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public void setFirst(String first)
	{
		this.first = first;
	}
	public String getFirst()
	{
		return this.first;
	}
	public void setLast(String last)
	{
		this.last = last;
	}
	public String getlast()
	{
		return this.last;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAddress()
	{
		return this.address;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getemail()
	{
		return this.email;
	}
	public void setreturnCustomer(char returnCustomer)
	{
		this.returnCustomer = returnCustomer;
	}
	public char getreturnCustomer()
	{
		return this.returnCustomer;
	}
}
