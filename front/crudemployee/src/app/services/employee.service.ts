import{Injectable} from '@angular/core';
import{HttpClient,HttpHeaders} from '@angular/common/http';
import{Observable} from 'rxjs/Observable';
import{GLOBAL} from './global.service';
import{EmployeeModel} from '../models/employee.model'; 

const httOptions=
{
    headers:new HttpHeaders({
        'Content-Type':'application/json',
    })
};

@Injectable()
export class EmployeServices{
    public url:string;
    public getEmployees:string;
    public createEmployes:string;

    constructor(
        public _http: HttpClient
    )
    {
        this.url=GLOBAL.url;
        this.getEmployees = GLOBAL.getEmployees;
        this.createEmployes= GLOBAL.createEmployee;
    }

    create(employee:EmployeeModel):Observable<any>
    {
        return this._http.post(this.createEmployes, employee, httOptions); 
    }
    
    getEmployee() : Observable<any>
    {
        return this._http.get(this.getEmployees,httOptions)
    }
    
}