import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {Parcel} from '../models/Parcel';
import {HttpClient} from '@angular/common/http';
import {api} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PostOfficeService {

  parcels: BehaviorSubject<Parcel[]> = new BehaviorSubject<Parcel[]>([]);

  constructor(private http: HttpClient) {
    this.fetchParcels().subscribe(parcels => {
      this.parcels.next(parcels);
    });
  }

  fetchParcels(): Observable<Parcel[]> {
    return this.http.get<Parcel[]>(api.uri.postOffice.getAllParcels);
  }
}

