import { Component } from '@angular/core';
import { UsuarioService } from 'src/app/shared/services/usuario.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css'],
})
export class UsuariosComponent {
  UsuarioService: any;
  constructor() {}

  ngOnInit(): void {
    this.getUsuarios();
  }

  getUsuarios() {
    this.UsuarioService.getUsuarios().subscribe(
      (data: any) => {
        console.log('respuesta Usuarios: ', data);
        this.processUsuariosResponse(data);
      },
      (error: any) => {
        console.log('error: ', error);
      }
    );
  }

  processUsuariosResponse(resp: any) {
    const datausuario: usuarioElement[] = [];

    if (resp.metadata[0].code == '00') {
      let listusuario = resp.usuarioResponse.usuario;

      listusuario.forEach((element: usuarioElement) => {
        datausuario.push(element);
      });
    }
  }

  openusuarioDialog() {
    const dialogRef = this.dialog.open(NewUsuarioComponent, {
      width: '450px',
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result == 1) {
        this.openSnackBar('Usuario Agregada', 'Exitosa');
        this.getUsuarios();
      } else if (result == 2) {
        this.openSnackBar('Se produjo un error al guardar Usuario', 'Error');
      }
    });
  }

  edit(id: number, nombre: string, apellido: string) {
    const dialogRef = this.dialog.open(NewUsuarioComponent, {
      data: { id: id, nombre: nombre, apellido: apellido },
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result == 1) {
        this.openSnackBar('Usuario Actualizada', 'Exitosa');
        this.getUsuarios();
      } else if (result == 2) {
        this.openSnackBar(
          'Se produjo un error al actualizar Usuario',
          'Error'
        );
      }
    });
  }

  delete(id: any) {
    const dialogRef = this.dialog.open(ConfirmComponent, {
      data: { id: id, module: 'usuario' },
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result == 1) {
        this.openSnackBar('Usuario Eliminada', 'Exitosa');
        this.getUsuarios();
      } else if (result == 2) {
        this.openSnackBar('Se produjo un error al eliminar Usuario', 'Error');
      }
    });
  }

  buscar(termino: string) {
    if (termino.length === 0) {
      return this.getUsuarios();
    }

    this.UsuarioService.getUsuarioById(termino).subscribe((resp: any) => {
      this.processUsuariosResponse(resp);
    });
  }

  openSnackBar(
    message: string,
    action: string
  ): MatSnackBarRef<SimpleSnackBar> {
    return this.snackBar.open(message, action, {
      duration: 2000,
    });
  }
}

export interface usuarioElement {
  id: number;
  nombre: string;
  apellido: string;
}
