import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PacientesPage } from './pacientes.page';

describe('PacientesPage', () => {
  let component: PacientesPage;
  let fixture: ComponentFixture<PacientesPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacientesPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PacientesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
