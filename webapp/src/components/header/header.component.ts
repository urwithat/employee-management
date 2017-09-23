import { Component, OnInit } from '@angular/core';
import { MdDialog } from '@angular/material';

import { UploadComponent } from "../upload/upload.component";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.sass']
})
export class HeaderComponent implements OnInit {
  title: string = "Upload";
  subtitle: string = "Kindly select the employee xlsx file for adding or editing employees";

  constructor(public dialog: MdDialog) {}

  ngOnInit() {
  }

  openDialog(): void {
    let dialogRef = this.dialog.open(UploadComponent, {
      height: '30%',
      width: '60%',
      data: { title: this.title, subtitle: this.subtitle }
    });

    dialogRef.afterClosed().subscribe(result => {
      //console.log('The dialog was closed - ' + result);
    });
  }

}
