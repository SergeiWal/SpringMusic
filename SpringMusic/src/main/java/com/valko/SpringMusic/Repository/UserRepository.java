package com.valko.SpringMusic.Repository;

import com.valko.SpringMusic.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long aLong);

    @Override
    List<User> findAll();

    @Override
    default void delete(User entity) {

    }
    @Override
    void deleteById(Long aLong);
}
