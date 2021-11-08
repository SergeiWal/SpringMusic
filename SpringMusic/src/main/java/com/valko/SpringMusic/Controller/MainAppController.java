package com.valko.SpringMusic.Controller;

import com.valko.SpringMusic.Entity.Song;
import com.valko.SpringMusic.Repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping
public class MainAppController {

    private String rootPath = "E:\\GIT\\Music\\";
    private String pathSuffix = ".mp3";

    @Autowired
    SongRepository songRepository;

    @GetMapping(value = "/")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value = "/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration(Model model){
        return "registration";
    }

    @GetMapping(value = "/client")
    public String Client(Model model){
        model.addAttribute("songs", songRepository.findAll());
        return "client";
    }

    @GetMapping(value = "/admin")
    public String admin(Model model){
        model.addAttribute("songs", songRepository.findAll());
        return "admin";
    }

    @GetMapping(
            value = "/listen/{id}",
            produces = "audio/mp3"
    )
    @ResponseBody
    public FileSystemResource getSong(@PathVariable long id) {
        Song song = songRepository.findById(id).get();
        return new FileSystemResource(song.getSource());
    }
}
