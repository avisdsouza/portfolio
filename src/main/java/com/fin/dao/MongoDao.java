package com.fin.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fin.model.Stock;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDao
{
  private DBCollection stocksCollection;
  private DBCollection stockValueCollection;

  public MongoDao() throws UnknownHostException
  {
    final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost"));
    final DB db = mongoClient.getDB("portfolio");
    stocksCollection = db.getCollection("stocks");
    stockValueCollection = db.getCollection("stocks_value");
  }

  public List<Stock> getStocks()
  {
    List<Stock> stocks = new ArrayList<>();
    try (DBCursor cursor = stocksCollection.find())
    {
      for (DBObject stockDbObject : cursor)
      {
        String symbol = (String) stockDbObject.get("symbol");
        Double volume = (Double) stockDbObject.get("volume");
        Stock stock = new Stock(symbol, volume);
        stocks.add(stock);
      }
    }
    return stocks;
  }

  public void addStocks(List<Stock> stocks)
  {
    for (Stock stock : stocks)
    {
      DBObject stockObj = new BasicDBObject("symbol", stock.getSymbol()).append("volume", stock.getVolume());
      stocksCollection.insert(stockObj);
    }
  }

  public void saveCurrentSnapshot(double cuurentPrice)
  {
    DBObject stocksValueObj = new BasicDBObject("dateTime", new Date()).append("value", cuurentPrice);
    stockValueCollection.insert(stocksValueObj);
  }

  public boolean isStocksEmpty()
  {
    if (stocksCollection.count() == 0)
    {
      return true;
    }
    return false;
  }

}
