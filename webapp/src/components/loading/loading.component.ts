import { Component, OnInit } from '@angular/core';

import { LoadingService } from '../../providers/loading.service';

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.sass']
})
export class LoadingComponent implements OnInit {
  show = false;

  constructor(public loadingService: LoadingService) {
    loadingService.loadingEvent.subscribe(
      (loading) => {
        this.show = loading;
      }
    );
  }

  ngOnInit() {
  }

}
