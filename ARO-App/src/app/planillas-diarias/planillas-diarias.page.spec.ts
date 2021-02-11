import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PlanillasDiariasPage } from './planillas-diarias.page';

describe('PlanillasDiariasPage', () => {
  let component: PlanillasDiariasPage;
  let fixture: ComponentFixture<PlanillasDiariasPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanillasDiariasPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PlanillasDiariasPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
