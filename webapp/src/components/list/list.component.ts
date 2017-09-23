import { Component, OnInit } from '@angular/core';
import { MdDialog } from '@angular/material';

import { EmployeeService } from '../../providers/employee.service';
import { SearchService } from '../../providers/search.service';
import { AddComponent } from "../add/add.component";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.sass']
})
export class ListComponent implements OnInit {
  value:string="Watch";
  employees: any[];
  search: any[];

  constructor(public employeeService: EmployeeService, public searchService: SearchService, public dialog: MdDialog) {
    employeeService.employeeUpdatedEvent.subscribe(
      (employees) => {
        this.employees = this.addImages(employees);
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
        err => this.employees = err, () => { }
      );
  }

  searchEmployees(term) {
    this.searchService.searchByTerm(term)
      .subscribe(
        data => {
          this.employees = this.addImages(data);
        }, err => this.employees = err, () => { }
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

  updateTitle: string = "Update Employee";
  updateSubtitle: string = "Kindly update the employee details";

  openUpdateDialog(id): void {
    this.searchService.searchById(id)
      .subscribe(
        data => {
          let dialogRef = this.dialog.open(AddComponent, {
            height: '80%',
            width: '60%',
            data: { title: this.updateTitle, subtitle: this.updateSubtitle, employee: data[0] }
          });
          dialogRef.afterClosed().subscribe(result => { });
        }, err => this.employees = err, () => { }
      );
  }

  deleteEmployee(id): void {
    this.employeeService.delete(id)
    .subscribe(
      data => {
        this.employees = this.addImages(data);
      },
      err => this.employees = err, () => { }
    );
  }

}
