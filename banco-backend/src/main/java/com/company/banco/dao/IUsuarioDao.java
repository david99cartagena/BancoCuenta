package com.company.banco.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.banco.model.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
