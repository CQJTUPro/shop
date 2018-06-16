package cn.cqjtu.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.cqjtu.shop.product.dao.ProductDao;
import cn.cqjtu.shop.product.vo.Product;
import cn.cqjtu.shop.utils.PageBean;



/**
 * 商品业务层
 * 
 * @author ZhangXiong
 *
 */
@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
   //查询热门商品服务
	public List<Product> findHot() {
		return productDao.findHot();
	}
	public List<Product> findNew() {
		return productDao.findNew();
	}
	//按照商品id查询商品
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}
	//根据根据二级分类的id分页查询
	public PageBean<Product> findByCidPage(Integer cid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示数量
		int limit=8;
		pageBean.setLimit(limit);
	    //设置总数据总数
		int totalCount=0;
		totalCount=productDao.findCountByCid(cid);
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
		List<Product> list=productDao.findByCidPage(cid, start,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//根据根据一级分类的id分页查询
	public PageBean<Product> findByParentidPage(Integer parentid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示数量
		int limit=8;
		pageBean.setLimit(limit);
	    //设置总数据总数
		int totalCount=0;
		totalCount=productDao.findCountByParentid(parentid);
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
		List<Product> list=productDao.findByParentidPage(parentid, start,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Product> findAll(Integer page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示数量
		int limit=10;
		pageBean.setLimit(limit);
	    //设置总数据总数
		int totalCount=0;
		totalCount=productDao.findAllCount();
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
		List<Product> list=productDao.findAll(start,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
	public void removeProduct(Product product) {
		productDao.removeProduct(product);
	}
	public void editProduct(Product product) {
		productDao.editProduct(product);
	}
	public List<String> findProductNameByWord(String word) {
		return productDao.findProductNameByWord(word);
	}
	
}
