package com.revature.daos;

import java.util.List;

import com.revature.menu.Menu;

public interface MenuDao {
	

	public List<Menu> getAllMenu();

	public List<Menu> getMenuByItem(String item);

	public List<Menu> getMenuByAvailable(String available);

	public List<Menu> getMenuByItemAndAvailable(String item, String available );
	

	
	public Menu getMenuById(int id);
	
	public int createMenu(Menu menu);

	public boolean updateMenuById(Menu menu); 

	public boolean deleteMenuById(int id);

}
