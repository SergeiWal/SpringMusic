package com.valko.SpringMusic.Service;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.Song;
import com.valko.SpringMusic.Repository.PlaylistRepository;
import com.valko.SpringMusic.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Song> findAll(){
        return (List<Song>) songRepository.findAll();
    }

    public Song findOneSongById(long id){
        return songRepository.findById(id).get();
    }

    public Song saveSong(Song song){
        songRepository.save(song);
        return song;
    }

    public long deleteSongByID(long id){
        Song song = songRepository.findById(id).get();
        List<Playlist> playlists = (List<Playlist>)playlistRepository.findAll();
        for(Playlist playlist: playlists){
            playlist.removeSong(song);
        }
        songRepository.delete(song);
        return id;
    }
}
