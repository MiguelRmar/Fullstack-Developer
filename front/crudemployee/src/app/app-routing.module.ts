import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmpleadosComponent} from './components/empleados/empleados.component'

const routes: Routes = [
   {path:'employee', component:EmpleadosComponent},
   {path:'', component:EmpleadosComponent},
   {path:'**', component:EmpleadosComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
