package cn.cqjtu.shop.product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.cqjtu.shop.category.service.CategoryService;
import cn.cqjtu.shop.category.vo.Category;
import cn.cqjtu.shop.product.service.ProductService;
import cn.cqjtu.shop.product.vo.Product;
import cn.cqjtu.shop.utils.PageBean;

public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	private Product product = new Product();
	private ProductService productService;
	private CategoryService categoryService;
	private Integer page;
	// 文件上传参数
	private File upload;// 上传的文件
	private String uploadFileName;// 上传文件的名称
	private String uploadContextType;// 上传文件的类型 (MIME类型)

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public Product getModel() {
		return product;
	}

	// 查询商品
	public String findAll() {
		PageBean<Product> pageBean = productService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// 跳转到添加商品页面
	public String addProductPage() {
		List<Category> clist = categoryService.findAllSecond();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "addProductPage";
	}

	// 添加商品
	public String addProduct() throws IOException {
		product.setPdate(new Date());
		if (upload != null) {
			// 获取文件上传的磁盘绝对路径(文件将要存放的路径)
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			// 创建一个文件
			File file = new File(realPath + "//" + uploadFileName);
			// 文件上传(复制文件)
			FileUtils.copyFile(upload, file);
			product.setImage("products/" + uploadFileName);
		}
		productService.addProduct(product);
		return "addProduct";
	}

	// 删除商品(包括图片)
	public String removeProduct() {
		product = productService.findByPid(product.getPid());
		String path = product.getImage();
		if (path != null) {
			String realPath = ServletActionContext.getServletContext().getRealPath("/" + path);
			File file = new File(realPath);
			file.delete();
		}
		productService.removeProduct(product);
		return "removeProduct";
	}

	// 跳转到编辑商品页面
	public String editProductPage() {
		product = productService.findByPid(product.getPid());
		List<Category> clist = categoryService.findAllSecond();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "editProductPage";
	}

	// 编辑商品
	public String editProduct() throws IOException {
		product.setPdate(new Date());
		if (upload != null) {
			//如果上传了文件,删除原图片
			String path=product.getImage();
			File pfile = new File(ServletActionContext.getServletContext().getRealPath("/" + path));
			pfile.delete();
			// 获取文件上传的磁盘绝对路径(文件将要存放的路径)
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			// 创建一个文件
			File file = new File(realPath + "//" + uploadFileName);
			// 文件上传(复制文件)
			FileUtils.copyFile(upload, file);
			product.setImage("products/" + uploadFileName);
		}
		productService.editProduct(product);
		return "editProduct";
	}
}
