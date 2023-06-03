package com.company.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.banco.model.Cuenta;
import com.company.banco.response.CuentaResponseRest;
import com.company.banco.services.ICuentaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CuentaRestController {

	@Autowired
	private ICuentaService service;

	/**
	 * get all the cuentas
	 * 
	 * @return
	 */
	@GetMapping("/cuentas")
	public ResponseEntity<CuentaResponseRest> searchCuentas() {

		ResponseEntity<CuentaResponseRest> response = service.search();
		return response;

	}

	/**
	 * get cuentas by id
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/cuentas/{id}")
	public ResponseEntity<CuentaResponseRest> searchCuentasById(@PathVariable Long id) {

		ResponseEntity<CuentaResponseRest> response = service.searchById(id);
		return response;

	}

	/**
	 * save cuentas
	 * 
	 * @param Cuenta
	 * @return
	 */

	@PostMapping("/cuentas")
	public ResponseEntity<CuentaResponseRest> searchCuentasById(@RequestBody Cuenta cuenta) {

		ResponseEntity<CuentaResponseRest> response = service.save(cuenta);
		return response;

	}

	/**
	 * update cuentas
	 * 
	 * @param Cuenta
	 * @param id
	 * @return
	 */
	@PutMapping("/cuentas/{id}")
	public ResponseEntity<CuentaResponseRest> update(@RequestBody Cuenta cuenta, @PathVariable Long id) {

		ResponseEntity<CuentaResponseRest> response = service.update(cuenta, id);
		return response;

	}

	/**
	 * delete cuenta
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/cuentas/{id}")
	public ResponseEntity<CuentaResponseRest> delete(@PathVariable Long id) {

		ResponseEntity<CuentaResponseRest> response = service.deleteById(id);
		return response;

	}

}
