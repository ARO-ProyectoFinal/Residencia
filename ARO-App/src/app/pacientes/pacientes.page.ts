import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.page.html',
  styleUrls: ['./pacientes.page.scss'],
})
export class PacientesPage implements OnInit {
  resultadosArraytemp: any;
  constructor(private http: HttpClient, private router: Router) {}

  public contenidoArray: any = null;
  public resultadosArrayFiltrado = [];

  ngOnInit() {
    this.listarPacientes();
  }
  listarPacientes() {
    this.resultadosArrayFiltrado = [];
    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic QWRtaW46YWRtaW4=',
      }),
    };
    const URL =
      'http://localhost:8080/restful/services/Paciente/actions/listAll/invoke';
    this.http.get(URL, httpOptions).subscribe((resultados: Array<any>) => {
      this.contenidoArray = resultados;
      this.resultadosArraytemp = this.contenidoArray;

      this.resultadosArraytemp.pop();

      const largoArray = this.resultadosArraytemp.length;

      for (var i = 0; i < largoArray; ) {
        if (this.resultadosArraytemp[i].hasOwnProperty('estado')) {
          if (this.resultadosArraytemp[i].estado == 'Activo') {
            this.resultadosArrayFiltrado.push(this.contenidoArray[i]);
          }
        }
        i = i + 1;
      }

      this.contenidoArray = this.resultadosArrayFiltrado;
    });
  }
  obtienePaciente(idPaciente) {
    console.log(idPaciente);
    this.router.navigate(['/paciente-detalle', { id_Paciente: idPaciente }]);
  }
}
