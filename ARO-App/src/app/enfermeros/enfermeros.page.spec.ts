import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { EnfermerosPage } from './enfermeros.page';

describe('EnfermerosPage', () => {
  let component: EnfermerosPage;
  let fixture: ComponentFixture<EnfermerosPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnfermerosPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(EnfermerosPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
