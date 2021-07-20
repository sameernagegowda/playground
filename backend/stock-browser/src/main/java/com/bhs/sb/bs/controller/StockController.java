package com.bhs.sb.bs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bhs.sb.bs.api.StockApi;
import com.bhs.sb.bs.model.Stock;

@Controller
@CrossOrigin
public class StockController implements StockApi {

	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public ResponseEntity<List<Stock>> getAllStocks() {
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(createStock(1, "Infosys", "INFY"));
		stocks.add(createStock(1, "Tata Consultancy Services", "TCS"));
		return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
	}

	private Stock createStock(int id, String name, String code) {
		Stock stock = new Stock();
		stock.setId(1);
		stock.setName(name);
		stock.setCode(code);
		return stock;
	}
}
