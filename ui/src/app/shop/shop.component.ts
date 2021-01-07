import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shop',
  template: `
    <app-order-table></app-order-table>
    <hr>
    <app-new-order-form></app-new-order-form>
  `,
  styles: [
  ]
})
export class ShopComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
