import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root',
})
export class PlanillaService {
  constructor(private httpClient: HttpClient) {}

  urlServidor = 'https://residencia-aro.herokuapp.com';
  httpOptions = {
    headers: new HttpHeaders({
      Accept: 'application/json;profile=urn:org.apache.isis/v1',
      Authorization: 'Basic QWRtaW46YWRtaW4=',
    }),
  };

  private Url = this.urlServidor + '/restful/objects/simple.PlanillaEnfermero/';

  getPlanillas(id: number) {
    console.log('id de getplanilla de planillaService ' + id);
    return this.httpClient.get(this.Url + id, this.httpOptions);
  }

  updatePlanilla(id, planilla) {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const planillaUrl =
      this.urlServidor + '/restful/objects/simple.PlanillaEnfermero/';

    let datos = {
      fechaPlanilla: {
        value: planilla.fechaPlanilla.substr(0, 10),
      },
      turno: {
        value: planilla.turno,
      },
      tomoMedicacion: {
        value: planilla.medicacion,
      },
      realizoCuraciones: {
        value: planilla.curaciones,
      },
      realizoActividadFisica: {
        value: planilla.actividadFisica,
      },
      comidasRealizadas: {
        value: planilla.comidas,
      },
      realizoLimpiezaDeRopa: {
        value: planilla.ropa,
      },
      realizoLimpiezaDePisos: {
        value: planilla.limpieza,
      },
      observacion: {
        value: planilla.observacion,
      },
    };
    console.log(datos);
    return this.httpClient.post(
      planillaUrl + id + '/actions/updatePlanillaEnfermeros/invoke',
      JSON.stringify(datos),
      httpOptions
    );
  }

  crearPlanilla(id, planilla) {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const crearPlanillaUrl =
      this.urlServidor + '/restful/services/PlanillaEnfermero/';

    let datos = {
      'paciente:': {
        value: { href: planilla.paciente },
      },
      'enfermero:': {
        value: { href: planilla.enfermero },
      },
      'fechaPlanilla:': {
        value: planilla.fechaPlanilla.substr(0, 10),
      },
      turno: {
        value: planilla.turno,
      },
      tomoMedicacion: {
        value: planilla.medicacion,
      },
      realizoCuraciones: {
        value: planilla.curaciones,
      },
      realizoActividadFisica: {
        value: planilla.actividadFisica,
      },
      comidasRealizadas: {
        value: planilla.comidas,
      },
      realizoLimpiezaDeRopa: {
        value: planilla.ropa,
      },
      realizoLimpiezaDePisos: {
        value: planilla.limpieza,
      },
      observacion: {
        value: planilla.observacion,
      },
    };
    console.log(datos);
    return this.httpClient.post(
      crearPlanillaUrl + 'actions/create/invoke',
      JSON.stringify(datos),
      httpOptions
    );
  }
}
