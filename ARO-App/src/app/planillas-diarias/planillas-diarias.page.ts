import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-planillas-diarias',
  templateUrl: './planillas-diarias.page.html',
  styleUrls: ['./planillas-diarias.page.scss'],
})
export class PlanillasDiariasPage implements OnInit {
  id_Planilla;
  datosPlanilla;
  param: any;
  editable: boolean= false;
  verPlanilla: boolean= true;
  constructor(
    private http: HttpClient,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.param = this.activatedRoute.snapshot.params;
    if (Object.keys(this.param).length) {
      this.detallarPlanilla(this.param.id_Planilla);
    }
  }
  detallarPlanilla(id_Planilla) {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const URL =
      'http://localhost:8080/restful/objects/simple.PlanillaEnfermero/' +
      id_Planilla;
    this.http.get(URL, httpOptions).subscribe((resultados) => {
      this.datosPlanilla = resultados;
      console.log(this.datosPlanilla);
      console.log(this.datosPlanilla.paciente.title)
    });
  }
  crear(){
    if(this.editable == false){
      this.editable = true;
      this.verPlanilla = false;
    }
    else{
      this.editable= false;
      this.verPlanilla = true;
    }
  }



}
