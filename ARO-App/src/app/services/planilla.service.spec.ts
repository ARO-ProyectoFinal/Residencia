import { TestBed } from '@angular/core/testing';

import { PlanillaService } from './planilla.service';

describe('PlanillaService', () => {
  let service: PlanillaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlanillaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
