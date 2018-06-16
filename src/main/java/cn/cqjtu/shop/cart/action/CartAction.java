package cn.cqjtu.shop.cart.action;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.cqjtu.shop.cart.vo.Cart;
import cn.cqjtu.shop.cart.vo.CartItem;
import cn.cqjtu.shop.product.service.ProductService;
import cn.cqjtu.shop.product.vo.Product;

public class CartAction extends ActionSupport {

	// 接收购买商品数量
	private Integer count;
	// 接收购买商品id
	private Integer pid;

	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	// 从session中获取购物车
	public Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
	// 跳转到购物车页面
		public String cartPage() {
			return "cartPage";
		}

	// 添加购物项到购物车
	public String addCartItem() {
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		Product product = productService.findByPid(pid);
		cartItem.setProduct(product);
		getCart().addCartItem(cartItem);
		return "addCartItem";
	}

	// 清空购物车
	public String clearCart() {
		getCart().clearCart();
		return "clearCart";
	}

	// 根据商品id删除购物项
	public String removeCartItem() {
		getCart().removeCartItem(pid);
		return "removeCartItem";
	}
}
