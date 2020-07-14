package com.music.musicBox.controllers;

import com.music.musicBox.Exceptions.NotFoundException;
import com.music.musicBox.models.Artist;
import com.music.musicBox.repo.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("artist")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping
    public Iterable<Artist> listArtist() {
        Iterable<Artist> artists = artistRepository.findAll();
        return artists;
    }

    @GetMapping("{idArtist}")
    public Artist getOneArtist(@PathVariable long idArtist)
    {
        return getArtist(idArtist);
    }

    private Artist getArtist(@PathVariable long idArtist) {
        return artistRepository.findById(idArtist).orElseThrow(NotFoundException::new);
    }

    @PostMapping()
    public Artist addArtist (@RequestBody String nameArtist, long idGenre){
        Artist artist=new Artist(nameArtist,idGenre);
        artistRepository.save(artist);
        return artist;
    }

    @PutMapping("{idArtist}")
    public Artist updateArtist(@PathVariable long idArtist, @RequestBody String nameArtist){
        Artist artistFromDb = getArtist(idArtist);
        artistFromDb.setNameArtist(nameArtist);
        artistRepository.save(artistFromDb);
        return artistFromDb;
    }

    @DeleteMapping("{idArtist}")
    public void deleteArtist (@PathVariable long idArtist){
        artistRepository.delete(getArtist(idArtist));
        //delete compete - 200; not found - 404; error delete - 5xx
    }
}