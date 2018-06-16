package cn.cqjtu.shop.utils;

import java.util.UUID;

/**
 * 生成随意字符串工具类
 * 
 * @author ZhangXiong
 *
 */
public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
