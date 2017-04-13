package com.library.domain;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mgil on 4/13/17.
 */
@Data
@Entity
public class Hike {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    private String description;
    private Date date;
    private BigDecimal dificulty;

//    @JoinColumn(name = "id")
//    @ManyToOne
//    private Person organizer;

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
        int result = 31 * description.hashCode() + 31 * date.hashCode() + 31 * dificulty.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Hike{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", dificulty=" + dificulty +
                '}';
    }
}
