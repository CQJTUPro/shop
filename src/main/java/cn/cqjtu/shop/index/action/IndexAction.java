package cn.cqjtu.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.cqjtu.shop.category.service.CategoryService;
import cn.cqjtu.shop.category.vo.Category;
import cn.cqjtu.shop.product.service.ProductService;
import cn.cqjtu.shop.product.vo.Product;

public class IndexAction extends ActionSupport {
	private CategoryService categoryService;
	private ProductService productService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * 跳转到主界面
	 */
	@Override
	public String execute() throws Exception {
		// 打开主页就查询所有种类
		//List<Category> clList = categoryService.findAll();
		// 将分类存入session(每个页面都有种类)
		//ActionContext.getContext().getSession().put("clist", clList);
		// 打开主页就查询热门商品
		List<Product> hlist = productService.findHot();
		// 将热门商品存入值栈 因为只显示在主界面
		ActionContext.getContext().getValueStack().set("hlist", hlist);
		// 打开主页就查询最新商品
		List<Product> nlist = productService.findNew();
		// 将热门商品存入值栈 因为只显示在主界面
		ActionContext.getContext().getValueStack().set("nlist", nlist);
		return "index";
	}
}
