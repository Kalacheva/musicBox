package com.music.musicBox.controllers;

import com.music.musicBox.Exceptions.NotFoundException;
import com.music.musicBox.models.Genre;
import com.music.musicBox.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("genre")
@CrossOrigin(origins = "*")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    public Iterable<Genre> listGenre() {
        Iterable<Genre> genres = genreRepository.findAll();
        return genres;
    }

    @GetMapping("{idGenre}")
    public Genre getOneGenre(@PathVariable long idGenre)
    {
        return getGenre(idGenre);
    }

    private Genre getGenre(@PathVariable long idGenre) {
        return genreRepository.findById(idGenre).orElseThrow(NotFoundException::new);
    }

    @PostMapping()
    public Genre addGenre (@RequestBody String nameGenre){
        Genre genre=new Genre(nameGenre);
        genreRepository.save(genre);
        return genre;
    }

    @PutMapping("{idGenre}")
    public Genre updateGenre(@PathVariable long idGenre, @RequestBody String nameGenre){
        Genre genreFromDb = getGenre(idGenre);
        genreFromDb.setNameGenre(nameGenre);
        genreRepository.save(genreFromDb);
        return genreFromDb;
    }

    @DeleteMapping("{idGenre}")
    public void deleteGenre (@PathVariable long idGenre){
        genreRepository.delete(getGenre(idGenre));
        //delete compete - 200; not found - 404; error delete - 5xx
    }
}