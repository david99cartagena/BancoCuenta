package com.company.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.banco.dao.ITipoCuentaDao;
import com.company.banco.model.TipoCuenta;
import com.company.banco.response.TipoCuentaResponseRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCuentaImpl implements ITipoCuentaService {

	@Autowired
	private ITipoCuentaDao tipocuentaDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<TipoCuentaResponseRest> search() {

		TipoCuentaResponseRest response = new TipoCuentaResponseRest();

		try {

			List<TipoCuenta> tipocuenta = (List<TipoCuenta>) tipocuentaDao.findAll();
			response.getTipocuentaResponse().setTipocuenta(tipocuenta);
			response.setMetadata("Respuesta Ok", "00", "Respuesta Exitosa");

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Error al Consultar");
			e.getStackTrace();
			return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<TipoCuentaResponseRest> searchById(Long id) {

		TipoCuentaResponseRest response = new TipoCuentaResponseRest();
		List<TipoCuenta> list = new ArrayList<>();

		try {
			Optional<TipoCuenta> tipocuenta = tipocuentaDao.findById(id);

			if (tipocuenta.isPresent()) {

				list.add(tipocuenta.get());
				response.getTipocuentaResponse().setTipocuenta(list);
				response.setMetadata("Respuesta Ok", "00", "TipoCuenta Encontrado");

			} else {

				response.setMetadata("Respuesta No Ok", "-1", "TipoCuenta No Encontrado");
				return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Erro al consultar por Id");
			e.getStackTrace();
			return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<TipoCuentaResponseRest> save(TipoCuenta tipocuenta) {

		TipoCuentaResponseRest response = new TipoCuentaResponseRest();
		List<TipoCuenta> list = new ArrayList<>();

		try {

			TipoCuenta tipocuentaSaved = tipocuentaDao.save(tipocuenta);

			if (tipocuentaSaved != null) {

				list.add(tipocuentaSaved);
				response.getTipocuentaResponse().setTipocuenta(list);
				response.setMetadata("Respuesta Ok", "00", "TipoCuenta Guardado");

			} else {

				response.setMetadata("Respuesta No Ok", "-1", "TipoCuenta No Guardado");
				return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.BAD_REQUEST);

			}

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Error al grabar TipoCuenta");
			e.getStackTrace();
			return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<TipoCuentaResponseRest> update(TipoCuenta tipocuenta, Long id) {

		TipoCuentaResponseRest response = new TipoCuentaResponseRest();
		List<TipoCuenta> list = new ArrayList<>();

		try {

			Optional<TipoCuenta> tipocuentaSearch = tipocuentaDao.findById(id);

			if (tipocuentaSearch.isPresent()) {

				// Se actualiza el usuario
//				tipocuentaSearch.get().setIdTipoCuenta(tipocuenta.getIdTipoCuenta());
				tipocuentaSearch.get().setDescripcion(tipocuenta.getDescripcion());

				TipoCuenta tipocuentaToUpdate = tipocuentaDao.save(tipocuentaSearch.get());

				if (tipocuentaToUpdate != null) {

					list.add(tipocuentaToUpdate);
					response.getTipocuentaResponse().setTipocuenta(list);
					response.setMetadata("Respuesta Ok", "00", "Usuario Actualizado");

				} else {

					response.setMetadata("Respuesta No Ok", "-1", "Usuario No Actualizado 1");
					return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.BAD_REQUEST);

				}

			} else {

				response.setMetadata("Respuesta No Ok", "-1", "Usuario No Encontrado 2");
				return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.NOT_FOUND);

			}

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Error al actualizar Usuario 3");
			e.getStackTrace();
			return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<TipoCuentaResponseRest> deleteById(Long id) {

		TipoCuentaResponseRest response = new TipoCuentaResponseRest();

		try {

			tipocuentaDao.deleteById(id);
			response.setMetadata("Respuesta Ok", "00", "TipoCuenta Eliminado");

		} catch (Exception e) {

			response.setMetadata("Respuesta No Ok", "-1", "Error al Eliminar");
			e.getStackTrace();
			return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<TipoCuentaResponseRest>(response, HttpStatus.OK);
	}

}
