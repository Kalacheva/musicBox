package com.music.musicBox.repo;

import com.music.musicBox.models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song,Long> {
}