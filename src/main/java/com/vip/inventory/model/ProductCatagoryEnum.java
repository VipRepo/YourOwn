package com.vip.inventory.model;

public enum ProductCatagoryEnum {

	BOOKS("books", "Books"), MOBILES("mobiles", "Mobiles & Tablets"), KITCHEN("kitchen", "Home & Kitechen"),
	TEST("test", "test");
	
	private String name;
	private String desc;
	
	ProductCatagoryEnum(String name, String desc){
		this.name = name;
		this.desc = desc;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDesc(){
		return desc;
	}
}
