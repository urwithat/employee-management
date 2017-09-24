import { Component, OnInit, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';

import { EmployeeService } from '../../providers/employee.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.sass']
})
export class AddComponent implements OnInit {

  constructor(public dialogRef: MdDialogRef<AddComponent>,
    @Inject(MD_DIALOG_DATA) public data: any, public employeeService: EmployeeService) { }

  ngOnInit() { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  save(data) {

    console.log("============== Id for save :: " + data.id);

    if(data.id != null && data.id != "") {
      console.log("=============>>>>>>>>>>>>>>>> Save - Update");
      this.employeeService.update(data.id, data.firstName, data.lastName, 
        data.gender.toLowerCase(), data.emailAddress)
        .subscribe(
          data => {
            this.employeeService.employeeUpdatedEvent.emit(data);
            this.onNoClick();
          }
        )
    } else {
      console.log("=============>>>>>>>>>>>>>>>> Save - Create");
      this.employeeService.create(data.firstName, data.lastName, 
        data.gender.toLowerCase(), data.emailAddress)
        .subscribe(
          data => {
            this.employeeService.employeeUpdatedEvent.emit(data);
            this.onNoClick();
          }
        )
    }
  }
}
