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

import com.company.banco.model.TipoCuenta;
import com.company.banco.response.TipoCuentaResponseRest;
import com.company.banco.services.ITipoCuentaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")

public class TipoCuentaRestController {

	@Autowired
	private ITipoCuentaService service;

	/**
	 * get all the tipocuentas
	 * 
	 * @return
	 */
	@GetMapping("/tipocuentas")
	public ResponseEntity<TipoCuentaResponseRest> searchTipoCuentas() {

		ResponseEntity<TipoCuentaResponseRest> response = service.search();
		return response;

	}

	/**
	 * get tipocuentas by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/tipocuentas/{id}")
	public ResponseEntity<TipoCuentaResponseRest> searchTipoCuentasById(@PathVariable Long id) {

		ResponseEntity<TipoCuentaResponseRest> response = service.searchById(id);
		return response;

	}

	/**
	 * save tipocuentas
	 * 
	 * @param TipoCuenta
	 * @return
	 */

	@PostMapping("/tipocuentas")
	public ResponseEntity<TipoCuentaResponseRest> searchTipoCuentasById(@RequestBody TipoCuenta tipocuenta) {

		ResponseEntity<TipoCuentaResponseRest> response = service.save(tipocuenta);
		return response;

	}

	/**
	 * update tipocuentas
	 * 
	 * @param TipoCuenta
	 * @param id
	 * @return
	 */
	@PutMapping("/tipocuentas/{id}")
	public ResponseEntity<TipoCuentaResponseRest> update(@RequestBody TipoCuenta tipocuenta, @PathVariable Long id) {

		ResponseEntity<TipoCuentaResponseRest> response = service.update(tipocuenta, id);
		return response;

	}

	/**
	 * delete tipocuenta
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/tipocuentas/{id}")
	public ResponseEntity<TipoCuentaResponseRest> delete(@PathVariable Long id) {

		ResponseEntity<TipoCuentaResponseRest> response = service.deleteById(id);
		return response;

	}

}
