package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select distinct u from User u join fetch u.roles where u.email = :email")
    User findByEmail(String email);

    @Query("select distinct u from User u left join fetch u.roles")
    List<User> findAll();
}
