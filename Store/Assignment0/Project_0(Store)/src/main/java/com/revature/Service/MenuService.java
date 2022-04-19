package com.revature.Service;

import java.util.List;

import com.revature.daos.MenuDao;
import com.revature.daos.Menupostgres;
import com.revature.exception.MenuNotFoundException;
import com.revature.menu.Menu;

public class MenuService {
	private MenuDao MDao;
	
	public MenuService() {
		MDao  = new Menupostgres();
		
	}

	public List<Menu> getAllMenu() {

		return MDao.getAllMenu();

	}

	public List<Menu> getMenuByAvailable(String available) {
		return MDao.getMenuByAvailable(available);

	}

	public List<Menu> getMenuByItem(String item) {
		return MDao.getMenuByItem(item);

	}

	public List<Menu> getMenuByItemAndAvailable(String item, String available) {
		return MDao.getMenuByItemAndAvailable(item, available);

	}

	public int createMenu(Menu menu) {
		return MDao.createMenu(menu);
	}

	public boolean deleteMenuById(int id) throws MenuNotFoundException {
		boolean mDelete = MDao.deleteMenuById(id);

		if (!mDelete) {

			throw new MenuNotFoundException();
		}
		return mDelete;
	}

	public boolean updateMenuById(Menu menu) throws MenuNotFoundException {
		boolean mUpdate = MDao.updateMenuById(menu);

		if (!mUpdate) {

			throw new MenuNotFoundException();
		}
		return mUpdate;

	}

	public Menu getMenuById(int id) throws MenuNotFoundException {
		Menu menu = MDao.getMenuById(id);

		if (menu == null) {
			throw new MenuNotFoundException();
		}

		return menu;
	}
}
