package com.music.musicBox.models;

import javax.persistence.*;
import java.io.File;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSong;

    private String nameSong;

    private File file;

    private long idAlbum;

    //@ManyToOne(optional=false, cascade=CascadeType.ALL)
    //@JoinColumn//(name="idAlbum")
    //private Album album;

    public Song (){}

    public Song(String nameSong,long idAlbum, File file){
        this.nameSong = nameSong;
        this.idAlbum=idAlbum;
        this.file=file;
    }
/*

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
*/

    public long getIdSong(){return idSong;}
    public void setIdSong(long idSong) { this.idSong = idSong; }

    public String getNameSong() { return nameSong; }
    public void setNameSong(String nameSong) { this.nameSong = nameSong; }

    public long getIdAlbum(){return idAlbum;}
    public void setIdAlbum(long idAlbum) { this.idAlbum= idAlbum; }

    public File getFile(){return file;}
    public void setFile(File file) { this.file= file; }
}
