import { Component, OnInit } from '@angular/core';

import { EmployeeService } from '../../providers/employee.service';
import { SearchService } from '../../providers/search.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.sass']
})
export class ListComponent implements OnInit {
  value:string="Watch";
  employees: any[];
  search: any[];
  isLoad: boolean = false;

  constructor(public employeeService: EmployeeService, public searchService: SearchService) {
    employeeService.employeeUpdatedEvent.subscribe(
      (employees) => {
        console.log("????????????? Data Modified in List");
        this.employees = employees
      }
    );
  }

  ngOnInit() {
    this.getEmployees();
  }

  getEmployees() {
    this.employeeService.readAll()
      .subscribe(
        data => {
          this.employees = this.addImages(data);
        },
        err => this.employees = err,
        () => {
          this.isLoad = true;
        }
      );
  }

  searchEmployees(term) {
    this.searchService.searchByTerm(term)
      .subscribe(
        data => {
          this.employees = this.addImages(data);
        }, err => this.employees = err, () => {
          this.isLoad = true;
        }
      );
  }

  addImages(employees) {
    var modifiedEmployees: any[];
    employees.forEach(function(employee, i) {
      employee["imagePath"] = "../../assets/images/background/painting" + (Math.floor(Math.random() * (27 - 1)) + 1) + ".jpg";
    });
    return employees;
  }

  onClicked(value:string) {
    if(value != '') {
      this.searchEmployees(value);
    } else {
      this.getEmployees();
    }
  }

}
