package com.amao.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 */

public class AlipayConfig {
	
	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://globalprod.alipay.com/order/myOrder.htm
	// 下面的值默认是一个沙箱测试账号，您可参考下面网址申请自己的沙箱测试账号：https://global.alipay.com/help/integration/23

	public static String app_id = "2016102500754781";//沙箱测试

	public static String url = "https://openapi.alipaydev.com/gateway.do";
	//数据类型
	public static String format = "json";
	// 公钥
	public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl2QG4IphXbP04tE4s4JrEw6DKkyPziGxeX6Z6ueajex1MdgRDAS0ZTELNG30Gki0OHuzIyV9KOuOhn/aoweXb5clsxwg3MYv34LMyQ/BKJAliqXJaNpIKqZq5/8/XP5dGGNkCmZH8WvnTGcBpbWF8j3E5a9mQ8bfClEaG/6NKPMMjxcHVuXOA3jV+OHN6nA9SuSn0Xmquf06vIAyW7lbfNVhQnLntPRTmwk72dJGbZDkMNrw+TEqvu9Xxf5X3qGmTu5xFgay72lWb9s2dJyMGanbxgjI722ShibzxJd4pgZLp8oe5ZPdDv8RvRfFc38/4mZezCKdvjsNUh1q8hBKfwIDAQAB";
	// 商户的私钥
	public static String partner = "2088621891276675";//Cross-border Online Payment(PC) --ok
	

	  
	public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCXZAbgimFds/Ti0TizgmsTDoMqTI/OIbF5fpnq55qN7HUx2BEMBLRlMQs0bfQaSLQ4e7MjJX0o646Gf9qjB5dvlyWzHCDcxi/fgszJD8EokCWKpclo2kgqpmrn/z9c/l0YY2QKZkfxa+dMZwGltYXyPcTlr2ZDxt8KURob/o0o8wyPFwdW5c4DeNX44c3qcD1K5KfReaq5/Tq8gDJbuVt81WFCcue09FObCTvZ0kZtkOQw2vD5MSq+71fF/lfeoaZO7nEWBrLvaVZv2zZ0nIwZqdvGCMjvbZKGJvPEl3imBkunyh7lk90O/xG9F8Vzfz/iZl7MIp2+Ow1SHWryEEp/AgMBAAECggEAN+xCQhW8C9IbBuJEcMMfbIWy3CA2Cu4VUgz7LHPreru7OvNWsLrYLH0mZ3Kqdj8fG7JOJRCHIGOLXZHDIO//97+8tGISnZs0OftmTGtebe55f7LoKKxhdifNW+/E50Qq/YRRgynvL3YtleKDEERyu14n6rSVMTo4T+ZPn8GzQUmb0hHmBWVfrfMwzPTZbA2Cr4VNGTonQkwLHT+c2FCx6YOeZtiaZ4gYPRgx8RuDIGBL65rWRc7N4VwZ5l3E7tVFWnzlw1tSim2ypXGvL6lbj+5ISdeUV2xKyPguV3vBSXWWqKOlpkE9k4xQWkSWeadz7GlZYTLvq63LanCS3wGhuQKBgQDlmKPdV70kn0e1SEDj8jH21E1lwp33PtUeV4txJnDCf7dSwWvkwJBYPHsAiXGJqHPEJPXsO7yUPQEOtW1PYUREWgNaJYO8gtw3BestxqZ9W96z7C5YnRR0CNyJK/oPMtpPHDpghztIH275SeN0X5/l/Gm9mLaoWbj6cSQ81lkB+wKBgQCozQAfSsi3vNcI8BnUi/Bq2ZyBznzynfx0Z0vC6VIXV5k1h6WjXp4UwcW0n1Ko/yc1z1uSSNlFlBvTzw99zDeebLnEYY2MgEfpSqePROWfUGFKjjGM2hOkVEBIW/VEmF/f7Y2KgwfIf+rpOnY4X3MiqIDbP+AO6cOXxF6GClN2TQKBgQC8S7b4LKDejBLPRfaR+2umtu7S6g2LXGiEfd/KaHBJ01yR7jeCX7sB4nguNIp9Dz4COx3FJCjAmldnrLt9QpQuSnQ9Vk74J4pbRetem3CnltTKUoSgABNqJmpXxU1LcbVA9DGcQMwJll347PQx2MrWX3CJIdmLsCnYmznQ+yn8SQKBgGyncGG0GJk0o9HsAyRuY3XT10sy5/ifuyYOa5Tt7Np7l3H+e586Q1UnGaTXPTTs8IdRjycNX1XLLVJcoSMfddmzMKx5As0isac4V7z/4zJ2YfnEp557rVMErFAnaSwbTPNuDMLQ7wyfUk2IRRqqTglMH42Bgy72R+GEFDgBo5GtAoGASxCFD8RybOyZAT9zf8d1eK3nuHJXKsImYhurKOqjnRhLyZoJwFoo9ATS/Hb/CR9s292YavF8mXo3YenL2e2ZSnOQC8TV4hCG69vbmLzekCrXkLu+vvd5zGr9EnCKmUkJzLilF5wzT5y2YyIZr2RjpBj09PxkicjagxD1NGsWxLI=";
    //Alipay's public key,below is Alipay's public key of sandbox environment
	//Pls use the Alipay's public key of production environment instead if you are in production environment
	//public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	
	
	

	// 服务器异步通知页面路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	  public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";//test

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";//test
	// 签名方式
	//sign_type
	public static String sign_type = "RSA2";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C:\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
		

	// 调用的接口名，无需修改
	public static String service = "create_forex_trade";

}

