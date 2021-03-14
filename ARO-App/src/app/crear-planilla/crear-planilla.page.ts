import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { PlanillaService } from '../services/planilla.service';

@Component({
  selector: 'app-crear-planilla',
  templateUrl: './crear-planilla.page.html',
  styleUrls: ['./crear-planilla.page.scss'],
})
export class CrearPlanillaPage implements OnInit {
  id_Planilla: any;
  datosPlanilla;
  planillaForm: FormGroup;

  constructor(
    private http: HttpClient,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder,
    private planillaService: PlanillaService,
    private paramRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.paramRoute.paramMap.subscribe((param) => {
      this.id_Planilla = param.get('id');
    });
    this.initForm();
  }

  getPlanilla(id) {
    this.planillaService.getPlanillas(id).subscribe((planillas) => {
      this.datosPlanilla = planillas;
      this.planillaForm.patchValue(this.datosPlanilla);
    });
  }

  initForm() {
    this.planillaForm = this.fb.group({
      paciente: [''],
      enfermero: [''],
      fechaPlanilla: [''],
      medicacion: [''],
      limpieza: [''],
      ropa: [''],
      turno: [''],
      comidas: [''],
      curaciones: [''],
      actividadFisica: [''],
      observacion: [''],
    });
  }

  submit() {
    console.log('aqui es submit id' + this.id_Planilla);
    this.planillaService
      .crearPlanilla(this.id_Planilla, this.planillaForm.value)
      .subscribe((planilla) => {});
    location.reload();
  }
}
