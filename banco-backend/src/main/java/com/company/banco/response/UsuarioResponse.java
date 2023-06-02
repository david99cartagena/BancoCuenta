package com.company.banco.response;

import java.util.List;

import com.company.banco.model.Usuario;

import lombok.Data;

@Data
public class UsuarioResponse {

	private List<Usuario> usuario;

}
