package com.music.musicBox.controllers;

import com.music.musicBox.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.music.musicBox.repo.ArtistRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;
    @GetMapping("/Artist")
    public String ArtistMain(Model model) {
        Iterable<Artist> artists = artistRepository.findAll();
        model.addAttribute("artists",artists);
        return "ArtistMain";
    }
    @GetMapping("/Artist/add")
    public String artistMainAdd(Model model) {
        return "ArtistMainAdd";
    }

    @PostMapping("/Artists/add")
    public String ArtistPostAdd(@RequestParam String nameArtist,long idGenre, Model model){
        Artist artist=new Artist(nameArtist,idGenre);
        artistRepository.save(artist);
        return "redirect:/Artist";
    }

    @PostMapping("Artist/{idArtist}/remove")
    public String artistPostDelete (@PathParam(value = "idArtist") long idArtist,Model model){
        Artist artist=artistRepository.findById(idArtist).orElseThrow();
        artistRepository.delete(artist);
        return "redirect:/Artist";
    }


}
