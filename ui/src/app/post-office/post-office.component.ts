import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-post-office',
  template: `
    <app-parcel-table></app-parcel-table>
  `,
  styles: [
  ]
})
export class PostOfficeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
