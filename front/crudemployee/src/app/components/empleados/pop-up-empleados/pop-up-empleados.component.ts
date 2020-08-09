import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Router, ActivatedRoute, Params} from '@angular/router';
//modelos
import { EmployeeModel } from '../../../models/employee.model';
//servicios
import { EmployeServices } from '../../../services/employee.service';

@Component({
  selector: 'app-pop-up-empleados',
  templateUrl: './pop-up-empleados.component.html'
})
export class PopUpEmpleadosComponent implements OnInit {

  public boton: boolean = false;
  public statusResponse: string;
  @Output() refrescar = new EventEmitter();
  @Input('employeeSelected')
  employeeSelected: EmployeeModel;

  constructor(
    private _route:ActivatedRoute,
    private _router: Router,
    private _employeService : EmployeServices,
  ) { }

   ngOnInit() {
  }


  validacionCampos()
  {
      if(
      this.employeeSelected.fullname == null
      || this.employeeSelected.position == null
      || this.employeeSelected.identificacion == null)
      {
        this.boton = false;
      }
      else
      {
        this.boton = true;
      }
  }

  guardar()
  {
      if(this.employeeSelected.identificacion == 0 )
      {
        //todo update
        error =>
        {
            console.log(<any>error);
            this.statusResponse = 'error';
            this.refrescar.emit('error');
        }
      }
      else
      {
          this._employeService.create(this.employeeSelected).subscribe(
              response =>{
                  
                      this.employeeSelected = response;
                      this.statusResponse = 'success';
                      this.refrescar.emit('success');
                  
              },
              error =>
              {
                  console.log(<any>error);
                  this.statusResponse = 'error';
                  this.refrescar.emit('error');
              }
          )
      }
  }

  

}
