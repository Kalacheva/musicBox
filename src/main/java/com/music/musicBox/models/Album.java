package com.music.musicBox.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAlbum;

    private String nameAlbum;

    private long idArtist;

    //@ManyToOne(optional=false, cascade=CascadeType.ALL)
    //@JoinColumn//(name="idArtist")
    //private Artist artist;

    //@OneToMany(mappedBy = "album", fetch=FetchType.EAGER)
    //private List<Song> songs;

    public Album (){}

    public Album(String nameAlbum,long idArtist){
        this.nameAlbum = nameAlbum;
        this.idArtist=idArtist;
    }
/*
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }*/

    public long getIdAlbum(){return idAlbum;}
    public void setIdAlbum(long idAlbum) { this.idAlbum = idAlbum; }

    public String getNameAlbum() { return nameAlbum; }
    public void setNameAlbum(String nameAlbum) { this.nameAlbum = nameAlbum; }

    public long getIdArtist(){return idArtist;}
    public void setIdArtist(long idArtist) { this.idArtist= idArtist; }
}

