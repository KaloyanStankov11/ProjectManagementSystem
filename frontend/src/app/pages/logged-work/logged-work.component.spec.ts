import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoggedWorkComponent } from './logged-work.component';

describe('LoggedWorkComponent', () => {
  let component: LoggedWorkComponent;
  let fixture: ComponentFixture<LoggedWorkComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoggedWorkComponent]
    });
    fixture = TestBed.createComponent(LoggedWorkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
