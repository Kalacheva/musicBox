package com.music.musicBox.controllers;

import com.music.musicBox.Exceptions.NotFoundException;
import com.music.musicBox.models.Album;
import com.music.musicBox.models.Artist;
import com.music.musicBox.repo.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("album")
@CrossOrigin(origins = "*")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping
    public Iterable<Album> listAlbum() {
        Iterable<Album> albums = albumRepository.findAll();
        return albums;
    }

    @GetMapping("{idAlbum}")
    public Album getOneArtist(@PathVariable long idAlbum)
    {
        return getAlbum(idAlbum);
    }

    private Album getAlbum(@PathVariable long idAlbum) {
        return albumRepository.findById(idAlbum).orElseThrow(NotFoundException::new);
    }

    @PostMapping()
    public Album addAlbum (@RequestParam String nameAlbum,@RequestParam long idArtist){
        Album album=new Album(nameAlbum,idArtist);
        albumRepository.save(album);
        return album;
    }

    @PutMapping("{idAlbum}")
    public Album updateAlbum(@PathVariable long idAlbum, @RequestBody String nameAlbum){
        Album albumFromDb = getAlbum(idAlbum);
        albumFromDb.setNameAlbum(nameAlbum);
        albumRepository.save(albumFromDb);
        return albumFromDb;
    }

    @DeleteMapping("{idAlbum}")
    public void deleteAlbum (@PathVariable long idAlbum){
        albumRepository.deleteById(idAlbum);
        //delete compete - 200; not found - 404; error delete - 5xx
    }

    @GetMapping("/byArtist/{idArtist}")
    public List<Album> getAlbumsByArtist(@PathVariable long idArtist)
    {
        Iterable<Album> albums = albumRepository.findAll();
        List<Album> albumsByArtist= new ArrayList<>();
        albums.forEach(album -> {
            if(album.getIdArtist()==idArtist){
                albumsByArtist.add(album);
            }
        });
        return albumsByArtist;
    }
}