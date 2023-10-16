import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.data.entity.Aadhar;
import org.data.entity.Citizen;
import org.data.repository.AddharRepository;
import org.data.repository.CitizenReposity;

import java.lang.annotation.Repeatable;

@Path("/")
public class Resource {

    @Inject
    AddharRepository addharRepository;
    @Inject
    CitizenReposity citizenReposity;
    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveaddhar() {
        Citizen citizen = new Citizen();
        citizen.setName("micke");
        citizen.setGender("m");

        Aadhar aadhar = new Aadhar();
        aadhar.setCompany("abc");
        aadhar.setAadharNumber(298392323L);
        aadhar.setCitizen(citizen);
        citizen.setAadhar(aadhar);
        citizenReposity.persist(citizen);
        return Response.ok(citizen).build();
        /*if (citizenReposity.isPersistent(citizen)) {
            addharRepository.persist(aadhar);

            if (addharRepository.isPersistent(aadhar)) {
                return Response.ok(aadhar).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

        }else
        {
            return  Response.status(Response.Status.BAD_REQUEST).build();
        }*/
    }
@GET
@Path("/citizen")
    public Response getcitizenData()
    {
        Citizen citizen=citizenReposity.findById(1L);
        if(citizen.getId()!=null)
        {
            return Response.ok(citizen).build();
        }else
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
