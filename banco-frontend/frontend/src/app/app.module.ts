import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuariosComponent } from './modules/usuarios/usuarios.component';
import { TipocuentasComponent } from './modules/tipocuentas/tipocuentas.component';
import { CuentasComponent } from './modules/cuentas/cuentas.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuariosComponent,
    TipocuentasComponent,
    CuentasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
