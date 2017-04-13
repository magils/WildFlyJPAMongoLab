package com.library.enpoint;

import com.library.dao.PersonDAO;
import com.library.domain.Person;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by mgil on 4/13/17.
 */
@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonEndpoint {

    @EJB
    private PersonDAO personDAO;

    @GET
    public List<Person> getAllPersons(){
        List<Person> persons = personDAO.findAll();
        return persons;
    }

    @POST
    public void createPerson(Person person){

        if(person == null){
            throw new IllegalArgumentException("The person cannot be empty!");
        }

        personDAO.create(person);
    }

}
