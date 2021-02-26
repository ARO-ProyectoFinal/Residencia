import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PlanillasPageRoutingModule } from './planillas-routing.module';

import { PlanillasPage } from './planillas.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PlanillasPageRoutingModule
  ],
  declarations: [PlanillasPage]
})
export class PlanillasPageModule {}
