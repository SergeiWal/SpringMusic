package com.valko.SpringMusic.Repository;

import com.valko.SpringMusic.Entity.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

    @Override
    Song save(Song entity) ;

    @Override
    Optional<Song> findById(Long aLong) ;

    @Override
    List<Song> findAll() ;

    @Override
    void deleteById(Long aLong) ;

    @Override
    void delete(Song entity) ;
}
