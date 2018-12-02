package dmi.friedata;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "friedata" path)
 */
@Path("friedata")
public class FrieDataResource {

    /** 
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
   
	//http:localhost:8080/frie-data/webapi/friedata
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hej frie data!";
    }
}
