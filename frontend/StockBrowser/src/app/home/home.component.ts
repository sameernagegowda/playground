import { Component, OnInit } from '@angular/core';
import { Stock, StockService } from '../gen';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  stocks: Stock[];

  constructor(public stockService: StockService) { }

  ngOnInit(): void {
    this.stockService.getAllStocks().subscribe(result => {
      this.stocks = [...result];
    })
  }
}
