package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.menu.Menu;
import com.revature.util.Connectionmenu;

public class Menupostgres implements MenuDao {


	@Override
	public Menu getMenuById(int id) {
		String sql = "select * from menu where id = ?";
		Menu menu = null;

		try (Connection c = Connectionmenu.getConnection()) {

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setItem(rs.getString("item"));
				menu.setItemname(rs.getString("itemname"));
				menu.setQuantity(rs.getInt("Quantity"));
				menu.setAmount(rs.getDouble("Amount"));
				menu.setAvailable(rs.getString("available"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public List<Menu> getAllMenu() {
		String sql = "select * from menu";
		List<Menu> menus = new ArrayList<>();

		// try with resources.
		try (Connection c = Connectionmenu.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setItem(rs.getString("item"));
				menu.setItemname(rs.getString("itemname"));
				menu.setQuantity(rs.getInt("Quantity"));
				menu.setAmount(rs.getDouble("Amount"));
				menu.setAvailable(rs.getString("available"));
				menus.add(menu);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;

	}

	@Override
	public boolean updateMenuById(Menu menu) {
		
		String sql = "Update menu set item?,itemname?,quantity?,amount?,available? returning * ";
		

		try (Connection c = Connectionmenu.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, menu.getItem());
			ps.setString(2, menu.getItemname());
			ps.setInt(3, menu.getQuantity());
			ps.setDouble(4, menu.getAmount());
			ps.setString(5, menu.getAvailable());
			 
			

			 ResultSet rs = ps.executeQuery();
			 
			 if(rs.next())
					return true;

			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
		

	}

	@Override
	public boolean deleteMenuById(int id) {
		String sql = "Delete from menu where id ? returning id";
		
		
		try (
				Connection c = Connectionmenu.getConnection()) {
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, id); 
		ResultSet rs = ps.executeQuery(); 
		
		if(rs.next()) {
			return true;
		}
		
	} catch( SQLException e)
	{

		e.printStackTrace();
	}

	return false;

	}

	@Override
	public List<Menu> getMenuByItem(String item) {
		String sql = "select * from menu where item ?";
		List<Menu> menus = new ArrayList<>();

		// try with resources.
		try (Connection c = Connectionmenu.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, item);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setItem(rs.getString("item"));
				menu.setItemname(rs.getString("itemname"));
				menu.setQuantity(rs.getInt("Quantity"));
				menu.setAmount(rs.getDouble("Amount"));
				menu.setAvailable(rs.getString("available"));
				
				
				menus.add(menu);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}

	@Override
	public List<Menu> getMenuByAvailable(String available) {
		String sql = "select * from menu where available ?";
		List<Menu> menus = new ArrayList<>();

		// try with resources.
		try (Connection c = Connectionmenu.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, available);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				 Menu menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setItem(rs.getString("item"));
				menu.setItemname(rs.getString("itemname"));
				menu.setQuantity(rs.getInt("Quantity"));
				menu.setAmount(rs.getDouble("Amount"));
				menu.setAvailable(rs.getString("available"));
				menus.add(menu);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}


	@Override
	public int createMenu(Menu menu) {
		String sql = "insert into menu (item,itemname,quantity,amount,available) values (?,?,?,?,?)";
		int generatedId = -1;

		try (Connection c = Connectionmenu.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, menu.getItem());
			ps.setString(2, menu.getItemname());
			ps.setInt(3, menu.getQuantity());
			ps.setDouble(4, menu.getAmount());
			ps.setString(5, menu.getAvailable());

			generatedId = ps.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return generatedId;

	}
	@Override
	public List<Menu> getMenuByItemAndAvailable(String item, String available) {
		String sql = "select * from menu where item ? and availavle ?";
		List<Menu> menus = new ArrayList<>();
		
		try (Connection c = Connectionmenu.getConnection()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1,item);
			ps.setString(2, available);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setItem(rs.getString("item"));
				menu.setItemname(rs.getString("itemname"));
				menu.setQuantity(rs.getInt("Quantity"));
				menu.setAmount(rs.getDouble("Amount"));
				menu.setAvailable(rs.getString("available"));
				menus.add(menu);

			}
		} catch (SQLException e) {
			e.fillInStackTrace();
			e.printStackTrace();
		}
		return menus;
	}

	

}
