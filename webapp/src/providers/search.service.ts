import { Injectable, Inject } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class SearchService {
  constructor(public http: Http) { }

  search() {
    return this.http.get("/api/search")
      .map(response => response.json())
  }

  searchByTerm(term) {
    return this.http.get("/api/search/term/" + term)
      .map(response => response.json())
  }

}