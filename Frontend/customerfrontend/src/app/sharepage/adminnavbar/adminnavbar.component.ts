import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-adminnavbar',
  templateUrl: './adminnavbar.component.html',
  styleUrl: './adminnavbar.component.css'
})
export class AdminnavbarComponent {
  welcomeMessage: string = '';
  constructor(private router: Router , private authService:AuthService) {}
  onLogout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  ngOnInit(): void {
    this.welcomeMessage = `Welcome, ${this.authService.getUserName()}!`;
  }
}
