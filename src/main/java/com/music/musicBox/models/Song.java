package com.music.musicBox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSong;
    private String nameSong;
    private File file;
    private Long idArtist;

    public Song (){}
    public Song(String nameSong,Long idArtist, File file){
        this.nameSong = nameSong;
        this.idArtist=idArtist;
        this.file=file;
    }

    public Long getIdSong(){return idSong;}
    public void setIdSong(Long idSong) { this.idSong = idSong; }

    public String getNameSong() { return nameSong; }
    public void setNameSong(String nameSong) { this.nameSong = nameSong; }

    public Long getIdArtist(){return idArtist;}
    public void setIdArtist(Long idArtist) { this.idArtist= idArtist; }

    public File getFile(){return file;}
    public void setFile(File file) { this.file= file; }
}
