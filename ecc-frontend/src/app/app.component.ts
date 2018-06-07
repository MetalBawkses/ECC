import { Component } from '@angular/core';
import { TestComponent} from './test/test.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  // template: `teveszar`
})
export class AppComponent {
  public lofaszData;

  constructor(private testFos: TestComponent) {

  }

  // ngOnInit() {
  //   this.getValami();
  // }

  getValami() {
    this.testFos.getData().subscribe(
      data => {this.lofaszData = data; },
      error1 => console.error('lofaszError'),
      () => console.log('3. sor')
    );
  }


}
