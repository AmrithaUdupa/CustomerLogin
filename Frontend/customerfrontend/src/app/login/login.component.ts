import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  navigateToRegistration() {
    this.router.navigate(['registration']);
  }

  name: string = '';
  password: string = '';

  constructor(private http: HttpClient, private router: Router, private authService: AuthService) {}

  login() {
    const bodyData = {
      name: this.name,
      password: this.password
    };

    this.http.post<any>('http://localhost:8086/addStudent/login', bodyData)
      .subscribe({
        next: (response: any) => {
          console.log(response); // Log the response for debugging
          if (response.message === 'Login successful!') {
            this.authService.login(this.name,this.password); // Set login state
            alert("Login successful!"); // Or redirect to another page
            this.router.navigate(['/home']); // Redirect to welcome page or home
          } else {
            alert("Incorrect username or password");
          }
        },
        error: (error) => {
          console.error('Error logging in:', error);
          alert("Error logging in: " + error.message);
        }
      });
  }
}
