import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PlanillasPage } from './planillas.page';

describe('PlanillasPage', () => {
  let component: PlanillasPage;
  let fixture: ComponentFixture<PlanillasPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanillasPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PlanillasPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
