import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {Order} from '../models/Order';
import {api} from '../../../environments/environment';
import {OrderNewRequest} from '../models/OrderNewRequest';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  orders: BehaviorSubject<Order[]> = new BehaviorSubject<Order[]>([]);

  constructor(private http: HttpClient) {
    this.fetchOrders().subscribe(orders => {
      this.orders.next(orders);
    });
  }

  fetchOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(api.uri.shop.getAllOrders);
  }

  takeOrder(request: OrderNewRequest): Observable<Order> {
    return this.http.post<Order>(api.uri.shop.takeOrder, request);
  }
}
