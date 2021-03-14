import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CrearPlanillaPage } from './crear-planilla.page';

describe('CrearPlanillaPage', () => {
  let component: CrearPlanillaPage;
  let fixture: ComponentFixture<CrearPlanillaPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearPlanillaPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CrearPlanillaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
