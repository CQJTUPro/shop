package cn.cqjtu.shop.order.vo;

import java.io.Serializable;

import cn.cqjtu.shop.product.vo.Product;



public class OrderItem implements Serializable {
	private Integer itemid;//订单项id
	private Integer count;//商品数量
	private Double subtotal;//订单项小计
	private Product product;//商品
	private Order order;//对应订单
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
