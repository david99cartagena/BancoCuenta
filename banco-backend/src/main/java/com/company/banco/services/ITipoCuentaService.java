package com.company.banco.services;

import org.springframework.http.ResponseEntity;
import com.company.banco.model.TipoCuenta;
import com.company.banco.response.TipoCuentaResponseRest;

public interface ITipoCuentaService {

	public ResponseEntity<TipoCuentaResponseRest> search();

	public ResponseEntity<TipoCuentaResponseRest> searchById(Long id);

	public ResponseEntity<TipoCuentaResponseRest> save(TipoCuenta tipocuenta);

	public ResponseEntity<TipoCuentaResponseRest> update(TipoCuenta tipocuenta, Long id);

	public ResponseEntity<TipoCuentaResponseRest> deleteById(Long id);

}
