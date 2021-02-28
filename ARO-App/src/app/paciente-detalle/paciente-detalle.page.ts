import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-paciente-detalle',
  templateUrl: './paciente-detalle.page.html',
  styleUrls: ['./paciente-detalle.page.scss'],
})
export class PacienteDetallePage implements OnInit {
  id_Paciente;
  datosPaciente;
  param: any;
  constructor(
    private http: HttpClient,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.param = this.activatedRoute.snapshot.params;
    if (Object.keys(this.param).length) {
      this.detallarPaciente(this.param.id_Paciente);
    }
  }
  detallarPaciente(id_Paciente) {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic TWF4aToxMjM0',
      }),
    };
    const URL =
      'http://localhost:8080/restful/objects/simple.Paciente/' + id_Paciente;
    this.http.get(URL, httpOptions).subscribe((resultados) => {
      this.datosPaciente = resultados;
    });
  }
}
