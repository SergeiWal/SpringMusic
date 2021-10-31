package com.valko.SpringMusic.Controller;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.Song;
import com.valko.SpringMusic.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/songs")
public class SongRestController{

    @Autowired
    SongRepository songRepository;

    @GetMapping
    List<Song> getSongs(){
        return (List<Song>) songRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    Song getOneSong(@PathVariable long id){
        return  songRepository.findById(id).get();
    }

    @PostMapping
    Song saveSong(@RequestBody Song song){
        songRepository.save(song);
        return song;
    }

    @DeleteMapping(value = "/{id}")
    Song deleteSongById(@PathVariable long id){
        Song song = songRepository.findById(id).get();
        songRepository.deleteById(id);
        return song;
    }

    @DeleteMapping
    Song deleteSong(@RequestBody Song song){
        songRepository.delete(song);
        return song;
    }
}
