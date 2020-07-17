package com.music.musicBox.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // генерирует каждый раз новое значение поля
    private long idGenre;

    private String nameGenre;

    //@OneToMany(mappedBy = "genre", fetch=FetchType.EAGER)
    //private List<Artist> artists;

   /* public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }*/

    public Genre (){}
    public Genre (String nameGenre){this.nameGenre = nameGenre;}

    public long getIdGenre(){return idGenre;} // получаем
    public void setIdGenre(long idGenre) { this.idGenre = idGenre; } // устанавливаем

    public String getNameGenre() { return nameGenre; }
    public void setNameGenre(String nameGenre) { this.nameGenre = nameGenre; }
}
