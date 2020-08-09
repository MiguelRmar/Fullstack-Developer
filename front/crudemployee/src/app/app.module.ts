import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpleadosComponent } from './components/empleados/empleados.component';
import { PopUpEmpleadosComponent } from './components/empleados/pop-up-empleados/pop-up-empleados.component';
//Services
import{EmployeServices} from './services/employee.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import {PaginatePipe} from './pippes/paginate.pippe'
import { CommonModule } from '@angular/common';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatTabsModule} from '@angular/material/tabs';
import { ModalModule } from 'ngx-bootstrap/modal';
import { MatPaginatorModule } from '@angular/material/paginator'

@NgModule({
  declarations: [
    AppComponent,
    EmpleadosComponent,
    PopUpEmpleadosComponent,
    PaginatePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    MatTabsModule,
    MatPaginatorModule,
    ModalModule.forRoot()
    
  ],
  providers: [EmployeServices],
  bootstrap: [AppComponent]
})
export class AppModule { }
