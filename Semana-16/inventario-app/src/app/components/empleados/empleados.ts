import { Component } from "@angular/core";

//1. Crear el decorador
@Component({
    selector:'app-empleados',
    templateUrl:'./empleados.html',
    styleUrl:'./empleados.css'
})
//2. Creación de la clase
export class empleados{
    protected nombre="Elvis Cayllahua";
}