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
      "id": null,
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

  update(id, firstName, lastName, gender, emailAddress) {
    let data = {
      "id": id,
      "firstName": firstName,
      "lastName": lastName,
      "gender": gender,
      "emailAddress": emailAddress
    }
    return this.http.put("/api/employees/update", data)
      .map(response => response.json())
  }

  delete(id) {
    
    return this.http.get("/api/employees/delete/" + id)
      .map(response => response.json())
  }

  // id() {
  //   return "EMP" + Math.floor(Math.random() * (999999 - 111111) + 111111);
  // }
}