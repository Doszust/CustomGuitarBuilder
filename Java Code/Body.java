package guitarApp;

/**
 * @author Dylan Oszust
 * 
 * This class creates a guitar body object
 * The body will 
 */

public class Body
{
	private int ID; //ID for the database
	private char carveTop; //Will be either 'Y' or 'N' to show rather the body will have a carve top or not
	private char hollowBody; //Will be either 'Y' or 'N' to show rather the body will have a hollow body or not
	private String topWood; //States what type of wood the guitar top will be made from
	private String shape; //States the shape of the body
	private String bodyWood; //States what type of wood the body will be made from
	
	/**
	 * Default Constructor
	 */
	public Body()
	{
		ID = 0;
		carveTop = 'N';
		hollowBody = 'N';
		topWood = null;
		shape = null;
		bodyWood = null;
		
	}
	
	/**
	 * 
	 * Takes in user provided attributes to create a body to user specifications
	 * 
	 * @param ID
	 * Takes in an int to set for the id of the guitar body
	 * @param bodyWood
	 * Takes in a string for the body wood
	 * @param topWood
	 * Takes in a string for the top wood
	 * @param shape
	 * Takes in a string for the shape of the body
	 * @param carveTop
	 * Takes in a Y/N char to decide if the body will have a guitar top
	 * @param hollowBody
	 * Takes in a Y/N char to decide if the body will be hollow or solid
	 */
	public Body(int ID, String bodyWood, String topWood, String shape, char carveTop, char hollowBody)
	{
		this.ID = ID;
		this.bodyWood = bodyWood;
		this.topWood = topWood;
		this.shape = shape;
		this.carveTop = carveTop;
		this.hollowBody = hollowBody;
	}
	
	/**
	 * sets local ID to incoming ID
	 * 
	 * @param ID
	 * 
	 */
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	/**
	 * Sends back the ID of the guitar body
	 * 
	 * @return ID
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 * Sets local body wood to incoming body wood
	 * 
	 * @param bodyWood
	 */
	public void setBodyWood(String bodyWood)
	{
		this.bodyWood = bodyWood;
	}
	
	/**
	 * Returns the type of body wood to calling method
	 * 
	 * @return bodyWood
	 */
	public String getBodyWood()
	{
		return bodyWood;
	}
	
	/**
	 * Sets local topWood to incoming topWood
	 * @param topWood
	 */
	public void setTopWood(String topWood)
	{
		this.topWood = topWood;
	}
	
	/**
	 * Returns the body top wood type to calling method
	 * 
	 * @return topWood
	 */
	public String getTopWood()
	{
		return topWood;
	}
	
	/**
	 * Sets local shape to incoming shape
	 * 
	 * @param shape
	 */
	public void setShape(String shape)
	{
		this.shape = shape;
	}
	
	/**
	 * Returns body shape to calling method
	 * 
	 * @return shape
	 */
	public String getShape()
	{
		return shape;
	}
	
	/**
	 * Sets local carveTop to incoming carveTop
	 * 
	 * @param carveTop
	 */
	public void setCarveTop(char carveTop)
	{
		this.carveTop = carveTop;
	}
	
	/**
	 * Returns rather or not the body has a carve top to calling method
	 * 
	 * @return carveTop
	 */
	public char getCarveTop()
	{
		return carveTop;
	}
	
	/**
	 * Sets local hollowBody to incoming hollowBody
	 * 
	 * @param hollowBody
	 */
	public void setHollowBody(char hollowBody)
	{
		this.hollowBody = hollowBody;
	}
	
	/**
	 * Returns rather the body is hollow or not to calling method
	 * 
	 * @return hollowBody
	 */
	public char getHollowBody()
	{
		return hollowBody;
	}
}
