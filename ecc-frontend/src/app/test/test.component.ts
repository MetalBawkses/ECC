import {Component, Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

// @Component({
//   selector: 'app-test',
//   templateUrl: './test.component.html',
//   styleUrls: ['./test.component.css']
// })




@Injectable()
export class TestComponent implements OnInit {

  constructor(private http: HttpClient) { }

  getData() {
    return this.http.get('localhost:8080/lofasz');
  }

  ngOnInit() {
    this.getData();
  }

}
