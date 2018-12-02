package dmi.friedata.repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dmi.friedata.model.TemperaturMaaling;
import dmi.friedata.model.SneMaaling;
import dmi.friedata.model.Station;

public class RepositoryNoDBStub implements Repository {
		
	private static class SingletonHolder {
		
		private static final RepositoryNoDBStub INSTANCE = new RepositoryNoDBStub();
	}
	
	public static RepositoryNoDBStub getInstance() {
        return SingletonHolder.INSTANCE;
    }
		
	List<TemperaturMaaling> temperaturMaalinger = new ArrayList<TemperaturMaaling>();
	List<SneMaaling> sneMaalinger = new ArrayList<SneMaaling>();
	
	@Override
	public List<TemperaturMaaling> findAlleTemperaturMaalinger () {
				
		return temperaturMaalinger;
	}

	@Override
	public List<SneMaaling> findAlleSneMaalinger() {

		return sneMaalinger;
	}
	
	@Override
	public Connection getConnection() {
		return null;
	}

	@Override
	public void indlaesAlleTemperaturMaalinger() {
				
		TemperaturMaaling temperaturMaaling1 = new TemperaturMaaling();
		
		Station station = new Station();
		station.setId("1");
		station.setNavn("Aaabenraa");
		
		temperaturMaaling1.setStation(station);
		temperaturMaaling1.setDatotid(19790101);
		temperaturMaaling1.setMax_temperatur(-6);
		temperaturMaaling1.setMin_temperatur(-13);
		
		temperaturMaalinger.add(temperaturMaaling1);
		
		TemperaturMaaling temperaturMaaling2 = new TemperaturMaaling();
		
		temperaturMaaling2.setStation(station);
		temperaturMaaling2.setDatotid(19790102);
		temperaturMaaling2.setMax_temperatur(-3);
		temperaturMaaling2.setMin_temperatur(-10);
		
		temperaturMaalinger.add(temperaturMaaling2);
		
	}


	@Override
	public void indlaesAlleSneMaalinger() {
		// select * from snow_man where snow_man.timeobs > '1979-01-01 07:00:00' and snow_man.snow_depth_man > 140 and snow_man.snow_depth_man < 150 limit 100
		SneMaaling sneMaaling = new SneMaaling();
		sneMaalinger.add(sneMaaling);

		SneMaaling sneMaaling2 = new SneMaaling();		
		sneMaaling = lavSneMaaling(sneMaaling2,-2029836327,3421950,"1980-04-28 07:00:00", 	true, 	143.0, 	0, 	4.0, 	0);
		sneMaalinger.add(sneMaaling2);
		
		SneMaaling sneMaaling3 = new SneMaaling();		
		sneMaaling = lavSneMaaling(sneMaaling3,-2029836323,3421950,"1980-05-02 07:00:00", 	true, 	142.0, 	0, 	4.0, 	0);
		sneMaalinger.add(sneMaaling3);
		
		SneMaaling sneMaaling4 = new SneMaaling();		
		sneMaaling = lavSneMaaling(sneMaaling4,-2029836322,3421950,"1980-05-03 07:00:00", 	true, 	142.0, 	0, 	4.0, 	0);
		sneMaalinger.add(sneMaaling4);
		
		SneMaaling sneMaaling5 = new SneMaaling();		
		sneMaaling = lavSneMaaling(sneMaaling5,-2029836328, 3421950, "1980-04-27 07:00:00", true, 143.0, 0, 4.0, 0);		
		sneMaalinger.add(sneMaaling5);
		
		SneMaaling sneMaaling6 = new SneMaaling();		
		sneMaaling = lavSneMaaling(sneMaaling6,-2030233223,2144050,"1995-02-01 07:00:00", 	true, 	145.0, 	0, 	0.0, 	0);
		sneMaalinger.add(sneMaaling6);
		
	}

	SneMaaling lavSneMaaling(SneMaaling sneMaaling,
			int insid, long statid, String timeobs, boolean best, double snow_depth_man,
			int snow_depth_man_qc1, double snow_cover_man, int snow_cover_man_qc1)
	{
		sneMaaling.setInsid(insid);
		sneMaaling.setStatid(statid);
		sneMaaling.setTimeobs(timeobs);
		sneMaaling.setBest(best);
		sneMaaling.setSnow_depth_man(snow_depth_man);
		sneMaaling.setSnow_depth_man_qc1(snow_depth_man_qc1);
		sneMaaling.setSnow_cover_man(snow_cover_man);
		sneMaaling.setSnow_cover_man_qc1(snow_cover_man_qc1);		
		return sneMaaling;
	}
	
	public RepositoryNoDBStub() {
		super();
		indlaesAlleTemperaturMaalinger();
		indlaesAlleSneMaalinger();
	}
	
	@Override
	public TemperaturMaaling findTemperaturMaaling(long datoTid) {
				
		 for (TemperaturMaaling temperaturMaaling : temperaturMaalinger) {
		        if (temperaturMaaling.getDatotid()==datoTid) {
		            return temperaturMaaling;
		        }
		    }
		 return null;
	}

	@Override
	public SneMaaling findSneMaaling(long insId) {
		
		 for (SneMaaling sneMaaling : sneMaalinger) {
		        if (sneMaaling.getInsid()==insId) {
		            return sneMaaling;
		        }
		    }
		 return null;
	}


}
