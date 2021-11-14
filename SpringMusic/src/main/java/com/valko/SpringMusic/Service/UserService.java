package com.valko.SpringMusic.Service;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.User;
import com.valko.SpringMusic.Repository.PlaylistRepository;
import com.valko.SpringMusic.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<User> findAll(){
        return (List<User>)userRepository.findAll();
    }

    public User findUserByID(long id){
        return  userRepository.findById(id).get();
    }

    public Set<Playlist> getUsersPlaylists(long id){
        return   userRepository.findById(id).get().getPlaylists();
    }

    public Set<Playlist> addPlaylistToUser(long user_id, long playlist_id){
        User user = userRepository.findById(user_id).get();
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        user.addPlaylistToUser(playlist);
        return user.getPlaylists();
    }

    public Set<Playlist> deletePlaylist(long user_id, long playlist_id){
        User user = userRepository.findById(user_id).get();
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        user.deletePlaylistFromUser(playlist);
        return user.getPlaylists();
    }

    public User save(User user){
        userRepository.save(user);
        return user;
    }

    public long deleteUser(long id){
        userRepository.deleteById(id);
        return id;
    }
}
