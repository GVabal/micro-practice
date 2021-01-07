import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {ShopComponent} from './shop.component';
import {OrderTableComponent} from './components/order-table/order-table.component';
import {ShopService} from './services/shop.service';

const routes: Routes = [
  { path: '', component: ShopComponent,
    children: [
      { path: '', component: OrderTableComponent}
    ] },
  { path: '**', redirectTo: '' }
];

@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ],
  providers: [
    ShopService
  ]
})
export class ShopRoutingModule { }
