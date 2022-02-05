package com.demiconconnectorapp.repositories;

import com.demiconconnectorapp.models.RandomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RandomUserRepository extends JpaRepository<RandomUser, Long> {

    List<RandomUser> findByLocation_Country(String country);
}
