/**
 * @author Dylan Oszust
 *
 */

package guitarApp;


public class Body
{
	private int ID;
	private char carveTop;
	private char hollowBody;
	private String topWood;
	private String shape;
	private String bodyWood;
	
	public Body()
	{
		ID = 0;
		carveTop = 'N';
		hollowBody = 'N';
		topWood = null;
		shape = null;
		bodyWood = null;
		
	}
	public Body(int ID, String bodyWood, String topWood, String shape, char carveTop, char hollowBody)
	{
		this.ID = ID;
		this.bodyWood = bodyWood;
		this.topWood = topWood;
		this.shape = shape;
		this.carveTop = carveTop;
		this.hollowBody = hollowBody;
	}
	public void setID(int ID)
	{
		this.ID = ID;
	}
	public int getID()
	{
		return this.ID;
	}
	public void setBodyWood(String bodyWood)
	{
		this.bodyWood = bodyWood;
	}
	public String getBodyWood()
	{
		return this.bodyWood;
	}
	public void setTopWood(String topWood)
	{
		this.topWood = topWood;
	}
	public String getTopWood()
	{
		return this.topWood;
	}
	public void setShape(String shape)
	{
		this.shape = shape;
	}
	public String getShape()
	{
		return this.shape;
	}
	public void setCarveTop(char carveTop)
	{
		this.carveTop = carveTop;
	}
	public char getCarveTop()
	{
		return this.carveTop;
	}
	public void setHollowBody(char hollowBody)
	{
		this.hollowBody = hollowBody;
	}
	public char getHollowBody()
	{
		return this.hollowBody;
	}
}
