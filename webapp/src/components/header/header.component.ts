import { Component, OnInit } from '@angular/core';
import { MdDialog } from '@angular/material';

import { UploadComponent } from "../upload/upload.component";
import { AddComponent } from "../add/add.component";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.sass']
})
export class HeaderComponent implements OnInit {
  uploadTitle: string = "Upload Employee";
  uploadSubtitle: string = "Kindly select the employee xlsx file for adding or editing employees";

  addTitle: string = "New Employee";
  addSubtitle: string = "Kindly enter the employee details";

  constructor(public dialog: MdDialog) {}

  ngOnInit() {
  }

  openUploadDialog(): void {
    let dialogRef = this.dialog.open(UploadComponent, {
      height: '30%',
      width: '60%',
      data: { title: this.uploadTitle, subtitle: this.uploadSubtitle }
    });
    dialogRef.afterClosed().subscribe();
  }

  openAddDialog(): void {
    let dialogRef = this.dialog.open(AddComponent, {
      height: '80%',
      width: '60%',
      data: { title: this.addTitle, subtitle: this.addSubtitle, 
        employee: { id: "", firstName: "", lastName: "", emailAddress: "", gender: "" } }
    });
    dialogRef.afterClosed().subscribe(result => { });
  }

}
