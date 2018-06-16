package cn.cqjtu.shop.order.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.cqjtu.shop.user.vo.User;


public class Order implements Serializable {
private Integer oid;   //订单id
private double total;  //订单总额
private Date ordertime;//生成订单时间
private Integer state;//订单状态,1.未付款 ,2.已付款未发货,3.已发货未收货,4.交易完成
private User user;//订单对应用户
private String name;//收货姓名
private String phone;//收货电话
private String addr;//收货地址
private Set<OrderItem>orderItems=new HashSet<OrderItem>();//订单对应订单项
public Integer getOid() {
	return oid;
}
public void setOid(Integer oid) {
	this.oid = oid;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public Date getOrdertime() {
	return ordertime;
}
public void setOrdertime(Date ordertime) {
	this.ordertime = ordertime;
}
public Integer getState() {
	return state;
}
public void setState(Integer state) {
	this.state = state;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Set<OrderItem> getOrderItems() {
	return orderItems;
}
public void setOrderItems(Set<OrderItem> orderItems) {
	this.orderItems = orderItems;
}

}
