import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class PlanillaService {

  constructor(private httpClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      Accept: 'application/json;profile=urn:org.apache.isis/v1',
      Authorization: 'Basic QWRtaW46YWRtaW4=',
    }),
  };
  
  private Url = 'http://localhost:8080/restful/objects/simple.PlanillaEnfermero/';
 
   getPlanillas(id: number) {
    debugger;
    console.log("id de getplanilla de planillaService "+id);
    return this.httpClient.get(this.Url+id, this.httpOptions);
  }

  updatePlanilla(id , planilla) {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const planillaUrl = 'http://localhost:8080/restful/objects/simple.PlanillaEnfermero/';

    let datos = {
       "fechaPlanilla": {
        "value": planilla.fechaPlanilla.substr(0,10)
       },
      "turno": {
        "value": planilla.turno
      },
      "tomoMedicacion": {
        "value": planilla.medicacion
      },
      "realizoCuraciones": {
        "value": planilla.curaciones
      },
      "realizoActividadFisica": {
        "value": planilla.actividadFisica
      },
      "comidasRealizadas": {
        "value": planilla.comidas
      },
      "realizoLimpiezaDeRopa": {
        "value": planilla.ropa
      },
      "realizoLimpiezaDePisos": {
        "value": planilla.limpieza
      },
      "observacion": {
        "value": planilla.observacion
      },
           
  };
  console.log(datos);
return this.httpClient.post(planillaUrl+id+"/actions/updatePlanillaEnfermeros/invoke",JSON.stringify(datos), httpOptions);

  }

}
