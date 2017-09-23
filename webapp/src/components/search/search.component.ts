import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.sass']
})
export class SearchComponent implements OnInit {
  @Input() result:string = "";
  @Output() clicked=new EventEmitter<string>();

  constructor() { }

  ngOnInit() { }

  onClick(searchTerm:string){
    this.clicked.emit(searchTerm);  
  }  
} 