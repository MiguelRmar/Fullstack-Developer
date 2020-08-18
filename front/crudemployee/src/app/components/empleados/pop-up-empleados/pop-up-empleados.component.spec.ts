import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopUpEmpleadosComponent } from './pop-up-empleados.component';

describe('PopUpEmpleadosComponent', () => {
  let component: PopUpEmpleadosComponent;
  let fixture: ComponentFixture<PopUpEmpleadosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopUpEmpleadosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopUpEmpleadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
