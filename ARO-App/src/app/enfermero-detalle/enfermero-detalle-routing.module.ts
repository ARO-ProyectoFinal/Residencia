import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { EnfermeroDetallePage } from './enfermero-detalle.page';

const routes: Routes = [
  {
    path: '',
    component: EnfermeroDetallePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class EnfermeroDetallePageRoutingModule {}
