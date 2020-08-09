import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute, Params} from '@angular/router';
import { BsModalService } from 'ngx-bootstrap/modal';

//modelos
import { EmployeeModel } from '../../models/employee.model';
//servicios
import { EmployeServices } from '../../services/employee.service';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html'
})
export class EmpleadosComponent implements OnInit {

  employee: EmployeeModel;
  employeeSelected: EmployeeModel;
  ListEmploee: Array<EmployeeModel>;
  statusResponse: string;
  modal: any; 
  lengList:Number;

  constructor(
    private _route:ActivatedRoute,
    private _router: Router,
    private _employeeService: EmployeServices,
    private modalService: BsModalService,
  ) {}

  ngOnInit(){
    
     this.employee = new EmployeeModel('','',0,0);
     this.getListEmployees();
    
  }

  handlePage(e: PageEvent)
    {
        this.page_size = e.pageSize;
        this.page_number = e.pageIndex + 1;
    }
    //Paginacion
    page_size: number = 10;
    page_number: number = 1;
    pageSizeOptions = [5, 10, 15, 20];
    ListaLenght: number ;

    getListEmployees()
    {
        this._employeeService.getEmployee().subscribe(
            response =>{
                
                    this.ListEmploee = response;
                    this.lengList = this.ListEmploee.length;
                    this.statusResponse == 'success';
                
                
            },
            error =>{
                console.log(error);
                this.statusResponse == 'error';
            }
        )
    }

    CreateEmployee(templeateUpsert) {
        this.employeeSelected = new EmployeeModel('','',0,0);
        this.modal = this.modalService.show(
          templeateUpsert,
          Object.assign({ target: "static" }, { class: "gray modal-lg" })
        );
      }
    
      refrescar(evento)
      {
          this.modal.hide();
          this.statusResponse = evento;
          this.getListEmployees();
      }




}
