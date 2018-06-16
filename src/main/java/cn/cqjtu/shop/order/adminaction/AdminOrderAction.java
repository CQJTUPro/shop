package cn.cqjtu.shop.order.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.cqjtu.shop.order.service.OrderService;
import cn.cqjtu.shop.order.vo.Order;
import cn.cqjtu.shop.order.vo.OrderItem;
import cn.cqjtu.shop.utils.PageBean;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
	private Order order = new Order();

	@Override
	public Order getModel() {
		return order;
	}

	private OrderService orderService;
	private Integer page;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	// 查询所有订单
	public String findAll() {
		PageBean<Order> pageBean = orderService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// 根据订单id查询所有订单项
	public String findOrderItemByOid() {
		List<OrderItem> oilist=orderService.findOrderItemByOid(order.getOid());
		ActionContext.getContext().getValueStack().set("oilist", oilist);
		return "findOrderItemByOid";
	}
	//根据订单id修改订单状态(发货)
	public String updateOrderState() {
		order=orderService.findByOid(order.getOid());
		//后台发货
		order.setState(3);
		orderService.update(order);
		return "updateOrderState";
	}
}
