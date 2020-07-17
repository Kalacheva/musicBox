package com.music.musicBox.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idArtist;

    private String nameArtist;

    private long idGenre;

    //@ManyToOne(optional=false, cascade=CascadeType.ALL)
    //@JoinColumn//(name = "idGenre")
    //private Genre genre;

    //@OneToMany(mappedBy = "artist", fetch=FetchType.EAGER)
    //private List<Album> albums;

    public Artist (){}

    public Artist (String nameArtist,long idGenre){
        this.nameArtist = nameArtist;
        this.idGenre=idGenre;
    }

    /*public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }*/

    public long getIdArtist(){return idArtist;}
    public void setIdArtist(long idArtist) { this.idArtist = idArtist; }

    public String getNameArtist() { return nameArtist; }
    public void setNameArtist(String nameArtist) { this.nameArtist = nameArtist; }

    public long getIdGenre(){return idGenre;}
    public void setIdGenre(long idGenre) { this.idGenre = idGenre; }
}
