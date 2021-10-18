package com.valko.SpringMusic.Repository;

import com.valko.SpringMusic.Entity.Playlist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    @Override
    Playlist save(Playlist entity);

    @Override
    Optional<Playlist> findById(Long aLong);

    @Override
    List<Playlist> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Playlist entity);
}
