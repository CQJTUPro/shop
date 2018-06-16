package cn.cqjtu.shop.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.cqjtu.shop.category.service.CategoryService;
import cn.cqjtu.shop.category.vo.Category;
import cn.cqjtu.shop.utils.PageBean;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
	private CategoryService categoryService;
	private Category category = new Category();
	// 接收查询页数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	@Override
	public Category getModel() {
		return category;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// 查询一级分类
	public String findFirst() {
		List<Category> clist = categoryService.findFirst();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "findFirst";
	}

	// 添加一级分类
	public String addFirst() {
		category.setParentid(0);
		categoryService.addFirst(category);
		return "addFirst";
	}

	// 删除一级分类
	public String removeFirst() {
		// 需先进行查询获取要删除的对象，再进行删除
		category = categoryService.findFirstByCid(category.getCid());
		// 删除
		categoryService.removeFirst(category);
		return "removeFirst";
	}

	// 跳转到修改一级分类页面
	public String editFirstPage() {
		category = categoryService.findFirstByCid(category.getCid());
		return "editFirstPage";
	}

	// 修改一级分类
	public String editFirst() {
		category.setParentid(0);
		categoryService.editFirst(category);
		return "editFirst";
	}

	// 查询二级分类
	public String findSecond() {
		PageBean<Category> pageBean = categoryService.findSecond(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findSecond";
	}

	// 跳转到添加二级分类的页面
	public String addSecondPage() {
		List<Category> clist = categoryService.findFirst();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "addSecondPage";
	}

	// 添加二级分类
	public String addSecond() {
		categoryService.addFirst(category);
		return "addSecond";
	}

	// 删除二级分类(级联删除商品)
	public String removeSecond() {
		// 需先进行查询获取要删除的对象，再进行删除
		category = categoryService.findFirstByCid(category.getCid());
		// 删除
		categoryService.removeFirst(category);
		return "removeSecond";
	}

	// 跳转到编辑二级分类页面
	public String editSecondPage() {
		category = categoryService.findFirstByCid(category.getCid());
		List<Category> clist = categoryService.findFirst();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "editSecondPage";
	}

	// 编辑二级分类
	public String editSecond() {
		categoryService.editFirst(category);
		return "editSecond";
	}
}
