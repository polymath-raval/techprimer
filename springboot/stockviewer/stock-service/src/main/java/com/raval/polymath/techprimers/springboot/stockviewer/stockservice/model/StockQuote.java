package com.raval.polymath.techprimers.springboot.stockviewer.stockservice.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockQuote {

  private String userName;
  private String quote;
  private BigDecimal price;
}
