import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PacienteDetallePage } from './paciente-detalle.page';

const routes: Routes = [
  {
    path: '',
    component: PacienteDetallePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PacienteDetallePageRoutingModule {}
