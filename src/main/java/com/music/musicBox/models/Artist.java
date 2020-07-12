package com.music.musicBox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idArtist;
    private String nameArtist;
    private Long idGenre;

    public Artist (){}
    public Artist (String nameArtist,Long idGenre){
        this.nameArtist = nameArtist;
        this.idGenre=idGenre;
    }

    public Long getIdArtist(){return idArtist;}
    public void setIdArtist(Long idArtist) { this.idArtist = idArtist; }

    public String getNameArtist() { return nameArtist; }
    public void setNameArtist(String nameArtist) { this.nameArtist = nameArtist; }

    public Long getIdGenre(){return idGenre;}
    public void setIdGenre(Long idGenre) { this.idGenre = idGenre; }
}
