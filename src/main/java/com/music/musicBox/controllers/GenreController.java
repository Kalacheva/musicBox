package com.music.musicBox.controllers;

import com.music.musicBox.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.music.musicBox.repo.GenreRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;
    @GetMapping("/genre")
    public String genreMain(Model model) {
        Iterable<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres",genres);
        return "genreMain";
    }
    @GetMapping("/genre/add")
    public String genreMainAdd(Model model) {
        return "genreMainAdd";
    }

    @PostMapping("/genre/add")
    public String genrePostAdd(@RequestParam String nameGenre, Model model){
        Genre genre=new Genre(nameGenre);
        genreRepository.save(genre);
        return "redirect:/genre";
    }

    @PostMapping("/genre/{idGenre}/remove")
    public String genrePostDelete (@PathParam(value = "idGenre") long idGenre,Model model){
        Genre genre=genreRepository.findById(idGenre).orElseThrow();
        genreRepository.delete(genre);
        return "redirect:/genre";
    }


}
