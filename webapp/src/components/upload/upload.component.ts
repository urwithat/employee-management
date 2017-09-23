import { Component, OnInit, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';

import { EmployeeService } from '../../providers/employee.service';
import { ExcelService } from '../../providers/excel.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.sass']
})
export class UploadComponent implements OnInit {
  fileList : any;
  uploadRef: any;

  constructor(public dialogRef: MdDialogRef<UploadComponent>,
    @Inject(MD_DIALOG_DATA) public data: any, public employeeService: EmployeeService, 
    public excelService: ExcelService) { }

  ngOnInit() { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onFileSelect(event) {
    this.fileList = event;
  }

  upload() {
    this.uploadRef = this.excelService.uploadfile('/api/upload', [], this.fileList)
      .subscribe(
        data => {
          this.employeeService.employeeUpdatedEvent.emit(data);
          this.onNoClick();
        },
        progress => {
          this.onNoClick();
        }
      )
  }

}
