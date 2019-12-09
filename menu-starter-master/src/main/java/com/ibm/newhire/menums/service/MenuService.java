package com.ibm.newhire.menums.service;

import java.math.BigInteger;
import java.util.List;

import com.ibm.newhire.menums.model.Item;

public interface MenuService {
	public List<Item> getMenuItems();

	public String addMenuItem(Item item);

	public Item getMenuItemByName(String name);

//	Item getMenuItemById(BigInteger id);

}
