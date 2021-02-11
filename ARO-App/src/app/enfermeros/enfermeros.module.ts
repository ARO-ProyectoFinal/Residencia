import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { EnfermerosPageRoutingModule } from './enfermeros-routing.module';

import { EnfermerosPage } from './enfermeros.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    EnfermerosPageRoutingModule
  ],
  declarations: [EnfermerosPage]
})
export class EnfermerosPageModule {}
