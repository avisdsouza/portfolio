package com.fin.model;

public class Stock
{
  private String symbol;
  private double volume;
  private double price;

  public Stock(String symbol, double volume)
  {
    this.symbol = symbol;
    this.volume = volume;
  }

  public String getSymbol()
  {
    return symbol;
  }

  public void setSymbol(String symbol)
  {
    this.symbol = symbol;
  }

  public double getVolume()
  {
    return volume;
  }

  public void setVolume(double volume)
  {
    this.volume = volume;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

}
