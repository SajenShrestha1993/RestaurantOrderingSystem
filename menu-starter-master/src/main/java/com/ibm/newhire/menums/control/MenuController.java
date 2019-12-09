package com.ibm.newhire.menums.control;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.newhire.menums.model.Item;
import com.ibm.newhire.menums.service.MenuService;

@RestController
public class MenuController {
	@Autowired
	private MenuService menuService;

	public MenuController() {

	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/menu")
	public ResponseEntity<?> getMenuItems() {
		List<Item> responseItems = this.menuService.getMenuItems();
		if (!responseItems.isEmpty()) {
			return new ResponseEntity<List>(responseItems, HttpStatus.OK);
		}
		return new ResponseEntity<>("No menu items to show", HttpStatus.BAD_REQUEST);
	}

//	@GetMapping("/menu/{id}")
//	public ResponseEntity<?> retrieveItemById(@PathVariable BigInteger id) {
//		Item responseItem = this.menuService.getMenuItemById(id);
//		return new ResponseEntity<Item>(responseItem, HttpStatus.OK);
//	}

	@GetMapping("/menu/{name}")
	public ResponseEntity<?> retrieveMenuItemByName(@PathVariable String name) {
		Item responseItem = this.menuService.getMenuItemByName(name);
		return new ResponseEntity<Item>(responseItem, HttpStatus.OK);
	}

	@PostMapping("/menu")
	public ResponseEntity<?> addMenuItem(@RequestBody Item item) {
		String response = this.menuService.addMenuItem(item);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
