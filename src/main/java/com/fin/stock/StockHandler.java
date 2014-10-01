package com.fin.stock;

import java.io.IOException;
import java.util.List;

import com.fin.model.Stock;
import com.fin.quote.QuotesDao;
import org.apache.http.client.ClientProtocolException;

public class StockHandler
{
  private List<Stock> stocks;
  private QuotesDao quotesDao;
  
  public StockHandler(List<Stock> stocks)
  {
    this.stocks = stocks;
    this.quotesDao = new QuotesDao();
  }
  
  public double getTotalCurrentValue() throws ClientProtocolException, IOException
  {
    double totalValue = 0;
    for (Stock stock : stocks)
    {
      double stockCurrentPrice = quotesDao.getCurrentPrice(stock.getSymbol());
      double stockValue = stockCurrentPrice * stock.getVolume();
      totalValue += stockValue;
    }
    
    return totalValue;
  }

}
