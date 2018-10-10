package guitarApp;

/*
 * Author Dylan Oszust
 * 
 * This class creates the customer objects which are created from the GUI,
 */

public class Customer
{
	private int ID;
	private String phone;
	private String first;
	private String last;
	private String address;
	private String email;
	private char returnCustomer; //'Y' or 'N' to state rather customer is new or not
	
	/**
	 * Default constructor for customer
	 */
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
	
	/**
	 * Overloaded constructor to create a customer with user input
	 * 
	 * @param ID
	 * Unique integer to identify customer in the database
	 * @param first
	 * Customer's first name
	 * @param last
	 * Customer's last name
	 * @param phone
	 * Customer's phone number
	 * @param address
	 * Customer's address
	 * @param email
	 * Customer's email
	 * @param returnCustomer
	 * States if customer is new or returning
	 */
	public Customer(int ID, String first, String last, String phone, String address, String email, char returnCustomer)
	{
		// Save user input locally
		this.ID = ID;
		this.phone = phone;
		this.first = first;
		this.last = last;
		this.address = address;
		this.email = email;
		this.returnCustomer = returnCustomer;
	}
	
	/**
	 * Saves ID locally
	 * 
	 * @param ID
	 */
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	/**
	 * returns ID
	 * 
	 * @return ID
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 * Saves the customer's phone number locally
	 * 
	 * @param phone
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	/**
	 * Returns the customer's phone number
	 * 
	 * @return phone
	 */
	public String getPhone()
	{
		return phone;
	}
	
	/**
	 * Save the first name locally
	 * 
	 * @param first
	 */
	public void setFirst(String first)
	{
		this.first = first;
	}
	
	/**
	 * Returns the customer's first name
	 * @return first
	 */
	public String getFirst()
	{
		return first;
	}
	
	/**
	 * Saves the last name locally
	 * 
	 * @param last
	 */
	public void setLast(String last)
	{
		this.last = last;
	}
	
	/**
	 * Returns the last name
	 * 
	 * @return last
	 */
	public String getlast()
	{
		return last;
	}
	
	/**
	 * Saves the customer's address locally
	 * 
	 * @param address
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	/**
	 * Returns the customer's address
	 * 
	 * @return address
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * Saves the customer's email locally
	 * 
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * Returns the customer's email
	 * 
	 * @return email
	 */
	public String getemail()
	{
		return email;
	}
	
	/**
	 * Saves if customer is a return customer locally
	 * @param returnCustomer
	 */
	public void setreturnCustomer(char returnCustomer)
	{
		this.returnCustomer = returnCustomer;
	}
	
	/**
	 * Returns rather or not the customer is a returning customer
	 * 
	 * @return returnCustomer
	 */
	public char getreturnCustomer()
	{
		return returnCustomer;
	}
}
