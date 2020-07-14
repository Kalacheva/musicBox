package com.music.musicBox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAlbum;
    private String nameAlbum;
    private long idArtist;

    public Album (){}
    public Album(String nameAlbum,long idArtist){
        this.nameAlbum = nameAlbum;
        this.idArtist=idArtist;
    }

    public long getIdAlbum(){return idAlbum;}
    public void setIdAlbum(long idAlbum) { this.idAlbum = idAlbum; }

    public String getNameAlbum() { return nameAlbum; }
    public void setNameAlbum(String nameAlbum) { this.nameAlbum = nameAlbum; }

    public long getIdArtist(){return idArtist;}
    public void setIdArtist(long idArtist) { this.idArtist= idArtist; }
}

