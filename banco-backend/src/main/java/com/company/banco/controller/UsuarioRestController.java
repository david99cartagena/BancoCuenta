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

import com.company.banco.model.Usuario;
import com.company.banco.response.UsuarioResponseRest;
import com.company.banco.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService service;

	/**
	 * get all the usuarios
	 * 
	 * @return
	 */
	@GetMapping("/usuarios")
	public ResponseEntity<UsuarioResponseRest> searchCuentas() {

		ResponseEntity<UsuarioResponseRest> response = service.search();
		return response;

	}

	/**
	 * get usuarios by id
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioResponseRest> searchCuentasById(@PathVariable Long id) {

		ResponseEntity<UsuarioResponseRest> response = service.searchById(id);
		return response;

	}

	/**
	 * save usuarios
	 * 
	 * @param Usuario
	 * @return
	 */

	@PostMapping("/usuarios")
	public ResponseEntity<UsuarioResponseRest> searchCuentasById(@RequestBody Usuario usuario) {

		ResponseEntity<UsuarioResponseRest> response = service.save(usuario);
		return response;

	}

	/**
	 * update usuarios
	 * 
	 * @param usuario
	 * @param id
	 * @return
	 */
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioResponseRest> update(@RequestBody Usuario usuario, @PathVariable Long id) {

		ResponseEntity<UsuarioResponseRest> response = service.update(usuario, id);
		return response;

	}

	/**
	 * delete usuario
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<UsuarioResponseRest> delete(@PathVariable Long id) {

		ResponseEntity<UsuarioResponseRest> response = service.deleteById(id);
		return response;

	}
}
