package com.seling.test;

public class BeanShellEg implements BeanUtil {

	private String  userName;
	private String address;
	
	public BeanShellEg(String name) {
		this.userName = name;
	}
	
	public BeanShellEg(String name,String address) {
		this.userName = name;
		this.address = address;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public int mul(int i) {
		// TODO Auto-generated method stub
		return i*i;
	}

}
