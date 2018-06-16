package cn.cqjtu.shop.category.action;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.*;
import com.opensymphony.xwork2.ActionSupport;

import cn.cqjtu.shop.category.service.CategoryService;
import cn.cqjtu.shop.category.vo.Category;
import cn.cqjtu.shop.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

public class CategoryAction extends ActionSupport {
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String findAllCategory() {
		// 异步查询所有种类
		//先从redis缓存中查询
		Jedis jedis = JedisPoolUtils.getJedis();
		String categoryListJson = jedis.get("categoryListJson");
		//若缓存没有，则查询数据库
		if (categoryListJson == null) {
			List<Category> clList = categoryService.findAll();
			if (clList != null) {
				// 要序列化的东西，不是一个单纯的值对象，而是Hibernate的代理类。所以它不知道怎么处理 HibernateProxy 这个类。
				// 为gson注册一个转换器
				Gson gson = new GsonBuilder().registerTypeAdapter(Category.class, new JsonSerializer<Category>() {
					@Override
					public JsonElement serialize(Category src, Type arg1, JsonSerializationContext arg2) {
						JsonObject o = new JsonObject();
						o.addProperty("parentid", src.getParentid());
						o.addProperty("cid", src.getCid());
						o.addProperty("cname", src.getCname());
						return o;
					}
				}).create();
				// Gson gson = new Gson();
				categoryListJson = gson.toJson(clList);
				//存入缓存
				jedis.set("categoryListJson",categoryListJson );
			}	
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(categoryListJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
}
