package com.valko.SpringMusic.Controller;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.Song;
import com.valko.SpringMusic.Entity.User;
import com.valko.SpringMusic.Repository.PlaylistRepository;
import com.valko.SpringMusic.Repository.SongRepository;
import com.valko.SpringMusic.Repository.UserRepository;
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
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    List<Playlist> getPlaylists(){
        return (List<Playlist>)playlistRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    Playlist getOnePlaylist(@PathVariable long id){
        return  playlistRepository.findById(id).get();
    }

    @GetMapping(value = "/{id}/songs")
    Set<Song> getSongsFromPlaylist(@PathVariable long id){
        Playlist playlist = playlistRepository.findById(id).get();
        return playlist.getSongs();
    }

//    @PostMapping
//    Playlist savePlaylist( @RequestBody Playlist playlist){
//        playlistRepository.save(playlist);
//        return playlist;
//    }

    @PostMapping(value = "/{owner_id}")
    Playlist savePlaylistWithOwner(@RequestBody Playlist playlist,@PathVariable long owner_id){
        User user = userRepository.findById(owner_id).get();
        playlist.setOwner(user);
        playlistRepository.save(playlist);
        return playlist;
    }

    @PostMapping(value = "/{playlist_id}/songs/{song_id}")
    Playlist addSongToPlaylist(@PathVariable long playlist_id, @PathVariable long song_id){
        Song song = songRepository.findById(song_id).get();
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        playlist.addSongToPlaylist(song);
        return playlistRepository.save(playlist);
    }

    @DeleteMapping(value = "/{id}")
    long  deletePlaylistById(@PathVariable long id){
        playlistRepository.deleteById(id);
        return id;
    }


    @DeleteMapping(value ="/{playlist_id}/songs/{song_id}" )
    Playlist deleteSongFromPlaylist(@PathVariable long playlist_id, @PathVariable long song_id){
        Song song = songRepository.findById(song_id).get();
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        playlist.removeSongFromPlaylist(song);
        return  playlistRepository.save(playlist);
    }
}
