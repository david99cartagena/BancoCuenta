package com.company.banco.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.banco.model.TipoCuenta;

public interface ITipoCuentaDao extends CrudRepository<TipoCuenta, Long> {

}
