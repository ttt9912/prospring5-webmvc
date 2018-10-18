package ch16.entities;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Singer implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String description;
}
