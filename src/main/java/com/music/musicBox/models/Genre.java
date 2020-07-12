package com.music.musicBox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGenre;
    private String nameGenre;

    public Genre (){}
    public Genre (String nameGenre){this.nameGenre = nameGenre;}

    public Long getIdGenre(){return idGenre;}
    public void setIdGenre(Long idGenre) { this.idGenre = idGenre; }

    public String getNameGenre() { return nameGenre; }
    public void setNameGenre(String nameGenre) { this.nameGenre = nameGenre; }
}
