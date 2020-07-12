package com.music.musicBox.controllers;

import com.music.musicBox.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.music.musicBox.repo.AlbumRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/Album")
    public String AlbumMain(Model model) {
        Iterable<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "AlbumMain";
    }

    @GetMapping("/Album/add")
    public String albumMainAdd(Model model) {
        return "AlbumMainAdd";
    }

    @PostMapping("/Album/add")
    public String AlbumPostAdd(@RequestParam String nameAlbum, long idArtist, Model model) {
        Album album = new Album(nameAlbum, idArtist);
        albumRepository.save(album);
        return "redirect:/Album";
    }

    @PostMapping("Album/{idAlbum}/remove")
    public String albumPostDelete(@PathParam(value = "idAlbum") long idAlbum, Model model) {
        Album album = albumRepository.findById(idAlbum).orElseThrow();
        albumRepository.delete(album);
        return "redirect:/Album";
    }
}
