package com.music.musicBox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAlbum;
    private String nameAlbum;
    private Long idArtist;

    public Album (){}
    public Album(String nameAlbum,Long idArtist){
        this.nameAlbum = nameAlbum;
        this.idArtist=idArtist;
    }

    public Long getIdAlbum(){return idAlbum;}
    public void setIdAlbum(Long idAlbum) { this.idAlbum = idAlbum; }

    public String getNameAlbum() { return nameAlbum; }
    public void setNameAlbum(String nameAlbum) { this.nameAlbum = nameAlbum; }

    public Long getIdArtist(){return idArtist;}
    public void setIdArtist(Long idArtist) { this.idArtist= idArtist; }
}

