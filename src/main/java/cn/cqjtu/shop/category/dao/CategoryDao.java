package cn.cqjtu.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.cqjtu.shop.category.vo.Category;
import cn.cqjtu.shop.utils.PageHibernateCallback;


/**
 * 类别模块持久层
 * @author ZhangXiong
 *
 */
public class CategoryDao extends HibernateDaoSupport{

	//dao层查询所有种类
	public List<Category> findAll() {
		String hql="from Category";
		List<Category> cList=(List<Category>) this.getHibernateTemplate().find(hql);
		return cList;
	}

	public List<Category> findFirst() {
		String hql="from Category where parentid=0";
		return (List<Category>) this.getHibernateTemplate().find(hql);
	}

	public void addFirst(Category category) {
		this.getHibernateTemplate().save(category);
	}

	public void removeFirst(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	public Category findFirstByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	public void editFirst(Category category) {
		this.getHibernateTemplate().update(category);
	}

	public List<Category> findSecondByParentid(Integer parentid) {
		String hql="from Category where parentid=?";
		return (List<Category>) this.getHibernateTemplate().find(hql,parentid);
	}

	public List<Category> findSecond(int start,int limit) {
		String hql="from Category where parentid>0 order by cid desc";
		List<Category>list= this.getHibernateTemplate().execute(new PageHibernateCallback<Category>(hql, null, start, limit));
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public int findSecondCount() {
		String hql="select count(*) from Category where parentid>0";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Category> findAllSecond() {
		String hql="from Category where parentid>0";
		return (List<Category>) this.getHibernateTemplate().find(hql);
	}

}
