package com.valko.SpringMusic.Controller;
import com.valko.SpringMusic.Entity.Song;
import com.valko.SpringMusic.Repository.PlaylistRepository;
import com.valko.SpringMusic.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/songs")
public class SongRestController{

    @Autowired
    SongService songService;

    @Autowired
    PlaylistRepository playlistRepository;

    @GetMapping
    List<Song> getSongs(){
        return songService.findAll();
    }

    @GetMapping(value = "/{id}")
    Song getOneSong(@PathVariable long id){
        return songService.findOneSongById(id);
    }

    @PostMapping
    Song saveSong(@RequestBody Song song){
        return songService.saveSong(song);
    }

    @DeleteMapping(value = "/{id}")
    Long deleteSongById(@PathVariable long id){
        return songService.deleteSongByID(id);
    }

}
