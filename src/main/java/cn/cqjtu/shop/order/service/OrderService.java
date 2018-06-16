package cn.cqjtu.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.cqjtu.shop.order.dao.OrderDao;
import cn.cqjtu.shop.order.vo.Order;
import cn.cqjtu.shop.order.vo.OrderItem;
import cn.cqjtu.shop.utils.PageBean;


@Transactional
public class OrderService {
private OrderDao orderDao;

public void setOrderDao(OrderDao orderDao) {
	this.orderDao = orderDao;
}

public void addOrder(Order order) {
	orderDao.addOrder(order);
}

public PageBean<Order> findByUid(Integer uid, Integer page) {
	PageBean<Order> pageBean=new PageBean<Order>();
	//设置当前页数
	pageBean.setPage(page);
	//设置每页显示数量
	int limit=5;
	pageBean.setLimit(limit);
    //设置总数据总数
	int totalCount=0;
	totalCount=orderDao.findCountByUid(uid);
	pageBean.setTotalCount(totalCount);
	//设置总页数(向上取整)
	//Math.ceil(totalCount/limit)
	int totalPage=0;
	if(totalCount%limit==0)
		{totalPage=totalCount/limit;}
	else {
		totalPage=totalCount/limit+1;}
	pageBean.setTotalPage(totalPage);
	int start=(page-1)*limit;
	List<Order> list=orderDao.findByUid(uid, start,limit);
	pageBean.setList(list);
	return pageBean;
}

public Order findByOid(Integer oid) {
	return orderDao.findByOid(oid);
}
//修改订单状态
public void update(Order currOrder) {
	orderDao.update(currOrder);
}

public PageBean<Order> findAll(Integer page) {
	PageBean<Order> pageBean=new PageBean<Order>();
	//设置当前页数
	pageBean.setPage(page);
	//设置每页显示数量
	int limit=10;
	pageBean.setLimit(limit);
    //设置总数据总数
	int totalCount=0;
	totalCount=orderDao.findAllCount();
	pageBean.setTotalCount(totalCount);
	//设置总页数(向上取整)
	//Math.ceil(totalCount/limit)
	int totalPage=0;
	if(totalCount%limit==0)
		{totalPage=totalCount/limit;}
	else {
		totalPage=totalCount/limit+1;}
	pageBean.setTotalPage(totalPage);
	int start=(page-1)*limit;
	List<Order> list=orderDao.findAll(start,limit);
	pageBean.setList(list);
	return pageBean;
}

public List<OrderItem> findOrderItemByOid(Integer oid) {
	return orderDao.findOrderItemByOid(oid);
}
}
