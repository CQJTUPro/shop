package cn.cqjtu.shop.interceptor;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.cqjtu.shop.user.service.UserService;
import cn.cqjtu.shop.user.vo.User;

/**
 * 没有登录不能访问后台管理系统
 * 
 * @author ZhangXiong
 *
 */
public class AutoLoginInterceptor extends MethodFilterInterceptor {

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	// 执行拦截的方法
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user == null) {
			String cookie_username = null;
			String cookie_password = null;
            HttpServletRequest req=ServletActionContext.getRequest();
			// 获取携带用户名和密码cookie
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					// 获得想要的cookie
					if ("cookie_username".equals(cookie.getName())) {
						cookie_username = cookie.getValue();
					}
					if ("cookie_password".equals(cookie.getName())) {
						cookie_password = cookie.getValue();
					}
				}
			}

			if (cookie_username != null && cookie_password != null) {
				// 去数据库校验该用户名和密码是否正确
				try {
					User cuser=new User();
					cuser.setUsername(cookie_username);
					cuser.setPassword(cookie_password);
					user = userService.login(cuser);
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 完成自动登录
				ServletActionContext.getRequest().getSession().setAttribute("user",user);

			}
		}
		// 放行
		return arg0.invoke();
	}

}
