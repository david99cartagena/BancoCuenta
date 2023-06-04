import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

const base_url = environment.base_url;

@Injectable({
  providedIn: 'root',
})
export class TipoCuentaService {
  constructor(private http: HttpClient) {}

  /**
   * get all the tipo cuentas
   */
  getTipoCuentas() {
    const endpoint = `${base_url}/tipocuentas`;
    return this.http.get(endpoint);
  }

  /**
   * save the tipo cuenta
   */
  saveTipoCuenta(body: any) {
    const endpoint = `${base_url}/tipocuentas`;
    return this.http.post(endpoint, body);
  }

  /**
   * update tipo cuenta
   */
  updateTipoCuenta(body: any, id: any) {
    const endpoint = `${base_url}/tipocuentas/ ${id}`;
    return this.http.put(endpoint, body);
  }

  /**
   * delete tipo cuenta
   */
  deleteTipoCuenta(id: any) {
    const endpoint = `${base_url}/tipocuentas/ ${id}`;
    return this.http.delete(endpoint);
  }

  /**
   * search by name
   */
  getTipoCuentaByName(id: any) {
    const endpoint = `${base_url}/tipocuentas/${id}`;
    return this.http.get(endpoint);
  }
  
}
