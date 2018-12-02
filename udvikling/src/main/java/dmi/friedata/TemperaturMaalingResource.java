package dmi.friedata;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dmi.friedata.model.TemperaturMaaling;
import dmi.friedata.model.Station;
import dmi.friedata.repository.Repository;
import dmi.friedata.repository.RepositoryHadoopHive;
import dmi.friedata.repository.RepositoryNoDBStub;

@Path("temperaturmaalinger") //http:localhost:8080/frie-data/webapi/temperaturmaalinger
public class TemperaturMaalingResource {

	//private Repository temperaturMaalingRepository = RepositoryNoDBStub.getInstance();
	private Repository temperaturMaalingRepository = RepositoryHadoopHive.getInstance();

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<TemperaturMaaling> getAlltemperaturmaalinger() {
		return temperaturMaalingRepository.findAlleTemperaturMaalinger();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{temperaturmaalingId}") //http:localhost:8080/frie-data/webapi/temperaturmaalinger/19790101
	public TemperaturMaaling gettemperaturmaaling(@PathParam ("temperaturmaalingId") long temperaturmaalingId) {
		return temperaturMaalingRepository.findTemperaturMaaling(temperaturmaalingId);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/station") //http:localhost:8080/frie-data/webapi/temperaturmaalinger/1/station
	public Station gettemperaturmaalingUser(@PathParam ("temperaturmaalingId") int temperaturmaalingId) {
		
		TemperaturMaaling temperaturMaaling = temperaturMaalingRepository.findTemperaturMaaling(temperaturmaalingId);
		Station station = temperaturMaaling.getStation();
		return station;
		//return temperaturmaalingRepository.findtemperaturmaaling(temperaturmaalingId).getUser();
	}
	
}
