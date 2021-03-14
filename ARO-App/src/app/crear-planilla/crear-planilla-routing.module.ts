import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CrearPlanillaPage } from './crear-planilla.page';

const routes: Routes = [
  {
    path: '',
    component: CrearPlanillaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CrearPlanillaPageRoutingModule {}
