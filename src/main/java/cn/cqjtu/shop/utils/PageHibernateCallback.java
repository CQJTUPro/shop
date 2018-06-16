package cn.cqjtu.shop.utils;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;



public class PageHibernateCallback<T> implements HibernateCallback<List<T>>{
	
	private String hql;
	private Object[] params;//条件参数
	private int startIndex;//开始位置
	private int pageSize;//查询数量
	

	public PageHibernateCallback(String hql, Object[] params,
			int startIndex, int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}



	public List<T> doInHibernate(Session session){
		//1 执行hql语句
		Query query = session.createQuery(hql);
		//2 实际参数
		if(params != null){
			for(int i = 0 ; i < params.length ; i ++){
				query.setParameter(i, params[i]);
			}
		}
		//3 分页
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		
		return query.list();
	}

}
