package com.gtc.gestion.usuario.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cat_ciudad")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Ciudad{
	private Long id;
	private String nombre;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sec_ciudad")
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
}
