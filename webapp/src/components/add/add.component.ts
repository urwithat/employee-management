import { Component, OnInit, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';

import { EmployeeService } from '../../providers/employee.service';
import { LoadingService } from '../../providers/loading.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.sass']
})
export class AddComponent implements OnInit {

  constructor(public dialogRef: MdDialogRef<AddComponent>,
    @Inject(MD_DIALOG_DATA) public data: any, public employeeService: EmployeeService, 
    public loadingService: LoadingService) { }

  ngOnInit() { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  save(data) {
    if(data.id != null && data.id != "") {
      this.loadingService.loadingEvent.emit(true);
      this.employeeService.update(data.id, data.firstName, data.lastName, 
        data.gender.toLowerCase(), data.emailAddress)
        .subscribe(
          data => {
            this.employeeService.employeeUpdatedEvent.emit(data);
            this.loadingService.loadingEvent.emit(false);
            this.onNoClick();
          }
        )
    } else {
      this.loadingService.loadingEvent.emit(true);
      this.employeeService.create(data.firstName, data.lastName, 
        data.gender.toLowerCase(), data.emailAddress)
        .subscribe(
          data => {
            this.employeeService.employeeUpdatedEvent.emit(data);
            this.loadingService.loadingEvent.emit(false);
            this.onNoClick();
          }
        )
    }
  }
}
