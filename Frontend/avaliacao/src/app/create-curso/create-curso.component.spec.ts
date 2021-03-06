import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCursoComponent } from './create-curso.component';

describe('CreateCursoComponent', () => {
  let component: CreateCursoComponent;
  let fixture: ComponentFixture<CreateCursoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCursoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
