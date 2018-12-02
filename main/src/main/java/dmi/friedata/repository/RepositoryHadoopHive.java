package dmi.friedata.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dmi.friedata.model.SneMaaling;
import dmi.friedata.model.TemperaturMaaling;

public class RepositoryHadoopHive implements Repository {
	
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	
	@Override
	public List<TemperaturMaaling> findAlleTemperaturMaalinger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemperaturMaaling findTemperaturMaaling(long datoTid) {
		// TODO Auto-generated method stub
		return null;
	}

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
		
		Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "hive", "");
		//Connection con = DriverManager.getConnection("jdbc:hive2://sandbox-hdp.hortonworks.com:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2;", "", "");
	    return con;
		      
	}

	@Override
	public void indlaesAlleTemperaturMaalinger() {
		// TODO Auto-generated method stub
		
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

	

}
