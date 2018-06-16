package cn.cqjtu.shop.interceptor;




import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.cqjtu.shop.user.vo.User;


/**
 * 没有登录不能访问后台管理系统
 * @author ZhangXiong
 *
 */
public class Interceptor extends MethodFilterInterceptor{

	@Override
	//执行拦截的方法
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user==null) {
			//未登录,拦截
			//获取正在执行的action			
			ServletActionContext.getRequest().setAttribute("info","登录后才能访问！" );
			return "nologinUser";
		}else {
			//已登录,放行
			return arg0.invoke();
		}
	}

}
