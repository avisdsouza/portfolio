package com.fin.quote;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class QuotesDao
{

  private static final String QUOTE_URL = "http://finance.yahoo.com/d/quotes.json?s=%s&f=l1";

  public double getCurrentPrice(String symbol) throws ClientProtocolException, IOException
  {
    String url = String.format(QUOTE_URL, symbol);
    String stockPrice =
        Request.Get(url).connectTimeout(10000).socketTimeout(10000).execute().returnContent().asString();

    return Double.valueOf(stockPrice);
  }

}
