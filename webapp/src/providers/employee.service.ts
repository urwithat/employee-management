import { Injectable, Inject, EventEmitter } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class EmployeeService {
  
  employeeUpdatedEvent: EventEmitter<any> = new EventEmitter();

  constructor(public http: Http) {
  }

  create(firstName, lastName, gender, emailAddress) {
    let data = {
      "id": this.guid,
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

  guid() {
    function s4() {
      return Math.floor((1 + Math.random()) * 0x10000)
        .toString(16)
        .substring(1);
    }
    return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
      s4() + '-' + s4() + s4() + s4();
  }
}