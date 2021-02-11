import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PlanillasDiariasPage } from './planillas-diarias.page';

const routes: Routes = [
  {
    path: '',
    component: PlanillasDiariasPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PlanillasDiariasPageRoutingModule {}
