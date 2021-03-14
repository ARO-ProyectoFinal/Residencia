import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CrearPlanillaPageRoutingModule } from './crear-planilla-routing.module';

import { CrearPlanillaPage } from './crear-planilla.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CrearPlanillaPageRoutingModule
  ],
  declarations: [CrearPlanillaPage]
})
export class CrearPlanillaPageModule {}
