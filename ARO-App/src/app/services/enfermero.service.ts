import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EnfermeroService {constructor(private httpClient: HttpClient) { }


httpOptions = {
  headers: new HttpHeaders({
    'Accept':  'application/json;profile=urn:org.apache.isis/v1',
    'Authorization': 'Basic c3ZlbjpwYXNz',
  })
}

private Url ='http://localhost:8080/restful/objects/simple.DatosEnfermero/1';



getEnfermero(id: number){
  return this.httpClient.get(this.Url, this.httpOptions);
}


}