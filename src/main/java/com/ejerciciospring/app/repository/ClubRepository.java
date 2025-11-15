package com.ejerciciospring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejerciciospring.app.model.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {

}