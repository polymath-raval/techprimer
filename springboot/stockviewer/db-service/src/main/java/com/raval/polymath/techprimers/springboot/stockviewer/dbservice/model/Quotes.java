package com.raval.polymath.techprimers.springboot.stockviewer.dbservice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonDeserialize
public class Quotes {
  private  String userName;
  private List<String> quotes;
}
