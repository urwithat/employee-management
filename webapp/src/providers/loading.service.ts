import { Injectable, Inject, EventEmitter } from '@angular/core';
import 'rxjs/add/operator/map';

@Injectable()
export class LoadingService {
  
  loadingEvent: EventEmitter<any> = new EventEmitter();
  statusEvent: EventEmitter<any> = new EventEmitter();

  constructor() {
  }

}