import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLogModalComponent } from './add-log-modal.component';

describe('AddLogModalComponent', () => {
  let component: AddLogModalComponent;
  let fixture: ComponentFixture<AddLogModalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddLogModalComponent]
    });
    fixture = TestBed.createComponent(AddLogModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
