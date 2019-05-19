package com.jee.control;

/**
 * 定义加密操作的接口：IEncrypt
 * @author 广辉
 *
 */
public interface IEncrypt {
	public String md5(String inputString); // 把inputString加密 
	public boolean authenticatePassword(String password,String inputString);//验证输入的密码inputString是否正确 
}