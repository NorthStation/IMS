package com.lms.zx.entity;

public class User {
	private String name;//用户名
	private String password;//密码
	private String power;//权限
	
	public User(){
		
	}
	
	public User(String name,String password,String power){
		this.name=name;
		this.password=password;
		this.power=power;
	}
	
	public String toString(){
		return this.name;
	}
	
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(this==obj){
			return true;
		}
		if(obj instanceof User){
			User user=(User)obj;
			return this.name.equals(user.getName()) && this.password.equals(user.getPassword()) && this.power.equals(user.getPower());
		}
		return false;
	}
	
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((power == null) ? 0 : power.hashCode());
		return result;
	}

	//getter和setter方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
}
