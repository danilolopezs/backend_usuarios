package com.gtc.gestion.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtc.gestion.usuario.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
