import { Component, OnInit, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';

import { EmployeeService } from '../../providers/employee.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.sass']
})
export class AddComponent implements OnInit {

  firstName: string;
  lastName: string;
  emailAddress: string;
  gender: string;  
  genders = [
    'Male',
    'Female'
  ];

  constructor(public dialogRef: MdDialogRef<AddComponent>,
    @Inject(MD_DIALOG_DATA) public data: any, public employeeService: EmployeeService) { }

  ngOnInit() { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  save() {
    this.employeeService.create(this.firstName, this.lastName, 
      this.gender.toLowerCase(), this.emailAddress)
      .subscribe(
        data => {
          this.employeeService.employeeUpdatedEvent.emit(data);
          this.onNoClick();
        }
      )
  }
}
