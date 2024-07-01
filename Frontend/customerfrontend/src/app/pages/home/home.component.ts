import { Component } from '@angular/core';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  StudentArray: any[] = [];
  name: string = "";
  password: string = "";
  currentStudentID: string = "";
}
