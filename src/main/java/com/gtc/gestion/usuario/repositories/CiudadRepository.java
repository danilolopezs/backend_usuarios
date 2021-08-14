package com.gtc.gestion.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.gestion.usuario.models.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
