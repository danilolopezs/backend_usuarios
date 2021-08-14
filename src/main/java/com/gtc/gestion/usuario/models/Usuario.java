package com.gtc.gestion.usuario.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TBL_USUARIO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario {
	private Long id;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String email;
	private Date fecha_nacimiento;
	private String direccion;
	private Ciudad ciudad;
	private Boolean activo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sec_usuario")
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", nullable = false)
	public String getApellido() {
		return apellido;
	}

	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "edad")
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(final Integer edad) {
		this.edad = edad;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Column(name = "fecha_nacimiento")
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(final Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	@Column(name = "direccion")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sec_ciudad")
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(final Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	@Column(name = "activo", columnDefinition = "Decimal(1,0) default '1'")
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(final Boolean activo) {
		this.activo = activo;
	}
}
