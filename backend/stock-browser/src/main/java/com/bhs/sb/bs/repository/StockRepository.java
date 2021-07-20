package com.bhs.sb.bs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhs.sb.bs.dao.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
