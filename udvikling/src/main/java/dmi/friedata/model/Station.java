package dmi.friedata.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Station {

	private String navn;
	private String id;
	
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
