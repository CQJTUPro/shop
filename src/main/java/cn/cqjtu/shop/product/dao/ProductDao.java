package cn.cqjtu.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.cqjtu.shop.product.vo.Product;
import cn.cqjtu.shop.utils.PageHibernateCallback;


/**
 * 商品持久层
 * 
 * @author ZhangXiong
 *
 */
public class ProductDao extends HibernateDaoSupport {

	// 查询热门商品（10条）
	public List<Product> findHot() {
		// 使用离线条件查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 根据is_hot=1 热门
		criteria.add(Restrictions.eq("is_hot", 1));
		// 倒序查询(新增加热门)
		criteria.addOrder(Order.desc("pdate"));
		List<Product> pList = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return pList;
	}
	// 查询最新商品（10条）
	public List<Product> findNew() {
		// 使用离线条件查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 倒序查询最新商品
		criteria.addOrder(Order.desc("pdate"));
		List<Product> nList = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return nList;
	}
	// 根据pid查询商品
	public Product findByPid(Integer pid) {	
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	//按二级种类id查询商品数量
	public int findCountByCid(Integer cid) {
		String hql="select count(*) from Product p where p.category.cid=?";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql,cid);
		if(list!=null&&list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	//按二级种类id分页查询
	public List<Product> findByCidPage(Integer cid, int start, int limit) {
		String hql="select p from Product p where p.category.cid=?";
		List<Product>list= this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[] {cid}, start, limit));
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
	//按一级种类id分页查询
	public List<Product> findByParentidPage(Integer cid, int start, int limit) {
		String hql="select p from Product p where p.category.parentid=?";
		List<Product>list= this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[] {cid}, start, limit));
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
	//按一级种类id查询商品数量
	public int findCountByParentid(Integer parentid) {
		String hql="select count(*) from Product p where p.category.parentid=?";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql,parentid);
		if(list!=null&&list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	//查询所有商品的数量
	public int findAllCount() {
		String hql="select count(*) from Product";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	//查询所有商品
	public List<Product> findAll(int start, int limit) {
		String hql="from Product order by pdate desc";
		List<Product>list= this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, start, limit));
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
	public void addProduct(Product product) {
		this.getHibernateTemplate().save(product);
	}
	public void removeProduct(Product product) {
		this.getHibernateTemplate().delete(product);
	}
	public void editProduct(Product product) {
		this.getHibernateTemplate().update(product);
	}
	public List<String> findProductNameByWord(String word) {
		String hql="select pname from Product where pname like ?";
		List<String>list= this.getHibernateTemplate().execute(new PageHibernateCallback<String>(hql, new String[]{"%"+word+"%"}, 0, 8));
		return list;
	}

}
