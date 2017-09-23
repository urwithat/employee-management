import { Injectable, Inject } from '@angular/core';
import { Http } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class ExcelService {
  progress : any;
  progressObserver : any;

  constructor(public http: Http) { }
  
  uploadfile (url: string, params: string[], files: File[]) {    
    let formData: FormData = new FormData();
    formData.append("file",files[0]);
    return this.http.post(url, formData)
      .map(response => response.json())
  }

  download() {
    return this.http.get("/download")
      .map(response => response.json())
  }
}