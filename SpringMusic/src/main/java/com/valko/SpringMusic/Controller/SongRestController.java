package com.valko.SpringMusic.Controller;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.Song;
import com.valko.SpringMusic.Repository.PlaylistRepository;
import com.valko.SpringMusic.Repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = "/songs")
public class SongRestController{

    @Autowired
    SongRepository songRepository;

    @Autowired
    PlaylistRepository playlistRepository;

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
    Long deleteSongById(@PathVariable long id){
        Song song = songRepository.findById(id).get();
        for(Playlist playlist: song.getPlaylists()){
            song.removePlaylist(playlist);
        }
        songRepository.delete(song);
        return id;
    }

}
