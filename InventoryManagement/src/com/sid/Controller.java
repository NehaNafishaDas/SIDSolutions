package com.sid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Controller extends Constants {
	
	static List<Item> itemsList =  new ArrayList<Item>();

	public static void main(String[] args) throws IOException {

		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			String input  = line;
			String[] str = input.split(SPACE);
			String command =str[INT_ZERO];
			OperationsImpl op = new OperationsImpl();
			switch(command) {
			case CREATE: 
				String item = str[ONE];
				double cp = Double.parseDouble(str[TWO]);
				double sp = Double.parseDouble(str[THREE]);
				op.create(item, cp, sp);
				break;
			case UPDATE_SELL: 
				item = str[ONE];
				int soldQuantity = Integer.parseInt(str[TWO]);
				op.updateSell(item, soldQuantity);
				break;
			case UPDATE_BUY : 
				item = str[ONE];
				int totalQuantity = Integer.parseInt(str[TWO]);
				op.updateBuy(item, totalQuantity);
				break;
			case UPDATE_SELL_PRICE : 
				item = str[ONE];
				double sellingPrice = Double.parseDouble(str[TWO]);
				op.updateSellPrice(item, sellingPrice);
				break;
			case DELETE : 
				item = str[ONE];
				op.delete(item);
				break;
			case REPORT : 
				op.report();
				break;
			default: 
				System.out.println(WRONG_COMMAND);
			}
		}
	}

}
