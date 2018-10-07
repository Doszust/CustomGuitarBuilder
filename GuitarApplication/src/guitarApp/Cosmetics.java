package guitarApp;
/**
 * @author Dylan Oszust
 * 3/12/2017
 * 
 * This class creates a Cosmetic profile for the guitar 
 *
 */
public class Cosmetics
{
	int ID;
	String bodyColor;
	String neckColor;
	String hardwareColor;
	String bindingColor;
	String markerType;
	String markerColor;
	char fretMarkers;
	
	/**
	 * Default Constructor
	 */
	public Cosmetics()
	{
		ID = 0;
		bodyColor = null;
		neckColor = null;
		hardwareColor = null;
		bindingColor = null;
		markerType = null;
		markerColor = null;
		fretMarkers = 'N';
	}
	
	/**
	 * Takes in user input and creates a cosmetic profile from it
	 * 
	 * @param ID
	 * ID of the cosmetic profile
	 * @param bodyColor
	 * Color of the guitar body
	 * @param neckColor
	 * Color of the guitar nect
	 * @param hardwareColor
	 * color of the hardware
	 * @param bindingColor
	 * color of the binding, if any.  If there is no binding, color is N/A
	 * @param fretMarkers
	 * rather or not makers will be on the fret board
	 * @param markerType
	 * type of markers inlaid on the fret board
	 * @param markerColor
	 * color of markers on fret board
	 */
	public Cosmetics(int ID, String bodyColor, String neckColor, String hardwareColor,
			String bindingColor, char fretMarkers, String markerType, String markerColor)
	{
		this.ID = ID;
		this.bodyColor = bodyColor;
		this.neckColor = neckColor;
		this.hardwareColor = hardwareColor;
		this.bindingColor = bindingColor;
		this.fretMarkers = fretMarkers;
		this.markerType = markerType;
		this.markerColor = markerColor;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public int getID()
	{
		return ID;
	}
	
	public void setbodyColor(String bodyColor)
	{
		this.bodyColor = bodyColor;
	}
	
	public String getBodyColor()
	{
		return bodyColor;
	}
	
	public void setNeckColor(String neckColor)
	{
		this.neckColor = neckColor;
	}
	
	public String getNeckColor()
	{
		return neckColor;
	}
	
	public void setHardwareColor(String hardwareColor)
	{
		this.hardwareColor = hardwareColor;
	}
	
	public String getHardwareColor()
	{
		return hardwareColor;
	}
	
	public void setBindingColor(String bindingColor)
	{
		this.bindingColor = bindingColor;
	}
	
	public String getBindingColor()
	{
		return bindingColor;
	}
	
	public void setFretMarkers(char fretMarkers)
	{
		this.fretMarkers = fretMarkers;
	}
	
	public char getFretMarkers()
	{
		return fretMarkers;
	}
	
	public void setMarkerType(String markerType)
	{
		this.markerType = markerType;
	}
	
	public String getMarkerType()
	{
		return markerType;
	}
	
	public void setMarkerColor(String markerColor)
	{
		this.markerColor = markerColor;
	}
	
	public String getMarkerColor()
	{
		return markerColor;
	}
	
}
