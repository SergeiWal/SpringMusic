package com.valko.SpringMusic.Controller;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.Song;
import com.valko.SpringMusic.Service.PlaylistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = "/playlists")
public class PlaylistRestController {

    @Autowired
    private PlaylistService playlistService;


    @GetMapping
    List<Playlist> getPlaylists(){
        return playlistService.findAll();
    }

    @GetMapping(value = "/{id}")
    Playlist getOnePlaylist(@PathVariable long id){
        return  playlistService.findOnePlaylist(id);
    }

    @GetMapping(value = "/{id}/songs")
    Set<Song> getSongsFromPlaylist(@PathVariable long id){
        return playlistService.findSongsForPlaylist(id);
    }

    @PostMapping(value = "/{owner_id}")
    Playlist savePlaylistWithOwner(@RequestBody Playlist playlist,@PathVariable long owner_id){
        return playlistService.save(playlist,owner_id);
    }

    @PostMapping(value = "/{playlist_id}/songs/{song_id}")
    Playlist addSongToPlaylist(@PathVariable long playlist_id, @PathVariable long song_id){
        return playlistService.addSongToPlaylist(playlist_id,song_id);
    }

    @DeleteMapping(value = "/{id}")
    long  deletePlaylistById(@PathVariable long id){
        return playlistService.deletePlaylist(id);
    }


    @DeleteMapping(value ="/{playlist_id}/songs/{song_id}" )
    Playlist deleteSongFromPlaylist(@PathVariable long playlist_id, @PathVariable long song_id){
        return  playlistService.deleteSongFromPlaylist(playlist_id,song_id);
    }
}
