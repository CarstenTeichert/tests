package dmi.testDatabase;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import dmi.friedata.repository.Repository;
import dmi.friedata.repository.RepositoryHadoopHive;
import dmi.friedata.repository.RepositoryNoDBStub;

public class DatabaseTest {
	
	@Test
	public void testConnectHadoopHive()
	{		
		RepositoryHadoopHive db = RepositoryHadoopHive.getInstance();
		Connection con= null;
		try {
			con = db.getConnection();
			String catalog = con.getCatalog();		
			db.indlaesAlleTemperaturMaalinger(); 
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
			
		assert(con!=null);
	}	
	
	@Test
	public void testIndlaesRepositoryNoDBStub()
	{
		Repository sneMaalingRepository = RepositoryNoDBStub.getInstance();		
		sneMaalingRepository.indlaesAlleSneMaalinger();
		assert(sneMaalingRepository.findAlleSneMaalinger().size()>0);
	}	
}
