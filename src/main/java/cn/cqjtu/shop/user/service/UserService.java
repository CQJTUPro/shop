package cn.cqjtu.shop.user.service;
/**
 * 用户模块业务层代码
 * @author ZhangXiong
 *
 */


import java.util.List;

import javax.mail.MessagingException;

import org.springframework.transaction.annotation.Transactional;

import cn.cqjtu.shop.utils.MailUtils;

import cn.cqjtu.shop.category.vo.Category;
import cn.cqjtu.shop.user.dao.UserDao;
import cn.cqjtu.shop.user.vo.User;
import cn.cqjtu.shop.utils.PageBean;
import cn.cqjtu.shop.utils.UUIDUtils;


@Transactional
public class UserService {
	// 注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    //业务层按用户名查询用户的方法
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
    //业务层用户注册方法
	public void save(User user) {
		user.setState(0);   //0表示未激活   1表示激活
		user.setCode(UUIDUtils.getUUID()+UUIDUtils.getUUID());  //一次生成32位字符串
		//调用持久层存入注册用户方法
		//发送激活邮件
		String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
				+ "<a href='http://localhost:8080/maven-ssh-shop/user_active.action?code="+user.getCode()+"'>"
						+ "http://localhost:8080/maven-ssh-shop/user_active.action?code="+user.getCode()+"</a>";
		try {
			MailUtils.sendMail(user.getEmail(), emailMsg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		userDao.save(user);
	}
	//用户登录，返回查询到的用户
	public User login(User user) {
		return userDao.login(user);
	}
	public PageBean<User> findAll(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setPage(page);
		int limit = 10;
		pageBean.setLimit(limit);
		int count = 0;
		count = userDao.findCount();
		pageBean.setTotalCount(count);
		int totalPage = 0;
		if (count % limit == 0) {
			totalPage = count / limit;
		} else {
			totalPage = count / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		int start = (page - 1) * limit;
		List<User> list = userDao.findAll(start, limit);
		pageBean.setList(list);
		return pageBean;
	}
	//根据用户id查找用户
	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}
	//编辑用户
	public void editUser(User user) {
		userDao.editUser(user);
	}
	public void removeUser(User user) {
		userDao.removeUser(user);
	}
	public void active(String code) {
		User user=userDao.findByCode(code);
		user.setState(1);
		userDao.editUser(user);
	}
	
}
