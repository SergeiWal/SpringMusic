package com.valko.SpringMusic.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Playlists")
@Data
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;


    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User owner;


    @ManyToMany
    @JoinTable(
            name="SongPlaylists",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> songs = new HashSet<>() ;

    public Playlist(){}

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void addSongToPlaylist(Song song){
        songs.add(song);
    }
    public void removeSongFromPlaylist(Song song){
        songs.remove(song);

    }

    public void removeSong(Song song){
        this.getSongs().remove(song);
        song.getPlaylists().remove(this);
    }
}
