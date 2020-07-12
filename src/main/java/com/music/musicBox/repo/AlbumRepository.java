package com.music.musicBox.repo;

import com.music.musicBox.models.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Long> {
}