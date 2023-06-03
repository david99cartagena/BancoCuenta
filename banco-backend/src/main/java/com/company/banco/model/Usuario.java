package com.company.banco.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {

	private static final long serialVersionUID = -4310027227752446841L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idUsuario;
	private String nombre;
	private String apellido;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "usuario_cuenta", 
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario"), 
	inverseJoinColumns = @JoinColumn(name = "cuenta_id", referencedColumnName = "idCuenta"))
	private List<Cuenta> cuenta = new ArrayList<>();

}