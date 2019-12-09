package com.ibm.newhire.menums.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.newhire.menums.model.Item;
import com.ibm.newhire.menums.repo.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuRepository menuRepository;

	public MenuServiceImpl() {

	}

	@Override
	public List<Item> getMenuItems() {
		List<Item> menuItems = null;
		menuItems = (List<Item>) this.menuRepository.findAll();
		return menuItems;
	}

//	@Override
//	public Item getMenuItemById(BigInteger id) {
//		Item item = null;
//		item = this.menuRepository.findById(id);
//		return item;
//	}

	@Override
	public Item getMenuItemByName(String name) {
		Item item = null;
		item = this.menuRepository.findByName(name);
		return item;
	}

	@Override
	public String addMenuItem(Item item) {
		this.menuRepository.save(item);
		return "Menu Item Added.";
	}

}
