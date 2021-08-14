package com.gtc.gestion.usuario.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtc.gestion.usuario.comun.Comun;
import com.gtc.gestion.usuario.models.Usuario;
import com.gtc.gestion.usuario.services.UsuarioService;

@RestController
@RequestMapping({ Comun.PATH_REST_USUARIO })
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping()
	public ResponseEntity<List<Usuario>> getUsuarios() {
		return ResponseEntity.ok(service.findAll().stream().filter(u -> u.getActivo()).collect(Collectors.toList()));
	}
	
	@GetMapping(value = Comun.PATH_BUSCAR)
	public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable(Comun.ID) Long id) {
		try {
			return ResponseEntity.ok(service.getById(id));
		}
		catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping(Comun.PATH_CREAR)
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		try {
			if(usuario.getActivo() == null)
				usuario.setActivo(Boolean.TRUE);
			Usuario usuarioCreado = service.save(usuario);
			return ResponseEntity.created(new URI(Comun.PATH_USUARIO + usuarioCreado.getId())).body(usuarioCreado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = Comun.PATH_ELIMINAR)
	public ResponseEntity<Boolean> deleteUsuario(@PathVariable(Comun.ID) Long id) {		
		Optional<Usuario> usuario = service.findById(id);
		Usuario user = usuario.get();
		if (usuario.isPresent()) {
			user.setActivo(Boolean.FALSE);
			this.updateUsuario(user);
		}
		return ResponseEntity.ok(!user.getActivo());
	}

	@PutMapping(value = Comun.PATH_ACTUALIZAR)
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		Optional<Usuario> user = service.findById(usuario.getId());		
		if (user.isPresent())
			service.save(usuario);
		return ResponseEntity.ok(user.get());
	}
}
