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
	int ID; //ID for the database
	String bodyColor; 
	String neckColor;
	String hardwareColor;
	String bindingColor;
	String markerType;
	String markerColor;
	char fretMarkers; //'Y' or 'N' to state rather guitar will have fret markers.
	
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

	/**
	 * Saves user chosen ID locally
	 * 
	 * @param ID
	 * Unique Identifier for the cosmetic profile
	 */
	public void setID(int ID)
	{
		this.ID = ID;
	}

	/**
	 * Returns the ID of the cosmetic profile
	 * 
	 * @return ID
	 */
	public int getID()
	{
		return ID;
	}
	
	/**
	 * Saves chosen body color locally
	 * 
	 * @param bodyColor
	 * Color of the guitar body
	 */
	public void setbodyColor(String bodyColor)
	{
		this.bodyColor = bodyColor;
	}
	
	/**
	 * Returns the bodyColor
	 * 
	 * @return bodyColor
	 */
	public String getBodyColor()
	{
		return bodyColor;
	}
	
	/**
	 * Saves chosen neck color locally
	 * 
	 * @param neckColor
	 */
	public void setNeckColor(String neckColor)
	{
		this.neckColor = neckColor;
	}
	
	/**
	 * Returns color of the neck
	 * 
	 * @return neckColor
	 */
	public String getNeckColor()
	{
		return neckColor;
	}
	
	/**
	 * Saves chosen hardware color locally
	 * 
	 * @param hardwareColor
	 */
	public void setHardwareColor(String hardwareColor)
	{
		this.hardwareColor = hardwareColor;
	}
	
	/**
	 * Returns color of the hardware
	 * 
	 * @return hardwareColor
	 */
	public String getHardwareColor()
	{
		return hardwareColor;
	}
	
	/**
	 * Saves chosen color of the binding locally
	 * 
	 * @param bindingColor
	 */
	public void setBindingColor(String bindingColor)
	{
		this.bindingColor = bindingColor;
	}
	
	/**
	 * Returns the color of the binding
	 * 
	 * @return bindingColor
	 */
	public String getBindingColor()
	{
		return bindingColor;
	}
	
	/**
	 * Saves the fret marker option locally
	 * 
	 * @param fretMarkers
	 */
	public void setFretMarkers(char fretMarkers)
	{
		this.fretMarkers = fretMarkers;
	}
	
	/**
	 * Returns if fret markers are going to be on the guitar
	 * 
	 * @return fretMarkers
	 */
	public char getFretMarkers()
	{
		return fretMarkers;
	}
	
	/**
	 * Saves the type of the fret markers locally
	 * 
	 * @param markerType
	 */
	public void setMarkerType(String markerType)
	{
		this.markerType = markerType;
	}
	
	/**
	 * Returns chosen type of the fret markers
	 * 
	 * @return markerType
	 */
	public String getMarkerType()
	{
		return markerType;
	}
	
	/**
	 * Saves color of the markers locally
	 * 
	 * @param markerColor
	 */
	public void setMarkerColor(String markerColor)
	{
		this.markerColor = markerColor;
	}
	
	/**
	 * Returns the color of the markers
	 * 
	 * @return markerColor
	 */
	public String getMarkerColor()
	{
		return markerColor;
	}
	
}
