package com.raval.polymath.techprimers.springboot.stockviewer.stockservice.resource;

import com.raval.polymath.techprimers.springboot.stockviewer.stockservice.model.StockQuote;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/stock")
@Slf4j
public class StockResource {

  @Autowired
  RestTemplate template;


  @GetMapping("/{userName}")
  public Collection<StockQuote> getStockPrice(@PathVariable("userName") String userName)
      throws Exception {
    List<String> quotes = template
        .exchange("http://localhost:8300/rest/db/" + userName, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<String>>() {
            }).getBody();

    return quotes.stream().map(symbol -> getStockQuote(userName, symbol)).collect(Collectors.toList());
  }

  private StockQuote getStockQuote(String userName, String symbol){
    return StockQuote.builder()
        .userName(userName)
        .quote(symbol)
        .price(new BigDecimal(Math.random()))
        .build();
  }

}
