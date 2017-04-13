package com.library.dao;

import com.library.domain.Person;

import javax.ejb.Singleton;

/**
 * Created by mgil on 4/13/17.
 */
@Singleton
public class PersonDAO extends DAO<Person> {
    public PersonDAO() {
        super(Person.class);
    }
}
