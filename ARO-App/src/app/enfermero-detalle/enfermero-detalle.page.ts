import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-enfermero-detalle',
  templateUrl: './enfermero-detalle.page.html',
  styleUrls: ['./enfermero-detalle.page.scss'],
})
export class EnfermeroDetallePage implements OnInit {
  id_Enfermero;
  datosEnfermero;
  param: any;
  urlServidor = 'https://residencia-aro.herokuapp.com';
  constructor(
    private http: HttpClient,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.param = this.activatedRoute.snapshot.params;
    if (Object.keys(this.param).length) {
      this.detallarEnfermero(this.param.id_Enfermero);
    }
  }
  detallarEnfermero(id_Enfermero) {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const URL =  this.urlServidor+'/restful/objects/simple.DatosEnfermero/' +
      id_Enfermero;
    this.http.get(URL, httpOptions).subscribe((resultados) => {
      this.datosEnfermero = resultados;
    });
  }
}
