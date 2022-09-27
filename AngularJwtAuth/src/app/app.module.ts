import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DataService } from './services/data.service';
import {MatNativeDateModule} from '@angular/material/core';
import { FormUploadComponent } from './upload/form-upload/form-upload.component';
import { UploadFileService } from './services/upload-file.service';

import { PokerComponent } from './poker/poker.component';





@NgModule({
  declarations: [
    AppComponent,
    FormUploadComponent,
    PokerComponent

       
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule
    
    
  ],
  providers: [DataService,UploadFileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
