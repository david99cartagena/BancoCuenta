package com.company.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.banco.dao.IUsuarioDao;
import com.company.banco.model.Usuario;
import com.company.banco.response.UsuarioResponseRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<UsuarioResponseRest> search() {

		UsuarioResponseRest response = new UsuarioResponseRest();

		try {

			List<Usuario> usuario = (List<Usuario>) usuarioDao.findAll();
			response.getUsuarioResponse().setUsuario(usuario);
			response.setMetadata("Respuesta Ok", "00", "Respuesta Exitosa");

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Error al Consultar");
			e.getStackTrace();
			return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<UsuarioResponseRest> searchById(Long id) {

		UsuarioResponseRest response = new UsuarioResponseRest();
		List<Usuario> list = new ArrayList<>();

		try {
			Optional<Usuario> usuario = usuarioDao.findById(id);

			if (usuario.isPresent()) {

				list.add(usuario.get());
				response.getUsuarioResponse().setUsuario(list);
				response.setMetadata("Respuesta Ok", "00", "Usuario Encontrado");

			} else {

				response.setMetadata("Respuesta No Ok", "-1", "Usuario No Encontrado");
				return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Erro al consultar por Id");
			e.getStackTrace();
			return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<UsuarioResponseRest> save(Usuario usuario) {

		UsuarioResponseRest response = new UsuarioResponseRest();
		List<Usuario> list = new ArrayList<>();

		try {

			Usuario cuentaSaved = usuarioDao.save(usuario);

			if (cuentaSaved != null) {

				list.add(cuentaSaved);
				response.getUsuarioResponse().setUsuario(list);
				response.setMetadata("Respuesta Ok", "00", "Usuario Guardado");

			} else {

				response.setMetadata("Respuesta No Ok", "-1", "Usuario No Guardado");
				return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.BAD_REQUEST);

			}

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Error al grabar Usuario");
			e.getStackTrace();
			return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<UsuarioResponseRest> update(Usuario usuario, Long id) {

		UsuarioResponseRest response = new UsuarioResponseRest();
		List<Usuario> list = new ArrayList<>();

		try {

			Optional<Usuario> usuarioSearch = usuarioDao.findById(id);

			if (usuarioSearch.isPresent()) {

				// Se actualiza el usuario
				usuarioSearch.get().setUsuarioid(usuario.getUsuarioid());
				usuarioSearch.get().setNombre(usuario.getNombre());
				usuarioSearch.get().setApellido(usuario.getApellido());

				Usuario usuarioToUpdate = usuarioDao.save(usuarioSearch.get());

				if (usuarioToUpdate != null) {

					list.add(usuarioToUpdate);
					response.getUsuarioResponse().setUsuario(list);
					response.setMetadata("Respuesta Ok", "00", "Usuario Actualizado");

				} else {

					response.setMetadata("Respuesta No Ok", "-1", "Usuario No Actualizado");
					return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.BAD_REQUEST);

				}

			} else {

				response.setMetadata("Respuesta No Ok", "-1", "Usuario No Encontrado");
				return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Error al actualizar Usuario");
			e.getStackTrace();
			return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<UsuarioResponseRest> deleteById(Long id) {

		UsuarioResponseRest response = new UsuarioResponseRest();

		try {

			usuarioDao.deleteById(id);
			response.setMetadata("Respuesta Ok", "00", "Usuario Eliminado");

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Error al Eliminar");
			e.getStackTrace();
			return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
	}
}
