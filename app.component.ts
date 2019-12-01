import { Component } from '@angular/core';
import { Customer } from './customer';
import {Router} from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  customer= new Customer;
  title = 'EatallinpizzA';
  constructor(private router: Router){}
  onClick(){
    this.router.navigate(['login']);
  }
}
