package com.music.musicBox.controllers;

import com.music.musicBox.Exceptions.NotFoundException;
import com.music.musicBox.models.Album;
import com.music.musicBox.repo.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("album")
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
    public Album addAlbum (@RequestBody String nameAlbum, long idArtist){
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
        albumRepository.delete(getAlbum(idAlbum));
        //delete compete - 200; not found - 404; error delete - 5xx
    }
}