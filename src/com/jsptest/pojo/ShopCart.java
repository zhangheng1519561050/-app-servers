package com.jsptest.pojo;

public class ShopCart {
	
	private  String productName;
	private int productprice;
	
	//������Ʒ�ܼ�
	private int oneallprice;
	private  int oneproductnum;
	//private int allproductnum;
//	//������Ʒ�ܼ�
//	private int allprice;
	
	//��������
	private int oneInventory;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public int getOneallprice() {
		return oneallprice;
	}

	public void setOneallprice(int oneallprice) {
		this.oneallprice = oneallprice;
	}

	public int getOneproductnum() {
		return oneproductnum;
	}

	public void setOneproductnum(int oneproductnum) {
		this.oneproductnum = oneproductnum;
	}

	public int getOneInventory() {
		return oneInventory;
	}

	public void setOneInventory(int oneInventory) {
		this.oneInventory = oneInventory;
	}

	public ShopCart(String productName, int productprice, int oneallprice,
			int oneproductnum, int oneInventory) {
		super();
		this.productName = productName;
		this.productprice = productprice;
		this.oneallprice = oneallprice;
		this.oneproductnum = oneproductnum;
		this.oneInventory = oneInventory;
	}

	
	
	
	

}
