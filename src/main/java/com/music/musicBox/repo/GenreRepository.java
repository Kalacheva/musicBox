package com.music.musicBox.repo;

import com.music.musicBox.models.Genre;
import org.springframework.data.repository.CrudRepository;
// чтобы могли манипулировать табличкой
public interface GenreRepository extends CrudRepository<Genre,Long> {
}
