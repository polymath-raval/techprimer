package com.raval.polymath.techprimers.springboot.stockviewer.dbservice.resource;

import com.raval.polymath.techprimers.springboot.stockviewer.dbservice.model.Quote;
import com.raval.polymath.techprimers.springboot.stockviewer.dbservice.model.Quotes;
import com.raval.polymath.techprimers.springboot.stockviewer.dbservice.repository.QuoteRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

  @Autowired
  private QuoteRepository quoteRepository;

  @GetMapping("/{userName}")
  public List<String> getQuotes(@PathVariable("userName") String userName) {
    return quoteRepository.findByUserName(userName)
        .stream()
        .map(Quote::getQuote)
        .collect(Collectors.toList());
  }

  @PostMapping("/add")
  public List<Quote> addQuote(@RequestBody Quotes quotes){
    final String userName = quotes.getUserName();
    List<Quote> listOfQuotes = quotes.getQuotes().stream()
        .map(quote -> Quote.builder().userName(userName).quote(quote).build())
        .collect(Collectors.toList());
    return quoteRepository.save(listOfQuotes);
  }

  @PostMapping("/delete/{userName}")
  public List<Quote> addQuote(@PathVariable String userName){
    List<Quote> listOfQuotes = quoteRepository.findByUserName(userName);
    quoteRepository.delete(listOfQuotes);
    return listOfQuotes;
  }

}
