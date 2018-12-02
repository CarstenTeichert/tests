package dmi.friedata;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dmi.friedata.model.SneMaaling;
import dmi.friedata.model.TemperaturMaaling;
import dmi.friedata.repository.Repository;
import dmi.friedata.repository.RepositoryNoDBStub;

@Path("snemaalinger") //http:localhost:8080/frie-data/webapi/snemaalinger
public class SneMaalingResource {

	private Repository sneMaalingRepository = RepositoryNoDBStub.getInstance();

	@GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<SneMaaling>  getAlleSneMaalinger()  {
        return sneMaalingRepository.findAlleSneMaalinger();
    }
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{insId}") //http:localhost:8080/frie-data/webapi/snemaalinger/-2029836323
	public SneMaaling getSnemaaling(@PathParam ("insId") long insId) {
		return sneMaalingRepository.findSneMaaling(insId);
	}
}
