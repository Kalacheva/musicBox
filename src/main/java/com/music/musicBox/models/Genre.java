package com.music.musicBox.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // модель
public class Genre {
    @Id // уникальный идентификатор
    @GeneratedValue(strategy = GenerationType.AUTO) // генерирует каждый раз новое значение поля
    private long idGenre;
    private String nameGenre;

    public Genre (){}
    public Genre (String nameGenre){this.nameGenre = nameGenre;}

    public long getIdGenre(){return idGenre;} // получаем
    public void setIdGenre(long idGenre) { this.idGenre = idGenre; } // устанавливаем

    public String getNameGenre() { return nameGenre; }
    public void setNameGenre(String nameGenre) { this.nameGenre = nameGenre; }
}
