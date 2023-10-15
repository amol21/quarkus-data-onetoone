import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jdk.javadoc.doclet.Reporter;
import org.data.entity.Laptop;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Path("/laptop")
public class LaptopResource {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLaptops()
    {
        List<Laptop> laptopList=Laptop.listAll();
        return Response.ok(laptopList).build();
    }
    @POST
    @Path("/laptop")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveLaptop(Laptop laptop)
    {
        Laptop.persist(laptop);
        if(laptop.isPersistent())
        {
            return Response.created(URI.create("/laptop/"+laptop.id)).build();
        }
        else
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Path("/{id}")
    public Response getLaptopbyId(@PathParam("id") Long id){
        Laptop laptop=Laptop.findById(id);
        return Response.ok(laptop).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateLaptopbyId(@PathParam("id") Long id,Laptop laptop)
    {
        Optional<Laptop> laptopexist=Laptop.findByIdOptional(id);
        if(laptopexist.isPresent())
        {
            Laptop existedlaptop=laptopexist.get();
            if(Objects.nonNull(existedlaptop.getBrand()))
            {
                existedlaptop.setBrand(laptop.getBrand());
            }
            if(Objects.nonNull(existedlaptop.getBrand()))
            {
                existedlaptop.setName(laptop.getName());
            }
            if(Objects.nonNull(existedlaptop.getRam()))
            {
                existedlaptop.setRam(laptop.getRam());
            }
            if(Objects.nonNull(existedlaptop.getExternalStorage()))
            {
                existedlaptop.setExternalStorage(laptop.getExternalStorage());
            }
            existedlaptop.persist();
            if(existedlaptop.isPersistent())
            {
                return Response.created(URI.create("/laptop/"+id)).build();
            }else
            {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }else
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id")Long id)
    {
       boolean isDeleted=Laptop.deleteById(id);
       if(isDeleted)
       {
           return Response.noContent().build();
       }else {
           return Response.status(Response.Status.BAD_REQUEST).build();
       }
    }
}
