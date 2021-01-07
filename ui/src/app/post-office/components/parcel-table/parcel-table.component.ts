import { Component, OnInit } from '@angular/core';
import {PostOfficeService} from '../../services/post-office.service';
import {Parcel} from '../../models/Parcel';

@Component({
  selector: 'app-parcel-table',
  templateUrl: './parcel-table.component.html',
  styleUrls: ['./parcel-table.component.scss']
})
export class ParcelTableComponent implements OnInit {

  parcels$: Parcel[];

  constructor(private postOfficeService: PostOfficeService) {
    this.postOfficeService.parcels.subscribe(parcels => this.parcels$ = parcels);
  }

  ngOnInit(): void {
  }

}
