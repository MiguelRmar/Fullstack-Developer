export class EmployeeModel{
    constructor(
       public fullname: string,
       public position: string,
       public identificacion: number,
       public boss: number
    ){

    }
}