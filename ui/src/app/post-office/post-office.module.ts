import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostOfficeComponent } from './post-office.component';
import { ParcelTableComponent } from './components/parcel-table/parcel-table.component';
import {PostOfficeRoutingModule} from './post-office-routing.module';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    PostOfficeComponent,
    ParcelTableComponent
  ],
  imports: [
    CommonModule,
    PostOfficeRoutingModule,
    HttpClientModule
  ]
})
export class PostOfficeModule { }
