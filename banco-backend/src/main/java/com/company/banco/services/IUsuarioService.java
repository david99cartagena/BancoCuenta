package com.company.banco.services;

import org.springframework.http.ResponseEntity;
import com.company.banco.model.Usuario;
import com.company.banco.response.UsuarioResponseRest;

public interface IUsuarioService {

	public ResponseEntity<UsuarioResponseRest> search();

	public ResponseEntity<UsuarioResponseRest> searchById(Long id);

	public ResponseEntity<UsuarioResponseRest> save(Usuario usuario);

	public ResponseEntity<UsuarioResponseRest> update(Usuario usuario, Long id);

	public ResponseEntity<UsuarioResponseRest> deleteById(Long id);

}
