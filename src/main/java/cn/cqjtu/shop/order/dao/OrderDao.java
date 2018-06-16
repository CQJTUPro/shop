package cn.cqjtu.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.cqjtu.shop.order.vo.Order;
import cn.cqjtu.shop.order.vo.OrderItem;
import cn.cqjtu.shop.utils.PageHibernateCallback;


public class OrderDao extends HibernateDaoSupport {

	public void addOrder(Order order) {
	    this.getHibernateTemplate().save(order);
	}

	public int findCountByUid(Integer uid) {
		String hql="select count(*) from Order o where o.user.uid=?";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql,uid);
		if(list!=null&&list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findByUid(Integer uid, int start, int limit) {
		String hql="from Order o where o.user.uid=? order by ordertime desc";
		List<Order>list= this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[] {uid}, start, limit));
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}

	public int findAllCount() {
		String hql="select count(*) from Order";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findAll(int start, int limit) {
		String hql="from Order order by ordertime desc";
		List<Order>list= this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, null, start, limit));
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public List<OrderItem> findOrderItemByOid(Integer oid) {
		String hql="from OrderItem oi where oi.order.oid=?";
		return (List<OrderItem>) this.getHibernateTemplate().find(hql,oid);
	}

}
