import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './pages/home/home.component';
import { LayoutComponent } from './sharepage/layout/layout.component';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from './sharepage/navbar/navbar.component';
import { AuthService } from './service/auth.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    LayoutComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    AuthService,
    provideHttpClient(withInterceptorsFromDi()) 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
