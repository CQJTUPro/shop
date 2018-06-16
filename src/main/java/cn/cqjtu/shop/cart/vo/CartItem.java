package cn.cqjtu.shop.cart.vo;

import cn.cqjtu.shop.product.vo.Product;

public class CartItem {
private Product product; //购买的商品
private int count;//购买商品数量
private double subtotal;//购买小计
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public double getSubtotal() {
	return count*product.getShop_price();
}
}
