import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShopComponent } from './shop.component';
import { OrderTableComponent } from './components/order-table/order-table.component';
import {ShopRoutingModule} from './shop-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { NewOrderFormComponent } from './components/new-order-form/new-order-form.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    ShopComponent,
    OrderTableComponent,
    NewOrderFormComponent
  ],
  imports: [
    CommonModule,
    ShopRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ]
})
export class ShopModule { }
