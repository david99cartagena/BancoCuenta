import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipocuentasComponent } from './tipocuentas.component';

describe('TipocuentasComponent', () => {
  let component: TipocuentasComponent;
  let fixture: ComponentFixture<TipocuentasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipocuentasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TipocuentasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
