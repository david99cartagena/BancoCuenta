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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cuenta")

public class Cuenta<usuario, tipocuenta> implements Serializable {

	private static final long serialVersionUID = -4310027227752446841L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idCuenta;
	private String cuentanumero;
	private double balance;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "tipo_cuenta", joinColumns = @JoinColumn(name = "tipocuenta_id"))
	private List<TipoCuenta> tipocuenta = new ArrayList<>();

	@ManyToMany(mappedBy = "cuenta")
	private List<Usuario> usuario = new ArrayList<>();

}
