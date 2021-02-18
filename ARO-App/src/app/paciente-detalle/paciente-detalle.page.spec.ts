import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PacienteDetallePage } from './paciente-detalle.page';

describe('PacienteDetallePage', () => {
  let component: PacienteDetallePage;
  let fixture: ComponentFixture<PacienteDetallePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacienteDetallePage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PacienteDetallePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
