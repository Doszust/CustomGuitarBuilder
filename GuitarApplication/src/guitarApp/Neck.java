/**
 * @author Dylan Oszust
 *  3/12/2017
 *  This class creates neck objects
 */

package guitarApp;


public class Neck
{
	private int ID;
	private String fingerBoard;
	private double scale;
	private int frets;
	private String joint;
	private String neckWood;
	
	public Neck()
	{
		ID = 0;
		fingerBoard = null;
		scale = 0.0;
		frets = 0;
		joint = null;
	}
	public Neck(int ID, String neckWood, String fingerBoard, double scale, int frets, String joint)
	{
		this.ID = ID;
		this.neckWood = neckWood;
		this.fingerBoard = fingerBoard;
		this.scale = scale;
		this.frets = frets;
		this.joint = joint;
	}
	public void setID(int ID)
	{
		this.ID = ID;
	}
	public int getID()
	{
		return this.ID;
	}
	public void setFingerBoard(String fingerBoard)
	{
		this.fingerBoard = fingerBoard;
	}
	public String getFingerBoard()
	{
		return this.fingerBoard;
	}
	public void setScale(double scale)
	{
		this.scale = scale;
	}
	public double getScale()
	{
		return this.scale;
	}
	public void setFrets(int frets)
	{
		this.frets = frets;
	}
	public int getFrets()
	{
		return this.frets;
	}
	public void setJoint(String joint)
	{
		this.joint = joint;
	}
	public String getJoint()
	{
		return this.joint;
	}
	public void setNeckWood(String neckWood)
	{
		this.neckWood = neckWood;
	}
	public String getNeckWood()
	{
		return this.neckWood;
	}

}
