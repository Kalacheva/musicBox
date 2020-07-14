package com.music.musicBox.controllers;

import com.music.musicBox.Exceptions.NotFoundException;
import com.music.musicBox.models.Song;
import com.music.musicBox.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("song")
public class SongController {
    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public Iterable<Song> listAlbum() {
        Iterable<Song> songs = songRepository.findAll();
        return songs;
    }

    @GetMapping("{idSong}")
    public Song getOneSong(@PathVariable long idSong)
    {
        return getSong(idSong);
    }

    private Song getSong(@PathVariable long idSong) {
        return songRepository.findById(idSong).orElseThrow(NotFoundException::new);
    }

    @PostMapping()
    public Song addSong (@RequestBody String nameSong, long idAlbum, File file){
        Song song=new Song(nameSong,idAlbum, file);
        songRepository.save(song);
        return song;
    }

    @PutMapping("{idSong}")
    public Song updateSong(@PathVariable long idSong, @RequestBody String nameSong){
        Song songFromDb = getSong(idSong);
        songFromDb.setNameSong(nameSong);
        songRepository.save(songFromDb);
        return songFromDb;
    }

    @DeleteMapping("{idSong}")
    public void deleteSong (@PathVariable long idSong){
        songRepository.delete(getSong(idSong));
        //delete compete - 200; not found - 404; error delete - 5xx
    }
}