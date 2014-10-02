package com.fin.stock;

import java.util.List;

import com.fin.model.Stock;
import com.fin.dao.QuotesDao;

public class StockHandler
{
  private List<Stock> stocks;
  private QuotesDao quotesDao;

  public StockHandler(List<Stock> stocks)
  {
    this.stocks = stocks;
    this.quotesDao = new QuotesDao();
  }

  public double getTotalCurrentValue()
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
