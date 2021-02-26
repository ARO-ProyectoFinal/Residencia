import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { EnfermeroDetallePageRoutingModule } from './enfermero-detalle-routing.module';

import { EnfermeroDetallePage } from './enfermero-detalle.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    EnfermeroDetallePageRoutingModule
  ],
  declarations: [EnfermeroDetallePage]
})
export class EnfermeroDetallePageModule {}
