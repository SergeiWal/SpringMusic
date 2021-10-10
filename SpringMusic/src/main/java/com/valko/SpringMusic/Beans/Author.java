package com.valko.SpringMusic.Beans;

import lombok.Data;
import org.hibernate.engine.internal.ImmutableEntityEntry;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Size(min=4, max = 32, message = "Author name have length from 4 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String name;

    @Column
    @Size(min = 0)
    private int rating;

    public Author(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
