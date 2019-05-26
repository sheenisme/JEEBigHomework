package jee.com.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
 
/**
 * 
 * 订单号生成工具，生成非重复订单号，理论上限1毫秒1000个，可扩展
 *
 */
public class MakeOrderNum {
	/**
	 * 锁对象，可以为任意对象
	 */
	private static Object lockObj = "lockerOrder";
	/**
	 * 订单号生成计数器
	 */
	private static long orderNumCount = 0L;
	/**
	 * 每毫秒生成订单号数量最大值
	 */
	private static int maxPerMSECSize=1000;
	/**
	 * 生成非重复订单号，理论上限1毫秒1000个，可扩展
	 * 
	 */
	
	// 最终生成的订单号
	static String finOrderNum = "";
	
	/**
	 * 构造函数
	 */
	public void makeOrderNum() {
		
	} 
	
	/**
	 * 获取订单号
	 * @return 订单号
	 */
	public static String getOrderNumber() {
		try {			
			synchronized (lockObj) {
				// 取系统当前时间作为订单号变量前半部分，精确到毫秒
				long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
				// 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
				if (orderNumCount >= maxPerMSECSize) {
					orderNumCount = 0L;
				}
				
				//组装订单号
				String countStr =String.valueOf(maxPerMSECSize)+String.valueOf(orderNumCount);
				finOrderNum=countStr +String.valueOf(nowLong);
				orderNumCount++;
				System.out.println(finOrderNum + "--" + Thread.currentThread().getName() );
				// Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return finOrderNum;
	}
}
