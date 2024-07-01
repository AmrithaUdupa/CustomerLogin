import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly LOGIN_KEY = 'isLoggedIn';
  private readonly USER_NAME_KEY = 'userName';

  login(name: string) {
    localStorage.setItem(this.LOGIN_KEY, 'true');
    localStorage.setItem(this.USER_NAME_KEY, name);
  }

  logout(): void {
    localStorage.removeItem(this.LOGIN_KEY);
    localStorage.removeItem(this.USER_NAME_KEY);
  }
  
  isLoggedIn(): boolean {
    return localStorage.getItem(this.LOGIN_KEY) === 'true';
  }

  getUserName(): string | null {
    return localStorage.getItem(this.USER_NAME_KEY);
  }
}
