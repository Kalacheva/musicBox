package com.music.musicBox.controllers;

import com.music.musicBox.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.music.musicBox.repo.SongRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.io.File;

@Controller
public class SongController {
    @Autowired
    private SongRepository songRepository;

    @GetMapping("/Song")
    public String SongMain(Model model) {
        Iterable<Song> songs = songRepository.findAll();
        model.addAttribute("songs", songs);
        return "SongMain";
    }

    @GetMapping("/Song/add")
    public String songMainAdd(Model model) {
        return "SongMainAdd";
    }

    @PostMapping("/Song/add")
    public String SongPostAdd(@RequestParam String nameSong, long idArtist, File file, Model model) {
        Song song = new Song(nameSong, idArtist, file);
        songRepository.save(song);
        return "redirect:/Song";
    }

    @PostMapping("Song/{idSong}/remove")
    public String songPostDelete(@PathParam(value = "idSong") long idSong, Model model) {
        Song song = songRepository.findById(idSong).orElseThrow();
        songRepository.delete(song);
        return "redirect:/Song";
    }
}

