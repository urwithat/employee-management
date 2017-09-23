import { Injectable, Inject, EventEmitter } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class EmployeeService {
  
  employeeUpdatedEvent: EventEmitter<any> = new EventEmitter();

  constructor(public http: Http) {
  }

  create(id, firstName, lastName, gender, emailAddress) {
    let data = {
      "id": (id ? id : this.id()),
      "firstName": firstName,
      "lastName": lastName,
      "gender": gender,
      "emailAddress": emailAddress
    }
    return this.http.post("/api/employees/create", data)
      .map(response => response.json())
  }

  readAll() {
    return this.http.get("/api/employees")
      .map(response => response.json())
  }

  update() {
    return this.http.get("/api/employees/update")
      .map(response => response.json())
  }

  delete() {
    return this.http.get("/employees/delete/{id}")
      .map(response => response.json())
  }

  id() {
    return Math.random() * (999999 - 111111) + 111111;
  }
}