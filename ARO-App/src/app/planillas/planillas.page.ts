import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-planillas',
  templateUrl: './planillas.page.html',
  styleUrls: ['./planillas.page.scss'],
})
export class PlanillasPage implements OnInit {
  constructor(private http: HttpClient, private router: Router) {}

  public contenidoArray: any = null;
  urlServidor = 'https://residencia-aro.herokuapp.com';

  ngOnInit() {
    this.listarPlanillas();
  }
  listarPlanillas() {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const URL =
      this.urlServidor +
      '/restful/services/PlanillaEnfermero/actions/listAll/invoke';
    this.http.get(URL, httpOptions).subscribe((resultados: Array<any>) => {
      var array = resultados;
      array.pop();
      this.contenidoArray = array;
    });
  }
  obtienePlanilla(idPlanilla) {
    this.router.navigate(['/planillas-diarias', { id: idPlanilla }]);
  }

  crearPlanilla(idPlanilla) {
    console.log(idPlanilla);
    this.router.navigate(['/crear-planilla', { id: idPlanilla }]);
  }
}
