package com.gtc.gestion.usuario.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtc.gestion.usuario.comun.Comun;
import com.gtc.gestion.usuario.models.Ciudad;
import com.gtc.gestion.usuario.services.CiudadService;

@RestController
@RequestMapping({ Comun.PATH_REST_CIUDADES })
public class CiudadController {

	@Autowired
	private CiudadService service;
	
	@GetMapping
	public ResponseEntity<List<Ciudad>> getCiudades() {				
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping(value = Comun.PATH_BUSCAR)
	public ResponseEntity<Ciudad> getCiudadPorId(@PathVariable(Comun.ID) Long id) {
		try {
			return ResponseEntity.ok(service.getById(id));
		}
		catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
