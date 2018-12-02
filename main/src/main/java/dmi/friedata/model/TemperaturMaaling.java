package dmi.friedata.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TemperaturMaaling {

	private String id;
	private Station station;
	private long datotid;
	private int min_temperatur;
	private int max_temperatur;

	public Station getStation() {
		// TODO Auto-generated method stub
		return station;
	}	
	public void setStation(Station station) {
		this.station = station;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement(name="datotid")
	public long getDatotid() {
		return datotid;
	}
	public void setDatotid(long datotid) {
		this.datotid = datotid;
	}
	public int getMin_temperatur() {
		return min_temperatur;
	}
	public void setMin_temperatur(int min_temperatur) {
		this.min_temperatur = min_temperatur;
	}
	
	public int getMax_temperatur() {
		return max_temperatur;
	}
	public void setMax_temperatur(int max_temperatur) {
		this.max_temperatur = max_temperatur;
	}
	
}
