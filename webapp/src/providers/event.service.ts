import { Injectable, Inject } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class EmployeeService {
  constructor(public http: Http) {
  }

  create() {
    //console.log('env variables', this.envVariables);
    return this.http.get("/api/employees/create")
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
}