import { Component, OnInit } from '@angular/core';
import {Order} from '../../models/Order';
import {ShopService} from '../../services/shop.service';

@Component({
  selector: 'app-order-table',
  templateUrl: './order-table.component.html',
  styleUrls: ['./order-table.component.scss']
})
export class OrderTableComponent implements OnInit {

  orders$: Order[];

  constructor(private shopService: ShopService) {
    this.shopService.orders.subscribe(orders => this.orders$ = orders);
  }

  ngOnInit(): void {
  }

}
