package com.company.banco.response;

import java.util.List;
import com.company.banco.model.TipoCuenta;
import lombok.Data;

@Data
public class TipoCuentaResponse {

	private List<TipoCuenta> tipocuenta;

}
