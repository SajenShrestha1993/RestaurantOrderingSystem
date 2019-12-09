package com.ibm.newhire.menums.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mockito.Mockito;

import com.ibm.newhire.menums.model.Item;

import org.junit.Test;

public class MenuServiceTest {

	@Test
	public void testGetMenuItems() {
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("1", "Something", 45.42),
				new Item("2", "Something else", 33), new Item("3", "Something else again", 55)));
		MenuService menuService = Mockito.mock(MenuService.class);
		when(menuService.getMenuItems()).thenReturn(items);
		
		List<Item> returnedItems = menuService.getMenuItems();
		assertNotNull("Items should not be null", returnedItems);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testGetMenuItems_noitems() {
		MenuService menuService = Mockito.mock(MenuService.class);
		List emptyList = new ArrayList();
		when(menuService.getMenuItems()).thenReturn(emptyList);
		List<Item> results = menuService.getMenuItems();
		assertEquals(results , emptyList);
		verify(menuService).getMenuItems();
		
	}

//	@Test
//	public void testGetMenuItemById() {
//		Item itemToBeReturned = new Item("1", "Something", 45.42);
//		MenuService menuService = Mockito.mock(MenuService.class);
//		BigInteger expectedId = itemToBeReturned.getId();
//		when(menuService.getMenuItemById(expectedId)).thenReturn(itemToBeReturned);
//		Item returnedItem = menuService.getMenuItemById(expectedId);
//		assertEquals(itemToBeReturned, returnedItem);
//	}

//	@Test
//	public void testGetMenuItemById_invalidId() {
//		Item itemToBeReturned = new Item("1", "Something", 45.42);
//		MenuService menuService = Mockito.mock(MenuService.class);
//		BigInteger expectedId = BigInteger.ONE;
//		when(menuService.getMenuItemById(expectedId)).thenReturn(itemToBeReturned);
//		assertNotEquals(itemToBeReturned.getId(), expectedId);
//	}

	@Test
	public void testAddMenuItem() {
		Item itemToAdd = new Item("4", "SOMETHING ELSE AGAIN", 56.54);
		MenuService menuService = Mockito.mock(MenuService.class);
		when(menuService.addMenuItem(itemToAdd)).thenReturn("Successful");
		String response = menuService.addMenuItem(itemToAdd);
		assertNotNull("Return message should not be null", response);
	}

	@Test
	public void testGetMenuItemByName_validName() {
		Item itemToBeReturned = new Item("1", "Something", 45.42);
		MenuService menuService = Mockito.mock(MenuService.class);
		when(menuService.getMenuItemByName("1")).thenReturn(itemToBeReturned);
		Item returnedItem = menuService.getMenuItemByName("1");
		assertEquals(itemToBeReturned, returnedItem);
	}
	@Test
	public void testGetMenuItemByName_invalidName() {
		Item itemToBeReturned = new Item("1", "Something", 45.42);
		MenuService menuService = Mockito.mock(MenuService.class);
		when(menuService.getMenuItemByName("Spoopy")).thenReturn(null);

		Item result = menuService.getMenuItemByName("Spoopy");
		
		assertNotEquals(itemToBeReturned,result);
	}

}
