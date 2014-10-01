package com.fin.quote;

import java.io.IOException;

import org.junit.Before;

import org.apache.http.client.ClientProtocolException;
import static org.junit.Assert.*;
import org.junit.Test;

public class QuotesDaoTest
{
  private QuotesDao underTest;

  @Before
  public void setup()
  {
    underTest = new QuotesDao();
  }

  @Test
  public void test() throws ClientProtocolException, IOException
  {
    double vwoPrice = underTest.getCurrentPrice("VWO");
    System.out.println(vwoPrice);
    assertNotNull(vwoPrice);
  }

}
