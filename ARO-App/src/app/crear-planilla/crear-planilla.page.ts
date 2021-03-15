import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PlanillaService } from '../services/planilla.service';

@Component({
  selector: 'app-crear-planilla',
  templateUrl: './crear-planilla.page.html',
  styleUrls: ['./crear-planilla.page.scss'],
})
export class CrearPlanillaPage implements OnInit {
  id_Paciente: any;
  datosPlanilla = '';
  planillaForm: FormGroup;

  urlServidor = 'https://residencia-aro.herokuapp.com';
  public contenidoArray: any = null;

  constructor(
    private http: HttpClient,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder,
    private planillaService: PlanillaService,
    private paramRoute: ActivatedRoute,
    private router: Router
  ) {
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

  ngOnInit() {
    this.paramRoute.paramMap.subscribe((param) => {
      this.id_Paciente = param.get('id');
      this.getPlanilla(param.get('id'));
    });
    this.listarEnfermeros();
  }

  getPlanilla(id) {
    this.planillaService.getPlanillas(id).subscribe((planillas: any) => {
      this.datosPlanilla = planillas;
      console.log(planillas);
      this.planillaForm.patchValue({ paciente: planillas.paciente.href });
      console.log(this.planillaForm);
    });
  }
  onSelectEnfermero(enfermero) {
    console.log(enfermero);
    this.planillaForm.patchValue({ enfermero: enfermero.$$href });
    console.log(this.planillaForm);
  }

  listarEnfermeros() {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const URL =
      this.urlServidor +
      '/restful/services/DatosEnfermero/actions/listAll/invoke';
    this.http.get(URL, httpOptions).subscribe((resultados: Array<any>) => {
      var array = resultados;
      array.pop();
      this.contenidoArray = array;
      console.log(this.contenidoArray);
    });
  }

  submit() {
    console.log('aqui es submit id' + this.id_Paciente);
    this.planillaService
      .crearPlanilla(this.id_Paciente, this.planillaForm.value)
      .subscribe((planilla) => {
        console.log(planilla);
      });
    this.router.navigate([
      '/menu/planillas',
      { id_Paciente: this.id_Paciente },
    ]);
  }
}
