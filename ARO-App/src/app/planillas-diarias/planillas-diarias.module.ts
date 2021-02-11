import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PlanillasDiariasPageRoutingModule } from './planillas-diarias-routing.module';

import { PlanillasDiariasPage } from './planillas-diarias.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PlanillasDiariasPageRoutingModule
  ],
  declarations: [PlanillasDiariasPage]
})
export class PlanillasDiariasPageModule {}
