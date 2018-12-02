package dmi.friedata.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dmi.friedata.model.SneMaaling;
import dmi.friedata.model.Station;
import dmi.friedata.model.TemperaturMaaling;

public class RepositoryHadoopHive implements Repository {

	List<TemperaturMaaling> temperaturMaalinger = new ArrayList<TemperaturMaaling>();
	List<SneMaaling> sneMaalinger = new ArrayList<SneMaaling>();

	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	
	@Override
	public Connection getConnection() throws SQLException 
	{
	
		try {
	
			Class.forName(driverName);
		    } catch (ClassNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      System.exit(1);
		}
		
		//Connection con = DriverManager.getConnection("jdbc:hive2://172.25.6.220:10000/;authMechanism=PLAIN;database='obsdb'", "root", "dmipassword"); //
		Connection con = DriverManager.getConnection("jdbc:hive2://f3.ilxd-dmi.dk:10000/;authMechanism=PLAIN;database='obsdb'", "root", "dmipassword");
		return con;
	}

	private static class SingletonHolder {
		
		private static final RepositoryHadoopHive INSTANCE = new RepositoryHadoopHive();
	}
	
	public static RepositoryHadoopHive getInstance() {
        return SingletonHolder.INSTANCE;
    }	
		

	TemperaturMaaling  lavTemperaturMaaling(
		TemperaturMaaling temperaturMaaling,
		String id,
		Station station,
		long datotid,
		int min_temperatur,
		int max_temperatur)
	{
		temperaturMaaling.setId(id);
		temperaturMaaling.setStation(station);
		temperaturMaaling.setDatotid(datotid);		
		temperaturMaaling.setMin_temperatur(min_temperatur);
		temperaturMaaling.setMax_temperatur(max_temperatur);
		
		return temperaturMaaling;
	}
	
	Station lavStation(Station station,
			String id,
			String navn)
	{
		station.setId(id);
		station.setNavn(navn);
		
		return station;
	}
	
	@Override
	public void indlaesAlleTemperaturMaalinger() {
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from obsdb.temp_wind_radiation limit 100";
			ResultSet res = stmt.executeQuery(sql);
			
		    while (res.next()) {
		    				  
		      temperaturMaalinger.add(lavTemperaturMaaling(new TemperaturMaaling(),
		    		  		  res.getString("insid"),
		    		  		  lavStation(new Station(),Integer.toString(res.getInt("statid")),"stationsnavn"),
		    				  Long.parseLong(res.getString("timeobs").replaceAll("[\\s|:]", "").replaceAll("-","")),
		    				  (int) res.getInt("temp_dry"),
		    				  (int) res.getInt("temp_dry")
		    				  //res.getInt("temp_max_past12h_qc1"),		    				  
		    				  //res.getInt("temp_min_past12h_qc1")
		    				  ));
		      
		      System.out.println(res.getString(1) + "\t" + res.getString(2));
		      
		      
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

	}
	
	public RepositoryHadoopHive() {
		super();
		indlaesAlleTemperaturMaalinger();
	}

	@Override
	public List<SneMaaling> findAlleSneMaalinger() {
		return null;
	}

	@Override
	public void indlaesAlleSneMaalinger() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SneMaaling findSneMaaling(long insId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TemperaturMaaling> findAlleTemperaturMaalinger() {
						
		return temperaturMaalinger;
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
	

}
