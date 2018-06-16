package cn.cqjtu.shop.category.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import cn.cqjtu.shop.product.vo.Product;


public class Category implements Serializable{
private Integer cid;    
private Integer parentid;//父节点，0表示该结点为根结点
private String cname;
private Set<Product> products=new HashSet<Product>();

public Set<Product> getProducts() {
	return products;
}
public void setProducts(Set<Product> products) {
	this.products = products;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public Integer getParentid() {
	return parentid;
}
public void setParentid(Integer parentid) {
	this.parentid = parentid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
}
