package com.company.banco.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tipocuenta")

public class TipoCuenta implements Serializable {

	private static final long serialVersionUID = -4310027227752446841L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idTipoCuenta;
	private String descripcion;

}
