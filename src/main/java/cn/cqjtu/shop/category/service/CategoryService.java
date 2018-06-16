package cn.cqjtu.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.cqjtu.shop.category.dao.CategoryDao;
import cn.cqjtu.shop.category.vo.Category;
import cn.cqjtu.shop.utils.PageBean;


/**
 * 类别模块业务层
 * 
 * @author ZhangXiong
 *
 */
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// 业务层查询所有种类
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	// 查询一级分类
	public List<Category> findFirst() {
		return categoryDao.findFirst();
	}

	// 添加一级分类
	public void addFirst(Category category) {
		categoryDao.addFirst(category);
	}

	// 删除一级分类
	public void removeFirst(Category category) {
		List<Category> slist = categoryDao.findSecondByParentid(category.getCid());
		if (slist != null && slist.size() > 0)
			for (Category c : slist) {
				categoryDao.removeFirst(c);
			}
		categoryDao.removeFirst(category);
	}

	// 根据种类id查询
	public Category findFirstByCid(Integer cid) {
		return categoryDao.findFirstByCid(cid);
	}

	// 编辑一级分类
	public void editFirst(Category category) {
		categoryDao.editFirst(category);
	}

	// 根据一级分类id查询二级分类
	public List<Category> findSecondByParentid(Integer parentid) {
		return categoryDao.findSecondByParentid(parentid);
	}

	// 查询所有二级分类(分页)
	public PageBean<Category> findSecond(Integer page) {
		PageBean<Category> pageBean = new PageBean<Category>();
		pageBean.setPage(page);
		int limit = 10;
		pageBean.setLimit(limit);
		int count = 0;
		count = categoryDao.findSecondCount();
		pageBean.setTotalCount(count);
		int totalPage = 0;
		if (count % limit == 0) {
			totalPage = count / limit;
		} else {
			totalPage = count / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		int start = (page - 1) * limit;
		List<Category> list = categoryDao.findSecond(start, limit);
		pageBean.setList(list);
		return pageBean;
	}

	public List<Category> findAllSecond() {
		return categoryDao.findAllSecond();
	}
}
