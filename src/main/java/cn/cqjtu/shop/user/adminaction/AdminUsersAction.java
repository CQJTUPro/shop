package cn.cqjtu.shop.user.adminaction;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.cqjtu.shop.user.service.UserService;
import cn.cqjtu.shop.user.vo.User;
import cn.cqjtu.shop.utils.PageBean;


public class AdminUsersAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		return user;
	}
	// 接收查询页数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}
	//查询所有用户
	public String findAll() {
		PageBean<User> pageBean = userService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	// 跳转到修改用户页面
	public String editUserPage() {
		user = userService.findByUid(user.getUid());
		return "editUserPage";
	}
	// 编辑用户
	public String editUser() {
		userService.editUser(user);
		return "editUser";
	}
	// 删除二级分类(级联删除商品)
	public String removeUser() {
		// 需先进行查询获取要删除的对象，再进行删除
		user = userService.findByUid(user.getUid());
		// 删除
		userService.removeUser(user);
		return "removeUser";
	}
}

