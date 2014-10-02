package com.fin.main;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.fin.StockUtil;
import com.fin.model.Stock;
import com.fin.stock.StockHandler;
import org.apache.http.client.ClientProtocolException;

public class Portfolio implements Runnable
{
  private StockUtil stockUtil;
  private List<Stock> stocks;

  public Portfolio() throws UnknownHostException
  {
    stockUtil = new StockUtil();
    stocks = stockUtil.getStocks();
  }

  public void run()
  {
    StockHandler stockHandler = new StockHandler(stocks);
    double totalValue = stockHandler.getTotalCurrentValue();
    System.out.println(totalValue);
  }

  public static void main(String[] args) throws ClientProtocolException, IOException
  {
    final ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
    s.scheduleAtFixedRate(new Portfolio(), 0, 1, TimeUnit.MINUTES);
  }
}
