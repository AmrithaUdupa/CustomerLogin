import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {
  StudentArray: any[] = [];
  name: string = "";
  password: string = "";
  currentStudentID: string = "";

  
  // To make http request to the backend API
  constructor(private http: HttpClient) {}

  // It calls getAllStudent to fetch and display all student records when the component loads.
  ngOnInit(): void {
    this.getAllStudent();
  }


  register() {

    // creates a constant object bodyData which includes current value of student details from the component
    const bodyData = {
      name: this.name,
      password: this.password,
    };
    console.log('Registering student with data:', bodyData);

    
    // send a POST request
    // The subscribe method is used to handle the observable returned by the post method. 
    // The next function is called when the request is successful.
    this.http.post("http://localhost:8081/addStudent", bodyData, { responseType: 'text' }).subscribe({
      next: (resultData: any) => {
        console.log(resultData);
        alert("Student Registered Successfully");
        this.getAllStudent();
        this.clearForm();
      },
      error: (error) => {
        console.error('Error registering student:', error);
        if (error.status === 409) {
          if (error.error.includes('Duplicate username and password combination')) {
            alert('Duplicate username and password combination');
          } else {
            alert('Duplicate key error: ' + error.error);
          }
        } else {
          alert('Error saving student: ' + error.message);
        }
      }
    });
  }


  getAllStudent() {
    console.log('Fetching all students');
    this.http.get<any>("http://localhost:8081/getStudent").subscribe({
      next: (resultData: any[]) => {
        console.log('Fetched students:', resultData);

        // Assigns the fetched data to the Updating StudentArray
        this.StudentArray = resultData;
      },
      error: (error) => {
        console.error('Error fetching students:', error);
      }
    });
  }

  setUpdate(data: any) {
    console.log('Setting student for update:', data);
    this.name = data.name;
    this.password = data.password;
    
    this.currentStudentID = data.id;
    console.log('currentStudentID set to:', this.currentStudentID);

  }

  updateRecords() {
    
    const bodyData = {
      id: this.currentStudentID,
      name: this.name,
      password: this.password,
    };

    console.log('Updating student with ID:', this.currentStudentID, 'and data:', bodyData);

    this.http.put(`http://localhost:8081/updateStudent`, bodyData, { responseType: 'json' }).subscribe({
      next: (resultData: any) => {
        console.log('Update response:', resultData);
        alert("Student Record Updated");
        this.getAllStudent();
        this.clearForm();
        // this.StudentArray = resultData;
      },
      error: (error) => {
        console.error('Error updating student:', error);
        alert('Error updating student: ' + error.message);
      }
    });
  }

  save() {
    console.log('Saving student');
    if (this.currentStudentID === '') {
      this.register();
    } else {
      this.updateRecords();
    }
  }

  setDelete(data: any) {
    console.log('Deleting student with ID:', data.id);

    this.http.delete(`http://localhost:8081/deleteStudent/${data.id}`, { responseType: 'text' }).subscribe({
      next: (resultData: any) => {
        console.log(resultData);
        alert("Student Deleted");
        this.getAllStudent();
        this.clearForm();
      },
      error: (error) => {
        console.error('Error deleting student:', error);
      }
    });
  }

  clearForm() {
    console.log('Clearing form');
    this.name = '';
    this.password = '';
    this.currentStudentID = '';
  }

}
