import { Component } from '@angular/core';
import { MdSnackBar } from '@angular/material';

import { LoadingService } from '../providers/loading.service';

import { StatusComponent } from "../components/status/status.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {

  constructor(public snackBar: MdSnackBar, public loadingService: LoadingService) {
    loadingService.statusEvent.subscribe(
      (status) => {
        this.snackBar.openFromComponent(StatusComponent, {
          duration: 5000,
          data: { message : status}
        });
      }
    );
  }

  ngOnInit() { }

} 