package com.fin.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.fin.model.Stock;
import com.fin.stock.StockHandler;

public class Portfolio
{

  private List<Stock> stocks;

  public Portfolio()
  {
    Stock voo = new Stock("VOO", 1.75);
    Stock vb = new Stock("VB", 4.93);
    Stock vwo = new Stock("VWO", 10.02);
    Stock vnq = new Stock("VNQ", 8.84);
    Stock corp = new Stock("CORP", 1.31);
    Stock shy = new Stock("SHY", 1.33);

    stocks = Arrays.asList(voo, vb, vwo, vnq, corp, shy);
  }

  public void execute() throws ClientProtocolException, IOException
  {
    StockHandler stockHandler = new StockHandler(stocks);
    double totalValue = stockHandler.getTotalCurrentValue();
    System.out.println(totalValue);
  }

  public static void main(String[] args) throws ClientProtocolException, IOException
  {
    new Portfolio().execute();
  }
}
