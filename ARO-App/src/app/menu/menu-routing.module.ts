import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MenuPage } from './menu.page';

const routes: Routes = [
  {
    path: '',
    component: MenuPage,
    children: [
      {
        path: 'home',
        loadChildren: () =>
          import('../home/home.module').then((m) => m.HomePageModule),
      },
      {
        path: 'pacientes',
        loadChildren: () =>
          import('../pacientes/pacientes.module').then(
            (m) => m.PacientesPageModule
          ),
      },
      {
        path: 'enfermeros',
        loadChildren: () =>
          import('../enfermeros/enfermeros.module').then(
            (m) => m.EnfermerosPageModule
          ),
      },
      {
        path: 'planillas-diarias',
        loadChildren: () =>
          import('../planillas-diarias/planillas-diarias.module').then(
            (m) => m.PlanillasDiariasPageModule
          ),
      },
      {
        path: 'configuracion',
        loadChildren: () =>
          import('../configuracion/configuracion.module').then(
            (m) => m.ConfiguracionPageModule
          ),
      },
      {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MenuPageRoutingModule {}
