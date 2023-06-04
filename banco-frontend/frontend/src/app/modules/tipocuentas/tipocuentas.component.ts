import { Component } from '@angular/core';
import { TipoCuentaService } from 'src/app/shared/services/tipocuenta.service';

@Component({
  selector: 'app-tipocuentas',
  templateUrl: './tipocuentas.component.html',
  styleUrls: ['./tipocuentas.component.css'],
})
export class TipocuentasComponent {
  TipoCuentasService: any;
  constructor() {}

  ngOnInit(): void {
    this.getTipocuentas();
  }

  getTipocuentas() {
    this.TipoCuentasService.getTipocuentas().subscribe(
      (data: any) => {
        console.log('respuesta tipo cuentas: ', data);
        this.processTipoCuentassResponse(data);
      },
      (error: any) => {
        console.log('error: ', error);
      }
    );
  }

  processTipoCuentassResponse(resp: any) {
    const dataTipoCuentas: tipocuentasElement[] = [];

    if (resp.metadata[0].code == '00') {
      let listTipoCuentas = resp.tipocuentasResponse.tipocuentas;

      listTipoCuentas.forEach((element: tipocuentasElement) => {
        dataTipoCuentas.push(element);
      });
    }
  }

  openTipoCuentasDialog() {
    const dialogRef = this.dialog.open(NewTipoCuentasComponent, {
      width: '450px',
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result == 1) {
        this.openSnackBar('Tipo Cuenta Agregada', 'Exitosa');
        this.getTipocuentas();
      } else if (result == 2) {
        this.openSnackBar(
          'Se produjo un error al guardar Tipo Cuenta',
          'Error'
        );
      }
    });
  }

  edit(id: number, name: string, description: string) {
    const dialogRef = this.dialog.open(NewTipoCuentasComponent, {
      data: { id: id, name: name, description: description },
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result == 1) {
        this.openSnackBar('Tipo Cuenta Actualizada', 'Exitosa');
        this.getTipocuentas();
      } else if (result == 2) {
        this.openSnackBar(
          'Se produjo un error al actualizar Tipo Cuenta',
          'Error'
        );
      }
    });
  }

  delete(id: any) {
    const dialogRef = this.dialog.open(ConfirmComponent, {
      data: { id: id, module: 'tipocuentas' },
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result == 1) {
        this.openSnackBar('Tipo Cuenta Eliminada', 'Exitosa');
        this.getTipocuentas();
      } else if (result == 2) {
        this.openSnackBar(
          'Se produjo un error al eliminar Tipo Cuenta',
          'Error'
        );
      }
    });
  }

  buscar(termino: string) {
    if (termino.length === 0) {
      return this.getTipocuentas();
    }

    this.TipoCuentasService.getTipocuentaById(termino).subscribe((resp: any) => {
      this.processTipoCuentassResponse(resp);
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

export interface tipocuentasElement {
  id: number;
  nombre: string;
  apellido: string;
}
