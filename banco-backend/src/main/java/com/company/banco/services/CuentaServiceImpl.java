package com.company.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.banco.dao.ICuentaDao;
import com.company.banco.model.Cuenta;
import com.company.banco.response.CuentaResponseRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private ICuentaDao cuentaDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CuentaResponseRest> search() {

		CuentaResponseRest response = new CuentaResponseRest();

		try {

		List<Cuenta> cuenta = (List<Cuenta>) cuentaDao.findAll();
		response.getCuentaResponse().setCuenta(cuenta);
		response.setMetadata("Respuesta Ok", "00", "Respuesta Exitosa");

		} catch (Exception e) {

		response.setMetadata("Respuesta No Ok", "-1", "Error al Consultar");
		e.getStackTrace();
		return new ResponseEntity<CuentaResponseRest>(response,
		HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<CuentaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CuentaResponseRest> searchById(Long id) {

		CuentaResponseRest response = new CuentaResponseRest();
		List<Cuenta> list = new ArrayList<>();

		// try {
		// Optional<Cuenta> cuenta = cuentaDao.findById(id);

		// if (cuenta.isPresent()) {

		// list.add(cuenta.get());
		// response.getCuentaResponse().setCuenta(list);
		// response.setMetadata("Respuesta Ok", "00", "Cuenta Encontrada");

		// } else {

		// response.setMetadata("Respuesta No Ok", "-1", "Cuenta No Encontrada");
		// return new ResponseEntity<CuentaResponseRest>(response,
		// HttpStatus.NOT_FOUND);

		// }

		// } catch (Exception e) {

		// response.setMetadata("Respuesta No Ok", "-1", "Erro al consultar por Id");
		// e.getStackTrace();
		// return new ResponseEntity<CuentaResponseRest>(response,
		// HttpStatus.INTERNAL_SERVER_ERROR);
		// }

		return new ResponseEntity<CuentaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CuentaResponseRest> save(Cuenta cuenta) {

		CuentaResponseRest response = new CuentaResponseRest();
		List<Cuenta> list = new ArrayList<>();

		// try {

		// Cuenta cuentaSaved = cuentaDao.save(cuenta);

		// if (cuentaSaved != null) {

		// list.add(cuentaSaved);
		// response.getCuentaResponse().setCuenta(list);
		// response.setMetadata("Respuesta Ok", "00", "Cuenta Guardada");

		// } else {

		// response.setMetadata("Respuesta No Ok", "-1", "Cuenta No Guardada");
		// return new ResponseEntity<CuentaResponseRest>(response,
		// HttpStatus.BAD_REQUEST);

		// }

		// } catch (Exception e) {

		// response.setMetadata("Respuesta No Ok", "-1", "Error al grabar Cuenta");
		// e.getStackTrace();
		// return new ResponseEntity<CuentaResponseRest>(response,
		// HttpStatus.INTERNAL_SERVER_ERROR);
		// }

		return new ResponseEntity<CuentaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CuentaResponseRest> update(Cuenta cuenta, Long id) {

		CuentaResponseRest response = new CuentaResponseRest();
		List<Cuenta> list = new ArrayList<>();

		// try {

		// Optional<Cuenta> cuentaSearch = cuentaDao.findById(id);

		// if (cuentaSearch.isPresent()) {

		// // Se actualiza Cuenta
		// cuentaSearch.get().setIdCuenta(cuenta.getIdCuenta());
		// cuentaSearch.get().setCuentanumero(cuenta.getCuentanumero());
		// cuentaSearch.get().setBalance(cuenta.getBalance());

		// Cuenta cuentaToUpdate = cuentaDao.save(cuentaSearch.get());

		// if (cuentaToUpdate != null) {

		// list.add(cuentaToUpdate);
		// response.getCuentaResponse().setCuenta(list);
		// response.setMetadata("Respuesta Ok", "00", "Cuenta Actualizada");

		// } else {

		// response.setMetadata("Respuesta No Ok", "-1", "Cuenta No Actualizada");
		// return new ResponseEntity<CuentaResponseRest>(response,
		// HttpStatus.BAD_REQUEST);

		// }

		// } else {

		// response.setMetadata("Respuesta No Ok", "-1", "Cuenta No Encontrada");
		// return new ResponseEntity<CuentaResponseRest>(response,
		// HttpStatus.NOT_FOUND);

		// }

		// } catch (Exception e) {

		// response.setMetadata("Respuesta No Ok", "-1", "Error al actualizar Cuenta");
		// e.getStackTrace();
		// return new ResponseEntity<CuentaResponseRest>(response,
		// HttpStatus.INTERNAL_SERVER_ERROR);
		// }

		return new ResponseEntity<CuentaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CuentaResponseRest> deleteById(Long id) {

		CuentaResponseRest response = new CuentaResponseRest();

		// try {

		// cuentaDao.deleteById(id);
		// response.setMetadata("Respuesta Ok", "00", "Cuenta Eliminada");

		// } catch (Exception e) {

		// response.setMetadata("Respuesta No Ok", "-1", "Error al Eliminar");
		// e.getStackTrace();
		// return new ResponseEntity<CuentaResponseRest>(response,
		// HttpStatus.INTERNAL_SERVER_ERROR);
		// }

		return new ResponseEntity<CuentaResponseRest>(response, HttpStatus.OK);
	}

}
