package com.music.musicBox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idArtist;
    private String nameArtist;
    private long idGenre;

    public Artist (){}
    public Artist (String nameArtist,long idGenre){
        this.nameArtist = nameArtist;
        this.idGenre=idGenre;
    }

    public long getIdArtist(){return idArtist;}
    public void setIdArtist(long idArtist) { this.idArtist = idArtist; }

    public String getNameArtist() { return nameArtist; }
    public void setNameArtist(String nameArtist) { this.nameArtist = nameArtist; }

    public long getIdGenre(){return idGenre;}
    public void setIdGenre(long idGenre) { this.idGenre = idGenre; }
}
