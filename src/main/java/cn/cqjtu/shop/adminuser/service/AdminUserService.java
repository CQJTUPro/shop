package cn.cqjtu.shop.adminuser.service;

import cn.cqjtu.shop.adminuser.dao.AdminUserDao;
import cn.cqjtu.shop.adminuser.vo.AdminUser;

public class AdminUserService {
private AdminUserDao adminUserDao;

public void setAdminUserDao(AdminUserDao adminUserDao) {
	this.adminUserDao = adminUserDao;
}

public AdminUser login(AdminUser adminUser) {
	return adminUserDao.login(adminUser);
}

}
