package com.valko.SpringMusic.Controller;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.User;
import com.valko.SpringMusic.Repository.PlaylistRepository;
import com.valko.SpringMusic.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserREstController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping
    List<User> getUsers(){
        return (List<User>)userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    User getOneUser(@PathVariable long id){
        return userRepository.findById(id).get();
    }

    @GetMapping(value = "/{user_id}/playlists")
    Set<Playlist> getUsersPlaylists(@PathVariable long user_id){
        return userRepository.findById(user_id).get().getPlaylists();
    }


    @PostMapping
    User saveUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @PostMapping(value = "/{user_id}/playlists/{playlist_id}")
    Set<Playlist> addPlaylistToUser(@PathVariable long user_id, @PathVariable long playlist_id){
        User user = userRepository.findById(user_id).get();
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        user.addPlaylistToUser(playlist);
        return user.getPlaylists();
    }

    @DeleteMapping(value = "/{id}")
    User deleteUserById(@PathVariable long id){
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;
    }

    @DeleteMapping
    User deleteUser(@RequestBody User user){
        userRepository.delete(user);
        return user;
    }

    @DeleteMapping(value = "/{user_id}/playlists/{playlist_id}")
    Set<Playlist> deletePlaylist(@PathVariable long user_id, @PathVariable long playlist_id){
        User user = userRepository.findById(user_id).get();
        Playlist playlist = playlistRepository.findById(playlist_id).get();
        user.deletePlaylistFromUser(playlist);
        return user.getPlaylists();
    }
}
