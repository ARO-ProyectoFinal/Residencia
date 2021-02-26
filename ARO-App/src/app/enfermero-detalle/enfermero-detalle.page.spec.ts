import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { EnfermeroDetallePage } from './enfermero-detalle.page';

describe('EnfermeroDetallePage', () => {
  let component: EnfermeroDetallePage;
  let fixture: ComponentFixture<EnfermeroDetallePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnfermeroDetallePage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(EnfermeroDetallePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
