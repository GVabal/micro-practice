import { Component, OnInit } from '@angular/core';
import {ShopService} from '../../services/shop.service';
import {AbstractControl, FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-new-order-form',
  templateUrl: './new-order-form.component.html',
  styleUrls: ['./new-order-form.component.scss']
})
export class NewOrderFormComponent implements OnInit {

  message = '';
  isLoading = false;
  form: FormGroup;

  constructor(private shopService: ShopService,
              private fb: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      customer: ['', [
        Validators.required
      ]],
      things: this.fb.array([this.createThing()])
    });
  }

  get customer(): AbstractControl {
    return this.form.get('customer');
  }

  get things(): FormArray {
    return this.form.get('things') as FormArray;
  }

  addThing(): void {
    this.things.push(this.createThing());
  }

  removeThing(i: number): void {
    this.things.removeAt(i);
  }

  createThing(): FormGroup {
    return this.fb.group({
      name: ['', [
        Validators.required
      ]],
      qty: [null, [
        Validators.required
      ]]
    });
  }

  submit(): void {
    if (!this.isLoading) {
      this.isLoading = true;
    }
    this.shopService.takeOrder(this.form.value).subscribe(() => {
      this.isLoading = false;
      this.message = 'Submit successful!';
      this.form.reset();
    }, error => {
      this.isLoading = false;
      this.message = 'Submit failed!';
      console.log(error);
    });
  }

}
