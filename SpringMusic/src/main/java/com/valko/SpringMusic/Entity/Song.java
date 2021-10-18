package com.valko.SpringMusic.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Songs")
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 4, max = 32, message = "Songs name have length from 4 to 32 symbols")
    private String name;

    @Column
    @Size(min = 4, max = 32, message = "Author name have length from 4 to 32 symbols")
    private String author;

    @Column
    @Size(min = 4, max = 32, message = "Album name have length from 4 to 32 symbols")
    private String album;

    @Column
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column
    @Size(min=0)
    private int rating;

    @Column
    @NotNull(message = "Cannot be null")
    private String source;

    public Song(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}