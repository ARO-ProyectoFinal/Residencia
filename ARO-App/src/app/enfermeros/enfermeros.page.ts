import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { EnfermeroService } from '../services/enfermero.service';
import { Enfermero } from '../enfermeros/enfermero';

@Component({
  selector: 'app-enfermeros',
  templateUrl: './enfermeros.page.html',
  styleUrls: ['./enfermeros.page.scss'],
})
export class EnfermerosPage implements OnInit {


  enfermeroId: any = 1;
  enfermero : Enfermero [] = [];
  mostrar: boolean = false;
  ver: boolean = true;
  enfermeroForm: FormGroup;



  constructor(
    private enfermeroService: EnfermeroService,
    private fb: FormBuilder, 
    private paramRoute: ActivatedRoute
    ) { }

  ngOnInit() {
    this.paramRoute.paramMap.subscribe( param => {
      this.enfermeroId = param.get('id');
    })
    this.getEnfermero(this.enfermeroId);
    this.initForm();
 
  }


  initForm(){
    this.enfermeroForm = this.fb.group({
      nombre: [''],
      fechaAlta: [''],
      edad: [''],
      telefono: [''],
      observacion: ['']
    });
  }

  getEnfermero(id){
    this.enfermeroService.getEnfermero(id).subscribe((enfermero: Enfermero[]) => {
      this.enfermero = enfermero;
      this.enfermeroForm.patchValue(this.enfermero);

    });
  }

}