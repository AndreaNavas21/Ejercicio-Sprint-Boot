package com.ejerciciospring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejerciciospring.app.model.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

}
