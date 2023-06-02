package com.company.banco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {

	private static final long serialVersionUID = -4310027227752446841L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String usuarioid;
	private String nombre;
	private String apellido;
//	private Float valor;

}