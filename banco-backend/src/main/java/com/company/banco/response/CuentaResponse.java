package com.company.banco.response;

import java.util.List;
import com.company.banco.model.Cuenta;
import lombok.Data;

@Data
public class CuentaResponse {

	private List<Cuenta> cuenta;

}
