package cn.cqjtu.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.cqjtu.shop.category.vo.Category;
import cn.cqjtu.shop.user.vo.User;



/**
 * 用户模块持久层代码
 * @author ZhangXiong
 *
 */
public class UserDao extends HibernateDaoSupport{
    //按名称查找用户
	public User findByUsername(String username) {
		String hql="from User where username=?";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql, username);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
    //将注册用户存入数据库的方法
	public void save(User user) {
		this.getHibernateTemplate().save(user);//调用haibernate模板
	}
	//用户登录，返回查询到的用户
	public User login(User user) {
		String hql="from User where username=? and password=? and state=?";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword(),1);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	//查询用户数量
	public int findCount() {
		String hql="select count(*) from User";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	//查询所有用户
	public List<User> findAll(int start, int limit) {
		String hql="from User";
		return (List<User>) this.getHibernateTemplate().find(hql);
	}
	//根据用户id查询用户
	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}
	//跟新用户
	public void editUser(User user) {
		this.getHibernateTemplate().update(user);
	}
	//删除用户
	public void removeUser(User user) {
		this.getHibernateTemplate().delete(user);
	}
	public User findByCode(String code) {
		String hql="from User where code=?";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql,code);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
