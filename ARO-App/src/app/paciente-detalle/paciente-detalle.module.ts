import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PacienteDetallePageRoutingModule } from './paciente-detalle-routing.module';

import { PacienteDetallePage } from './paciente-detalle.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PacienteDetallePageRoutingModule
  ],
  declarations: [PacienteDetallePage]
})
export class PacienteDetallePageModule {}
