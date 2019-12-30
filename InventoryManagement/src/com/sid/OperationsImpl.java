package com.sid;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OperationsImpl extends Constants implements Operations{

	@Override
	public void create(String itemName, double costPrice, double sellingPrice) {
		Item item = new Item();
		item.setName(itemName);
		item.setCostPrice(costPrice);
		item.setSellingPrice(sellingPrice);
		item.setTotalQuantity(INT_ZERO);
		item.setSoldQuantity(INT_ZERO);
		item.setAvailableQuantity(INT_ZERO);
		item.setValue(DOUBLE_ZERO);
		item.setProfit(DOUBLE_ZERO);
		item.setDeleted(FALSE);
		Controller.itemsList.add(item);
		
	}

	@Override
	public void delete(String itemName) {
		
		for (Item item : Controller.itemsList) {
			if(item.getName().equalsIgnoreCase(itemName)) {
				item.setDeleted(TRUE);
				break;
			}
		}
		
	}

	@Override
	public void updateBuy(String itemName, int quantity) {
		
		for (Item item : Controller.itemsList) {
			if(item.getName().equalsIgnoreCase(itemName)) {
				item.setTotalQuantity(item.getTotalQuantity()+quantity);
				item.setAvailableQuantity(item.getAvailableQuantity()+quantity);
				item.setValue(item.getCostPrice() * item.getAvailableQuantity());
				break;
			}
		}
		
	}

	@Override
	public void updateSell(String itemName, int quantity) {	
		
		for (Item item : Controller.itemsList) {
			if(item.getName().equalsIgnoreCase(itemName)) {

				item.setProfit(item.getProfit()+(item.getSellingPrice()-item.getCostPrice())*quantity);
				item.setSoldQuantity(item.getSoldQuantity()+quantity);
				item.setAvailableQuantity(item.getTotalQuantity()-item.getSoldQuantity());
				item.setValue(item.getCostPrice() * item.getAvailableQuantity());
				break;
			}
		}
		
	}

	@Override
	public void report() {
		double totalValue = DOUBLE_ZERO;
		double totalProfit = DOUBLE_ZERO;
		DecimalFormat df = new DecimalFormat(DECIMAL_FORMATTER);
		List<Item> removeItem = new ArrayList<Item>();
		System.out.printf(TITLE);
		System.out.println();
	    System.out.printf(PATTERN, NAME_STR, BUY_STR, SOLD_STR, QTY_STR, VALUE_STR);
	    System.out.println();
	    System.out.printf(PATTERN, NINE_DASH, NINE_DASH, SEVEN_DASH, TWELVE_DASH, SEVEN_DASH);
	    System.out.println();
		for(Item item : Controller.itemsList) {
			if(!item.isDeleted()) {
				System.out.printf(PATTERN, item.getName(),df.format(item.getCostPrice()),df.format(item.getSellingPrice()),item.getAvailableQuantity(),df.format(item.getValue()));
				System.out.println();
				totalValue += item.getValue();
				totalProfit+=item.getProfit();
				item.setTotalQuantity(item.getAvailableQuantity());
				item.setSoldQuantity(INT_ZERO);
				item.setProfit(DOUBLE_ZERO);
			} else {
				totalProfit-=item.getValue();
				removeItem.add(item);
			}
		}
		Controller.itemsList.removeAll(removeItem);
		System.out.println(VALUE_MSG+ df.format(totalValue));
		System.out.println(PROFIT_MSG+ df.format(totalProfit));
		
		
	}
	
	@Override
	public void updateSellPrice(String itemName, double sellingPrice) {
		
		for (Item item : Controller.itemsList) {
			if(item.getName().equalsIgnoreCase(itemName)) {
				item.setSellingPrice(sellingPrice);
				break;
			}
		}
		
	}
	
}
