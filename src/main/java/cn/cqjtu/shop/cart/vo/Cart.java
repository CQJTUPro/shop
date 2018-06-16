package cn.cqjtu.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import sun.security.action.GetBooleanAction;

public class Cart implements Serializable {
	// 购物车总计
	private double total;
	// 购物项集合key=商品id，value=购物项
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();

	public double getTotal() {
		return total;
	}

	// 获取购物项的单列集合
	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	// 添加购物项
	public void addCartItem(CartItem cartItem) {
		int key = cartItem.getProduct().getPid();
		if (map.containsKey(key)) {
			// 如果购物项已经存在，只需增加数量
			CartItem mCartItem = map.get(key);
			mCartItem.setCount(mCartItem.getCount() + cartItem.getCount());
		} else {
			// 如果不存在则添加
			map.put(key, cartItem);
		}
		total += cartItem.getSubtotal();
	}

	// 移除购物项
	public void removeCartItem(int pid) {
		// 删除购物项
		CartItem cartItem = map.remove(pid);
		// 计算总计
		total -= cartItem.getSubtotal();
	}

	// 清空购物项
	public void clearCart() {
		// 清空购物项
		map.clear();
		// 总计清0
		total = 0;
	}
}
