import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(name: string, password: string) {
    const bodyData = { name, password };
    return this.http.post<any>('http://localhost:8081/addStudent/login', bodyData);
  }
}
