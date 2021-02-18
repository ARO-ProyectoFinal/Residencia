import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.page.html',
  styleUrls: ['./pacientes.page.scss'],
})
export class PacientesPage implements OnInit {
  constructor(private http: HttpClient, private router: Router) { }

  public contenidoArray: any = null;

  ngOnInit() {
    this.listarPacientes();
  }
  listarPacientes() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Accept': 'application/json;profile=urn:org.apache.isis/v1',
        'Authorization': 'Basic c3ZlbjpwYXNz',
      })
    }
    const URL = 'http://localhost:8080/restful/services/Paciente/actions/listAll/invoke';
    this.http.get(URL, httpOptions)
      .subscribe((resultados: Array<any>) => {
        var array = resultados;
        array.pop();
        this.contenidoArray = array;
      });

  }
  obtienePaciente(idPaciente) { 
    console.log(idPaciente);
    this.router.navigate(['/paciente-detalle', { id_Paciente: idPaciente }])
  }

}