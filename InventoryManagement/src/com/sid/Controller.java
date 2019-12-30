package com.sid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	
	static List<Item> itemsList =  new ArrayList<Item>();

	public static void main(String[] args) throws IOException {

		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			String input  = line;
			String[] str = input.split(" ");
			String command =str[0];
			OperationsImpl op = new OperationsImpl();
			switch(command) {
			case "create": 
				String item = str[1];
				double cp = Double.parseDouble(str[2]);
				double sp = Double.parseDouble(str[3]);
				op.create(item, cp, sp);
				break;
			case "updateSell": 
				item = str[1];
				int soldQuantity = Integer.parseInt(str[2]);
				op.updateSell(item, soldQuantity);
				break;
			case "updateBuy" : 
				item = str[1];
				int totalQuantity = Integer.parseInt(str[2]);
				op.updateBuy(item, totalQuantity);
				break;
			case "updateSellPrice" : 
				item = str[1];
				double sellingPrice = Double.parseDouble(str[2]);
				op.updateSellPrice(item, sellingPrice);
				break;
			case "delete" : 
				item = str[1];
				op.delete(item);
				break;
			case "report" : 
				op.report();
				break;
			default: 
				System.out.println("Wrong command");
			}
		}
	}

}
