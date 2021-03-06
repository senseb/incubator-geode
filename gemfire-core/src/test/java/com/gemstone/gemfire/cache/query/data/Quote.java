/*=========================================================================
 * Copyright (c) 2010-2014 Pivotal Software, Inc. All Rights Reserved.
 * This product is protected by U.S. and international copyright
 * and intellectual property laws. Pivotal products are covered by
 * one or more patents listed at http://www.pivotal.io/patents.
 *=========================================================================
 */
/*
 * Quote.java
 *
 * Created on October 4, 2005, 1:57 PM
 */

package com.gemstone.gemfire.cache.query.data;

/**
 *
 * @author  prafulla
 */
import java.util.*;
import java.io.Serializable;

public class Quote implements Serializable{
    public int cusip;
    public int quoteId;
    public String quoteIdStr;
    public String quoteType;
    public String uniqueQuoteType;
    public String dealerPortfolio;
    public int dealerCode;
    public String channelName;
    public String priceType;
    public double price;
    public int lowerQty;
    public int upperQty;
    public int ytm;    
    
    
    //later added by Prafulla
    public Set restrict = new HashSet();
    
    /** Creates a new instance of Quote */
    public Quote(int i) {
        cusip = 1000000000 - i;
        quoteId = i;
        quoteIdStr = Integer.toString(quoteId);
        dealerCode = cusip;
        String [] arr1 = {"moving", "binding", "non binding", "not to exceed", "storage", "auto transport", "mortgage"};
        quoteType = arr1[i%7];
        uniqueQuoteType = "quoteType"+Integer.toString(i);
        String [] arr2 = {"dealer1", "dealer2","dealer3","dealer4","dealer5","dealer6","dealer7"};
        dealerPortfolio = arr2[i%7];
        String [] arr3 = {"channel1", "channel2", "channel3", "channel4", "channel5", "channel6", "channel7",};
        channelName = arr3[i%7];
        String [] arr4 = {"priceType1", "priceType2","priceType3","priceType4","priceType5","priceType6","priceType7"};
        priceType = arr4[i%7];
        price = (i/10)*8;
        lowerQty = i+100;
        upperQty = i+1000;
        if((i%12) == 0){
            ytm = upperQty - lowerQty;
        } else{
            ytm = ((upperQty - lowerQty)/12)*(i%12);
        }
        
        restrict.add(new Restricted(i));
    }//end of constructor
    
    public int getCusip(){
    	return cusip;
    }
    
    public String getQuoteIdStr(){
    	return quoteIdStr;
    }
    
    public String getQuoteType(){
    	return quoteType;
    }
    
    public String getUniqueQuoteType(){
    	return uniqueQuoteType;
    }
    
    public String getDealerPortfolio(){
    	return dealerPortfolio;
    }
    
    public String getChannelName(){
    	return channelName;
    }
    
    public int getLowerQty(){
    	return lowerQty;
    }
    
    public int getUpperQty(){
    	return upperQty;
    }
    
    public double getPrice(){
    	return price;
    }
    
}//end of Quote
