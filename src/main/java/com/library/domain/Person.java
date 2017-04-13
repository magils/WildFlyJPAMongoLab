package com.library.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mgil on 4/13/17.
 */

@Data
@Entity
@NamedQueries({
        @NamedQuery(name="Person.findAll",query = "SELECT P FROM Person P")
})
public class Person {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private String id;
    private String firstName;
    private String lastName;

//    @OneToMany(mappedBy = "organizer" ,cascade = CascadeType.PERSIST)
//    private Set<Hike> organizedHikes;

    @Override
    public boolean equals(Object o) {

        if(o == this){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 31 * firstName.hashCode() + 31 * lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
