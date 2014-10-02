package com.fin;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import com.fin.model.Stock;
import com.fin.dao.MongoDao;

public class StockUtil
{
  private MongoDao mongoDao;

  public StockUtil() throws UnknownHostException
  {
    mongoDao = new MongoDao();
  }

  private void loadStocks()
  {
    Stock voo = new Stock("VOO", 1.75);
    Stock vb = new Stock("VB", 4.93);
    Stock vwo = new Stock("VWO", 10.02);
    Stock vnq = new Stock("VNQ", 8.84);
    Stock corp = new Stock("CORP", 1.31);
    Stock shy = new Stock("SHY", 1.33);

    List<Stock> stocks = Arrays.asList(voo, vb, vwo, vnq, corp, shy);
    mongoDao.addStocks(stocks);

  }

  public List<Stock> getStocks()
  {
    if (mongoDao.isStocksEmpty())
    {
      loadStocks();
    }
    return mongoDao.getStocks();
  }

}
