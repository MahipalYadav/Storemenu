package com.revature.menu;

import java.util.Objects;

public class Menu {

	private int id;
	private String item;
	private String itemname;
	private int quantity;
	private double amount;
	private String available;

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, available, id, item, itemname, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(available, other.available) && id == other.id && Objects.equals(item, other.item)
				&& Objects.equals(itemname, other.itemname) && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", item=" + item + ", itemname=" + itemname + ", quantity=" + quantity + ", amount="
				+ amount + ", available=" + available + "]";
	}


	

}
