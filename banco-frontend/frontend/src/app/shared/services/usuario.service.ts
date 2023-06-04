import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

const base_url = environment.base_url;

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  constructor(private http: HttpClient) {}

  /**
   * get all usuarios
   */
  getUsuarios() {
    const endpoint = `${base_url}/usuarios`;
    return this.http.get(endpoint);
  }

  /**
   * save the Usuarios
   */
  saveUsuario(body: any) {
    const endpoint = `${base_url}/usuarios`;
    return this.http.post(endpoint, body);
  }

  /**
   * update Usuarios
   */
  updateUsuario(body: any, id: any) {
    const endpoint = `${base_url}/usuarios/ ${id}`;
    return this.http.put(endpoint, body);
  }

  /**
   * delete Usuarios
   */
  deleteUsuario(id: any) {
    const endpoint = `${base_url}/usuarios/ ${id}`;
    return this.http.delete(endpoint);
  }

  /**
   * Id Usuario
   */
  getUsuarioById(id: any) {
    const endpoint = `${base_url}/usuarios/ ${id}`;
    return this.http.get(endpoint);
  }
}
