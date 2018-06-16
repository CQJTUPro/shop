package cn.cqjtu.shop.user.action;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.cqjtu.shop.user.service.UserService;
import cn.cqjtu.shop.user.vo.User;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;
	private String checkcode;
	private String autoLogin = "";

	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	@Override
	public User getModel() {
		return user;
	}

	/**
	 * 跳转到注册页面的执行放法
	 */
	public String registPage() {
		return "registPage";
	}

	/**
	 * AJAX异步校验用户名的执行放法
	 * 
	 * @throws IOException
	 */
	public String findByUsername() throws IOException {
		User existUser = userService.findByUsername(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		boolean isExist = false;
		if (existUser != null) {
			isExist = true;

		}
		String json = "{\"isExist\":" + isExist + "}";
		response.getWriter().write(json);
		return NONE;
	}

	/**
	 * 用户注册
	 */
	public String regist() {
		// 判断验证码
		String code = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if (!code.equalsIgnoreCase(checkcode)) {

			this.addActionError("验证码错误");
			return "checkcodeFail";
		}
		// 调用业务层注册用户方法
		userService.save(user);
		return "msg";
	}

	/**
	 * 跳转到登录页面的执行放法
	 */
	public String loginPage() {
		return "loginPage";
	}

	/**
	 * 用户激活
	 */
	public String active() {
		userService.active(user.getCode());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write("激活成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "activeSuccess";
	}

	/**
	 * 用户登录
	 */
	public String login() {
		// 调用业务层登录用户方法
		User existUser = userService.login(user);
		if (existUser != null && existUser.getState() != 0) {
			ServletActionContext.getRequest().getSession().setAttribute("user", existUser);
			if (autoLogin.equals("autoLogin")) {
				// 要自动登录
				// 创建存储用户名的cookie
				Cookie cookie_username = new Cookie("cookie_username", user.getUsername());
				cookie_username.setMaxAge(7 * 24 * 60 * 60);
				// 创建存储密码的cookie
				Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
				cookie_password.setMaxAge(7 * 24 * 60 * 60);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}

			return "loginSuccess";
		} else {
			ServletActionContext.getRequest().setAttribute("info", "用户名或密码错误或用户未激活");
			return "loginFail";
		}
	}

	/**
	 * 用户退出
	 */
	public String quit() {
		// 清除session中的user
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		// 清除自动登录的cookie
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse rep = ServletActionContext.getResponse();
		// 获取携带用户名和密码cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// 获得想要的cookie
				if ("cookie_username".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					rep.addCookie(cookie);
				}
				if ("cookie_password".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					rep.addCookie(cookie);
				}
			}
		}
		return "quit";
	}
}
