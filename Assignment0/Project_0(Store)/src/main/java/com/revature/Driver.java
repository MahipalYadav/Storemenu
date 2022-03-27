package com.revature;
import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controller.Controllermenu;


import io.javalin.Javalin;




public class Driver {
	
	
	public static void main(String[] args) {
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();

			config.defaultContentType = "application/json";
		});
		app.start(8080);
		
		
	
		
		app.routes(() -> {
			path("menu", () -> {
				get(Controllermenu::getAllMenu);
				post(Controllermenu::createMenu);

				path("{id}", () -> {
					delete(Controllermenu::deleteMenuById);
					put(Controllermenu::updateMenuById);
					get(Controllermenu::getMenuById);

				});
			});
		});

	}

}
