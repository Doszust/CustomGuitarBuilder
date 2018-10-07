/**
 * @author Dylan Oszust
 * 3/12/2017
 * This class creates Cosmetic Objects
 *
 */

package guitarApp;

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
		return this.ID;
	}
	public void setbodyColor(String bodyColor)
	{
		this.bodyColor = bodyColor;
	}
	public String getBodyColor()
	{
		return this.bodyColor;
	}
	public void setNeckColor(String neckColor)
	{
		this.neckColor = neckColor;
	}
	public String getNeckColor()
	{
		return this.neckColor;
	}
	public void setHardwareColor(String hardwareColor)
	{
		this.hardwareColor = hardwareColor;
	}
	public String getHardwareColor()
	{
		return this.hardwareColor;
	}
	public void setBindingColor(String bindingColor)
	{
		this.bindingColor = bindingColor;
	}
	public String getBindingColor()
	{
		return this.bindingColor;
	}
	public void setFretMarkers(char fretMarkers)
	{
		this.fretMarkers = fretMarkers;
	}
	public char getFretMarkers()
	{
		return this.fretMarkers;
	}
	public void setMarkerType(String markerType)
	{
		this.markerType = markerType;
	}
	public String getMarkerType()
	{
		return this.markerType;
	}
	public void setMarkerColor(String markerColor)
	{
		this.markerColor = markerColor;
	}
	public String getMarkerColor()
	{
		return this.markerColor;
	}
	
}
