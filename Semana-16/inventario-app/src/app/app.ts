import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { empleados } from "./components/empleados/empleados";
import { Clientes } from "./components/clientes/clientes";

@Component({
  selector: 'app-root',
  imports: [empleados, Clientes],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'Aplicación Front End';
  suma = 4+4;
}
