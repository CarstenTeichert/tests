package dmi.friedata.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SneMaaling {  
	// fra tabel obsdb.snow_man

	private int insid;
	
	private long statid;
	
	private String timeobs;
	
	private boolean best;
	
	private double snow_depth_man;
	
	private int snow_depth_man_qc1;
	
	private double snow_cover_man;
	
	private int snow_cover_man_qc1;
	
	@XmlElement(name="insid")
	public int getInsid() {
		return insid;
	}
	public void setInsid(int insid) {
		this.insid = insid;
	}
	public long getStatid() {
		return statid;
	}
	public void setStatid(long statid) {
		this.statid = statid;
	}
	public String getTimeobs() {
		return timeobs;
	}
	public void setTimeobs(String timeobs) {
		this.timeobs = timeobs;
	}
	public boolean isBest() {
		return best;
	}
	public void setBest(boolean best) {
		this.best = best;
	}
	public double getSnow_depth_man() {
		return snow_depth_man;
	}
	public void setSnow_depth_man(double snow_depth_man) {
		this.snow_depth_man = snow_depth_man;
	}
	public int getSnow_depth_man_qc1() {
		return snow_depth_man_qc1;
	}
	public void setSnow_depth_man_qc1(int snow_depth_man_qc1) {
		this.snow_depth_man_qc1 = snow_depth_man_qc1;
	}
	public double getSnow_cover_man() {
		return snow_cover_man;
	}
	public void setSnow_cover_man(double snow_cover_man) {
		this.snow_cover_man = snow_cover_man;
	}
	public int getSnow_cover_man_qc1() {
		return snow_cover_man_qc1;
	}
	public void setSnow_cover_man_qc1(int snow_cover_man_qc1) {
		this.snow_cover_man_qc1 = snow_cover_man_qc1;
	}

//	public SneMaaling(int insid, long statid, String timeobs, boolean best, double snow_depth_man,
//			int snow_depth_man_qc1, double snow_cover_man, int snow_cover_man_qc1) {
//		super();
//		this.insid = insid;
//		this.statid = statid;
//		this.timeobs = timeobs;
//		this.best = best;
//		this.snow_depth_man = snow_depth_man;
//		this.snow_depth_man_qc1 = snow_depth_man_qc1;
//		this.snow_cover_man = snow_cover_man;
//		this.snow_cover_man_qc1 = snow_cover_man_qc1;
//	}	
}
