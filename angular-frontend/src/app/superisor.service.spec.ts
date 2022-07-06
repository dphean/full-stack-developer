import { TestBed } from '@angular/core/testing';

import { SuperisorService } from './superisor.service';

describe('SuperisorService', () => {
  let service: SuperisorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SuperisorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
