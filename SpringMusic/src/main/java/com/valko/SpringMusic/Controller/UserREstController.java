package com.valko.SpringMusic.Controller;

import com.valko.SpringMusic.Entity.Playlist;
import com.valko.SpringMusic.Entity.User;
import com.valko.SpringMusic.Service.UserService;
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
    private UserService userService;

    @GetMapping
    List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    User getOneUser(@PathVariable long id){
        return userService.findUserByID(id);
    }

    @GetMapping(value = "/{user_id}/playlists")
    Set<Playlist> getUsersPlaylists(@PathVariable long user_id){
        return userService.getUsersPlaylists(user_id);
    }


    @PostMapping
    User saveUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @PostMapping(value = "/{user_id}/playlists/{playlist_id}")
    Set<Playlist> addPlaylistToUser(@PathVariable long user_id, @PathVariable long playlist_id){
        return userService.addPlaylistToUser(user_id, playlist_id);
    }

    @DeleteMapping(value = "/{id}")
    long deleteUserById(@PathVariable long id){
        return userService.deleteUser(id);
    }


    @DeleteMapping(value = "/{user_id}/playlists/{playlist_id}")
    Set<Playlist> deletePlaylist(@PathVariable long user_id, @PathVariable long playlist_id){
        return userService.deletePlaylist(user_id,playlist_id);
    }
}
