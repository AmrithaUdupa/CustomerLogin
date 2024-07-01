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
            this.authService.login(this.name, this.password);
          

         if (response.role === 'ADMIN') 
          {
                    this.router.navigate(['/admin']); // Redirect to admin dashboard
                } 
                else if (response.role === 'USER') 
                {
                    this.router.navigate(['/home']); // Redirect to user dashboard
                    
                }
                else{
                  alert("Role not defined for the user. Redirecting to default page.");
                    // Navigate to a default page or handle appropriately
                    this.router.navigate(['/home']);

                }
                
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
