import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-enfermeros',
  templateUrl: './enfermeros.page.html',
  styleUrls: ['./enfermeros.page.scss'],
})
export class EnfermerosPage implements OnInit {
  constructor(private http: HttpClient, private router: Router) {}

  public contenidoArray: any = null;

  ngOnInit() {
    this.listarEnfermeros();
  }
  listarEnfermeros() {
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const URL =
      'http://localhost:8080/restful/services/DatosEnfermero/actions/listAll/invoke';
    this.http.get(URL, httpOptions).subscribe((resultados: Array<any>) => {
      var array = resultados;
      array.pop();
      this.contenidoArray = array;
    });
  }
  obtieneEnfermero(idEnfermero) {
    console.log(idEnfermero);
    this.router.navigate(['/enfermero-detalle', { id_Enfermero: idEnfermero }]);
  }
}
