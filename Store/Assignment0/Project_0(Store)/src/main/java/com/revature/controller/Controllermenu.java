package com.revature.controller;

import java.util.List;

import com.revature.Service.MenuService;
import com.revature.exception.MenuNotFoundException;
import com.revature.menu.Menu;

import io.javalin.http.Context;

public class Controllermenu {
	private static MenuService ms = new MenuService();

	public static void getAllMenu(Context ctx) {
		String item = ctx.queryParam("item");
		String available = ctx.queryParam("available");
		if (item == null && available == null) {
			 ctx.json(ms.getAllMenu());
		} else if (item != null && available == null) {
			List<Menu> menus = ms.getMenuByAvailable(available);
			ctx.json(menus);
		} else if (item == null && available != null) {
			List<Menu> menus = ms.getMenuByAvailable(available);
			ctx.json(menus);
		} else {
			List<Menu> menus = ms.getMenuByItemAndAvailable(item, available);
			ctx.json(menus);
		}

	}

	public static void createMenu(Context ctx) {
		Menu menu = ctx.bodyAsClass(Menu.class);

		if (ms.createMenu(menu) > 0) {
			ctx.status(201);
		} else {
			ctx.status(400);
			ctx.result("Menu cannot created.");
		}
	}

	public static void getMenuById(Context ctx) throws MenuNotFoundException {
		String pathParamId = ctx.pathParam("id");
		
		int Id = Integer.parseInt(pathParamId);

		Menu m;
		try {
			m = ms.getMenuById(Id);
			ctx.json(m);
			ctx.status(200);
		} catch (MenuNotFoundException e) {
			ctx.result(" menu is unable of id " + Id + ".");
			e.fillInStackTrace();
			e.printStackTrace();
		}

	}

	public static void updateMenuById(Context ctx) throws MenuNotFoundException {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Menu menu = ctx.bodyAsClass(Menu.class);
		menu.setId(id);
		if(ms.updateMenuById(menu)) {
			ctx.result("Successfully" + menu.getId());
		} else {
			ctx.status(400);
			ctx.result("Fail");
		}
	}

	public static void deleteMenuById(Context ctx) throws MenuNotFoundException {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Menu menu =ctx.bodyAsClass(Menu.class);
		menu.setId(id);
		if(ms.deleteMenuById(id)) {
			ctx.result("Successfully" + id + ".");
		} else {
			ctx.status(400);
			ctx.result("Fail");
		}
}
}