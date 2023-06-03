package com.company.banco.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.banco.model.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta, Long> {

}
