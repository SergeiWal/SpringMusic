package com.valko.SpringMusic.Service;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.Song;
import com.valko.SpringMusic.Entity.User;
import com.valko.SpringMusic.Repository.PlaylistRepository;
import com.valko.SpringMusic.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private SongService songService;

    public List<Playlist> findAll(){
        return (List<Playlist>) playlistRepository.findAll();
    }

    public Playlist findOnePlaylist(long id){
        return playlistRepository.findById(id).get();
    }

    public Set<Song> findSongsForPlaylist(long id){
        return playlistRepository.findById(id).get().getSongs();
    }

    public Playlist save(Playlist playlist, long owner_id){
        User user =userService.findUserByID(owner_id);
        playlist.setOwner(user);
        playlistRepository.save(playlist);
        return playlist;
    }

    public Playlist addSongToPlaylist(long playlist_id, long song_id){
        Song song = songService.findOneSongById(song_id);
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        playlist.addSongToPlaylist(song);
        return playlistRepository.save(playlist);
    }

    public Playlist deleteSongFromPlaylist(long playlist_id, long song_id){
        Song song = songService.findOneSongById(song_id);
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        playlist.removeSong(song);
        return  playlistRepository.save(playlist);
    }

    public long  deletePlaylist( long id){
        playlistRepository.deleteById(id);
        return id;
    }
}
