import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {PostOfficeComponent} from './post-office.component';
import {ParcelTableComponent} from './components/parcel-table/parcel-table.component';
import {PostOfficeService} from './services/post-office.service';

const routes: Routes = [
  { path: '', component: PostOfficeComponent,
    children: [
      { path: '', component: ParcelTableComponent }
    ] },
  { path: '**', redirectTo: '' }
];

@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
  ],
  exports: [
    RouterModule
  ],
  providers: [
    PostOfficeService
  ]
})
export class PostOfficeRoutingModule { }

