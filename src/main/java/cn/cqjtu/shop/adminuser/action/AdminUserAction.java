package cn.cqjtu.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.cqjtu.shop.adminuser.service.AdminUserService;
import cn.cqjtu.shop.adminuser.vo.AdminUser;
import cn.cqjtu.shop.user.service.UserService;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	private AdminUserService adminUserService;
	private AdminUser adminUser = new AdminUser();

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@Override
	public AdminUser getModel() {
		return adminUser;
	}

	public String login() {
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if (existAdminUser == null) {
			ServletActionContext.getRequest().setAttribute("info", "用户名或密码错误");
			return "adminLoginFail";
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("adminUser", existAdminUser);
			return "adminLoginSuccess";
		}
	}

	/**
	 * 管理员退出
	 */
	public String quit() {
		ServletActionContext.getRequest().getSession().removeAttribute("adminUser");
		return "quitAdmin";
	}
}
