package com.sid;

public interface Operations {
	 public void create(String itemName, double costPrice, double sellingPrice);
	 
	 public void delete(String itemName);
	 
	 public void updateBuy(String itemName, int quantity);
	 
	 public void updateSell(String itemName, int quantity);
	 
	 public void report();
	 
	 public void updateSellPrice(String itemName, double sellingPrice);
	 
}
