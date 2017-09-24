import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from '@angular/material';
import { MdButtonModule, MdCardModule, MdMenuModule, MdToolbarModule, MdIconModule, 
  MdListModule, MdGridListModule, MdCoreModule, MdExpansionPanel } from '@angular/material';
import 'hammerjs';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ReactiveFormsModule, FormsModule, FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

import { AppRoutingModule } from  './app.routes.module';

import { AppComponent } from './app.component';
import { HeaderComponent } from '../components/header/header.component';
import { CardComponent } from '../components/card/card.component';
import { ListComponent } from '../components/list/list.component';
import { SearchComponent } from '../components/search/search.component';
import { UploadComponent } from '../components/upload/upload.component';
import { InputFileComponent } from '../components/input-file/input-file.component';
import { AddComponent } from '../components/add/add.component';
import { LoadingComponent } from '../components/loading/loading.component';
import { StatusComponent } from '../components/status/status.component';

import { EmployeeService } from '../providers/employee.service';
import { ExcelService } from '../providers/excel.service';
import { SearchService } from '../providers/search.service';
import { LoadingService } from '../providers/loading.service';

@NgModule({
  declarations: [ 
    AppComponent,
    CardComponent,
    ListComponent,
    SearchComponent,
    HeaderComponent,
    UploadComponent,
    InputFileComponent,
    AddComponent,
    LoadingComponent,
    StatusComponent
  ], exports: [
    MdButtonModule,
    MdCardModule,
    MdGridListModule,
    MdIconModule,
    MdListModule,
    MdMenuModule,
    MdToolbarModule,
    MdExpansionPanel
  ], imports: [
    AppRoutingModule,
    BrowserModule,
    HttpModule,
    BrowserAnimationsModule,
    MaterialModule,
    FlexLayoutModule,
    FormsModule
  ], providers: [
    EmployeeService,
    ExcelService,
    SearchService,
    LoadingService
  ], entryComponents: [
    UploadComponent,
    AddComponent,
    StatusComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
