package com.company.banco.services;

import org.springframework.http.ResponseEntity;
import com.company.banco.model.Cuenta;
import com.company.banco.response.CuentaResponseRest;

public interface ICuentaService {

	public ResponseEntity<CuentaResponseRest> search();

	public ResponseEntity<CuentaResponseRest> searchById(Long id);

	public ResponseEntity<CuentaResponseRest> save(Cuenta cuenta);

	public ResponseEntity<CuentaResponseRest> update(Cuenta cuenta, Long id);

	public ResponseEntity<CuentaResponseRest> deleteById(Long id);

}
