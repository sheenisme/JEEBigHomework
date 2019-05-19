package com.jee.control;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
 
 
/**
 * 批量从request请求中获取参数值，并赋值给对象
 * 说明：在servlet中常需要从request中获取参数，同时需要赋值给某个实例对象，当参数较少时可以使用getParameter(String name);
 * 从request中获取，但是当数据较多时，代码冗余复杂，没有技术含量，所以利用反射写了一个批量对参数获取并赋值的方法
 * （暂时只支持对String，Integer,int，Float,float,Double,double,java.sql.Date,java.util.Date类型的数据或者数组进行赋值）
 * @author 
 * https://blog.csdn.net/dingse/article/details/79122424
 *
 */
public class Conversion {
 
	public static <T> void convert(T t, HttpServletRequest request) {
 
		// 获取类对象
		Class<?> vo = t.getClass();
		try {
			// 获取所有属性
			Field[] fs = vo.getDeclaredFields();
			for (Field f : fs) {
				// 设置为可访问
				f.setAccessible(true);
				// 获得属性名
				String name = f.getName();
				// 获得属性的类型名
				Class<?> type = f.getType();
				// 判断是否为数组类型的属性
				if (type.isArray()) {
					System.out.println("s数组转换");
					// 从请求中获取参数数组
					String[] str = request.getParameterValues(name);
					if (str != null) {
						// 判断属性的类型
						if (type == String.class) {
 
							// 设置属性值
							f.set(t, str);
						} else if (type == int[].class || type == Integer[].class) {// 整型
							// 创建一个整型数组
							Integer[] args = new Integer[str.length];
							// 将String转换为Integer
							for (int i = 0; i < str.length; i++) {
								args[i] = Integer.valueOf(str[i]);
							}
 
							f.set(t, args);
						} else if (type == Float[].class || type == float[].class) {
							// 创建一个float数组
							Float[] args = new Float[str.length];
							// 将String转换为Float
							for (int i = 0; i < str.length; i++) {
								args[i] = Float.valueOf(str[i]);
							}
 
							f.set(t, args);
						} else if (type == Double[].class || type == double[].class) {
							// 创建一个Double数组
							Double[] args = new Double[str.length];
							// 将String转换为Double
							for (int i = 0; i < str.length; i++) {
								args[i] = Double.valueOf(str[i]);
							}
 
							f.set(t, args);
						}else if(type==Date[].class){//转换为java.sql.Date 类型
							Date[] date=new Date[str.length];
							for(int i=0;i<str.length;i++){
								try {
									date[i]= new Date(new SimpleDateFormat("yyyy-MM-dd").parse(str[i]).getTime());
								} catch (ParseException e) {
									e.printStackTrace();
								}
								f.set(t, date);
							}
						} else if(type==java.util.Date[].class){
							java.util.Date[] date=new Date[str.length];
							for(int i=0;i<str.length;i++){
								try {
									date[i]= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(str[i]);
								} catch (ParseException e) {
									e.printStackTrace();
								}
								f.set(t, date);
							}
						}
					}
 
				}
				//如果不是数组类型
				else {
					String str = request.getParameter(name);
					if (str != null) {
						// String类型
						if (type == String.class) {
							f.set(t, str);
						} else if (type == int.class || type == Integer.class) {// 整型
							f.set(t, Integer.valueOf(str));
						} else if (type == Float.class || type == float.class) {// float类型
							f.setFloat(t, Float.valueOf(str));
						} else if (type == Double.class || type == double.class) {// double类型
							f.setDouble(t, Double.valueOf(str));
						}else if(type==Date.class){//转换为java.sql.Date 类型
							Date date;
							try {
								date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime());
								f.set(t, date);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							
						}else if(type==Timestamp.class){//java.sql.Timestap类型转换
							Timestamp time;
							try {
								time=new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime());
								f.set(t, time);
							} catch (ParseException e) {
								System.out.println("timestamp类型的参数写入到值对象时发生错误！");
								e.printStackTrace();
							}
						}else if(type==java.util.Date.class){//java.util.Date类型转换
							java.util.Date date;
							try {
								date= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(str);
								f.set(t, date);
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}else if(type == boolean.class) {
							f.set(t, Boolean.valueOf(str));
							//f.setBoolean(t, Boolean.valueOf(str));
						}
					}
					//如果是未识别的是ID，这可能为自增的主键
					else if(name.equals("id") || name.equals("Id") || name.equals("ID")){
						;
					}
					//如果都不是以上类型，进行提示
					else{
						System.out.println(name+"的属性值是："+str+" ！未能成功存入"+vo+"对象中！");
					}
				}
 
			}
 
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
 
}


//作者：Dearan33 
//来源：CSDN 
//原文：https://blog.csdn.net/dingse/article/details/79122424 
//版权声明：本文为博主原创文章，转载请附上博文链接！