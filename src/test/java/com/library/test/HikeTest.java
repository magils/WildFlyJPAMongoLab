package com.library.test;

import com.library.domain.Hike;
import com.library.domain.Person;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by mgil on 4/13/17.
 */
public class HikeTest {

    private static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void setUpEntityManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory("hikePu");
    }

    @Test
    public void persistAndShow(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

        Person person = new Person();

        person.setFirstName("Moises");
        person.setLastName("Gil");

        Hike h1 = new Hike();

        h1.setDescription("Visting Pico Duarte");
        h1.setDate(new Date());
        h1.setDificulty(BigDecimal.ONE);
        h1.setOrganizer(person);


        Hike h2 = new Hike();

        h2.setDescription("Visting La Montana");
        h2.setDate(new Date());
        h2.setDificulty(BigDecimal.TEN);
        h2.setOrganizer(person);

        person.setOrganizedHikes(new HashSet<Hike>());

        person.getOrganizedHikes().add(h1);
        person.getOrganizedHikes().add(h2);


        entityManager.persist(person);

        entityManager.getTransaction().commit();


        List<Person> people = entityManager.createNamedQuery("Person.findAll",Person.class).getResultList();

        for(Person p : people){
            System.out.println(p);
        }

        entityManager.close();

    }

    @AfterClass
    public static void closeEntityManager(){
        entityManagerFactory.close();
    }
}
