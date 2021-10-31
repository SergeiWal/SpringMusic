package com.valko.SpringMusic.Controller;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.Song;
import com.valko.SpringMusic.Repository.PlaylistRepository;
import com.valko.SpringMusic.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistRestController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongRepository songRepository;

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

    @PostMapping
    Playlist savePlaylist(@RequestBody Playlist playlist){
        playlistRepository.save(playlist);
        return playlist;
    }

    @PostMapping(value = "/{playlist_id}/songs/{song_id}")
    Set<Song> addSongToPlaylist(@PathVariable long playlist_id, @PathVariable long song_id){
        Song song = songRepository.findById(song_id).get();
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        playlist.addSongToPlaylist(song);
        return playlist.getSongs();
    }

    @DeleteMapping(value = "/{id}")
    Playlist deletePlaylistById(@PathVariable long id){
        Playlist playlist = playlistRepository.findById(id).get();
        playlistRepository.deleteById(id);
        return playlist;
    }

    @DeleteMapping
    Playlist deletePlaylist(@RequestBody Playlist playlist){
        playlistRepository.delete(playlist);
        return playlist;
    }

    @DeleteMapping(value ="/{playlist_id}/songs/{song_id}" )
    Set<Song> deleteSongFromPlaylist(@PathVariable long playlist_id, @PathVariable long song_id){
        Song song = songRepository.findById(song_id).get();
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        playlist.removeSongFromPlaylist(song);
        return  playlist.getSongs();
    }
}
