import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import {PlanillaService} from './../services/planilla.service';
@Component({
  selector: 'app-planillas-diarias',
  templateUrl: './planillas-diarias.page.html',
  styleUrls: ['./planillas-diarias.page.scss'],
})
export class PlanillasDiariasPage implements OnInit {
  id_Planilla: any;
  datosPlanilla;
  editable: boolean = false;
  verPlanilla: boolean = true;
  planillaForm: FormGroup;
  urlServidor = 'https://residencia-aro.herokuapp.com';
  constructor(
    private http: HttpClient,
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder,
    private planillaService: PlanillaService,
    private paramRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.paramRoute.paramMap.subscribe( param => {
      this.id_Planilla = param.get('id');
    })
    this.detallarPlanilla(this.id_Planilla);
    this.initForm();
    
  }

  getPlanilla(id) {
      this.planillaService.getPlanillas(id).subscribe((planillas) => {
      this.datosPlanilla = planillas;
      this.planillaForm.patchValue(this.datosPlanilla);
    });
  }

  initForm() {
    this.planillaForm= this.fb.group({
      fechaPlanilla :[''] ,
      medicacion :[''],
      limpieza :[''],
      ropa :[''],
      turno :[''],
      comidas :[''],
      curaciones :[''],
      actividadFisica:[''],
      observacion :[''],
    });
  }

  detallarPlanilla(id_Planilla) {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const URL = this.urlServidor+'/restful/objects/simple.PlanillaEnfermero/' +
      id_Planilla;
      this.http.get(URL, httpOptions).subscribe((resultados) => {
      this.datosPlanilla = resultados;
    
    });
    
  }
 
  crear() {
    if (this.editable == false) {
      this.editable = true;
      this.verPlanilla = false;
    } else {
      this.editable = false;
      this.verPlanilla = true;
    }
  }
  submit(){
    console.log("aqui es submit id" +this.id_Planilla);
    this.planillaService.updatePlanilla(this.id_Planilla, this.planillaForm.value).subscribe((planilla)=>{
      
    })
    location.reload();
  }
}