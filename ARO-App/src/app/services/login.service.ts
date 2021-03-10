import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  Auth64: string;
  n: string;

  constructor(private httpClient: HttpClient) {}

  public consulta: any;
  public IPServidor: String = 'http://localhost:8080';
  public URLservidor: String;

  realizaLogin(username: String, password: String) {
    if (window.localStorage.URLservidor) {
      this.URLservidor = window.localStorage.URLservidor;
    } else {
      this.URLservidor = this.IPServidor;
    }

    this.Auth64 = btoa(username + ':' + password);

    const httpOptions = {
      headers: new HttpHeaders({
        Accept: 'application/json;profile=urn:org.apache.isis/v1',
        Authorization: 'Basic ' + this.Auth64,
      }),
    };
    const Url = this.URLservidor + '/restful/objects/DatosEnfermero/';

    return this.httpClient.get(Url + 1, httpOptions);
  }
}
