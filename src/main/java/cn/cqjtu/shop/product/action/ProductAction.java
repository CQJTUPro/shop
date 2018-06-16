package cn.cqjtu.shop.product.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.cqjtu.shop.product.service.ProductService;
import cn.cqjtu.shop.product.vo.Product;
import cn.cqjtu.shop.utils.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {
	private ProductService productService;
	//获得模糊查询的关键字
	private String word;

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public Product getModel() {
		return product;
	}

	// 用于接收数据的模型驱动
	private Product product = new Product();

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//接收一级分类id
	private Integer parentid;
    //接收二级分类id
	private Integer cid;  
	//接收当前页数
	private int page;

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// 按照商品id查询商品
	public String findByPid() {
		product = productService.findByPid(product.getPid());
		return "productPage";
	}

	// 按照一级种类id查询商品（分页查询）
	public String findByParentidPage() {
		//product = productService.findByPid(product.getPid());
		PageBean<Product> pageBean=productService.findByParentidPage(parentid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByParentidPage";
	}
	// 按照二级种类id查询商品（分页查询）
	public String findByCidPage() {
		//product = productService.findByPid(product.getPid());
		PageBean<Product> pageBean=productService.findByCidPage(cid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByParentidPage";
	}
	// 异步查询商品名称
	public String findProductNameByWord() {
		List<String> productNameList = null;
		productNameList = productService.findProductNameByWord(word);
		Gson gson = new Gson();
		String json = gson.toJson(productNameList);
		HttpServletResponse response =ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	// 根据商品名称查询商品
//	public String findProductByName() {
//		PageBean<Product> pageBean=productService.findByParentidPage(parentid,page);
//		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
//		return "findByParentidPage";
//	}
}
