package com.raval.polymath.techprimers.springboot.stockviewer.dbservice.repository;


import com.raval.polymath.techprimers.springboot.stockviewer.dbservice.model.Quote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {

  public List<Quote> findByUserName(String username);
}
