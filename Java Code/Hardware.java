/**
 * @author Dylan Oszust
 *  3/12/2017
 *  This class creates Hardware Objects
 */

package guitarApp;


public class Hardware
{
	private int ID;
	private String neckPickup;
	private String middlePickup;
	private String bridgePickup;
	private String knobs;
	private String bridge;
	private String tuners;

	public Hardware()
	{
		ID = 0;
		neckPickup = null;
		middlePickup = null;
		bridgePickup = null;
		knobs = null;
		bridge = null;
		tuners = null;
	}
	public Hardware(int ID, String neckPickup, String middlePickup, String bridgePickup, String knobs,
			String bridge, String tuners) 
	{
		this.ID = ID;
		this.bridge = bridge;
		this.bridgePickup = bridgePickup;
		this.knobs = knobs;
		this.neckPickup = neckPickup;
		this.middlePickup = middlePickup;
		this.tuners = tuners;
	}
	public void setID(int ID)
	{
		this.ID = ID;
	}
	public int getID()
	{
		return this.ID;
	}
	public void setBridge(String bridge)
	{
		this.bridge = bridge;
	}
	public String getBridge()
	{
		return this.bridge;
	}
	public void setBridgePickup(String bridgePickup)
	{
		this.bridgePickup = bridgePickup;
	}
	public String getBridgePickup()
	{
		return this.bridgePickup;
	}
	public void setKnobs(String knobs)
	{
		this.knobs = knobs;
	}
	public String getKnobs()
	{
		return this.knobs;
	}
	public void setneckPickup(String neckPickup)
	{
		this.neckPickup = neckPickup;
	}
	public String getNeckPickup()
	{
		return this.neckPickup;
	}
	public void setMiddlePickup(String middlePickup)
	{
		this.middlePickup = middlePickup;
	}
	public String getMiddlePickup()
	{
		return this.middlePickup;
	}
	public void setTuners(String tuners)
	{
		this.tuners = tuners;
	}
	public String getTuners()
	{
		return this.tuners;
	}

}
