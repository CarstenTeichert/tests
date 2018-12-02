package dmi.friedata.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dmi.friedata.model.SneMaaling;
import dmi.friedata.model.TemperaturMaaling;

public interface Repository {
	
	Connection getConnection() throws SQLException;
	
	void indlaesAlleTemperaturMaalinger();
	
	void indlaesAlleSneMaalinger();

	TemperaturMaaling findTemperaturMaaling(long datoTid);

	List<TemperaturMaaling> findAlleTemperaturMaalinger();

	List<SneMaaling> findAlleSneMaalinger();

	SneMaaling findSneMaaling(long insId);

}