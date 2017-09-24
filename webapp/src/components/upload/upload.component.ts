import { Component, OnInit, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';

import { EmployeeService } from '../../providers/employee.service';
import { ExcelService } from '../../providers/excel.service';
import { LoadingService } from '../../providers/loading.service';

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
    public excelService: ExcelService, public loadingService: LoadingService) { }

  ngOnInit() { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onFileSelect(event) {
    this.fileList = event;
  }

  upload() {
    this.loadingService.loadingEvent.emit(true);
    this.uploadRef = this.excelService.uploadfile('/api/upload', [], this.fileList)
      .subscribe(
        data => {
          this.employeeService.employeeUpdatedEvent.emit(data);
          this.loadingService.loadingEvent.emit(false);
          this.onNoClick();
        },
        progress => {
          this.onNoClick();
        }
      )
  }

}
