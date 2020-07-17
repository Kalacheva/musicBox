package com.music.musicBox.controllers;

import com.music.musicBox.Exceptions.NotFoundException;
import com.music.musicBox.models.Artist;
import com.music.musicBox.repo.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("artist")
@CrossOrigin(origins = "*")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping
    public Iterable<Artist> listArtist() {
        return artistRepository.findAll();
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
    public Artist addArtist (@RequestParam String nameArtist,@RequestParam long idGenre){
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
        artistRepository.deleteById(idArtist);
        //delete compete - 200; not found - 404; error delete - 5xx
    }

    @GetMapping("/byGenre/{idGenre}")
    public List<Artist> getArtistByGenre(@PathVariable long idGenre)
    {
        Iterable<Artist> artists = artistRepository.findAll();
        List<Artist> artistsByGenre= new ArrayList<>();
        artists.forEach(artist -> {
            if(artist.getIdGenre()==idGenre){
                artistsByGenre.add(artist);
            }
        });
        return artistsByGenre;
    }

}