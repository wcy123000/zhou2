package com.wangchengyang.domain;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
private int id;
private String name;
private String phone;
private String address;
private String sex;
private String email;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", sex=" + sex
			+ ", email=" + email + "]";
}
public Employee(int id, String name, String phone, String address, String sex, String email) {
	super();
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.address = address;
	this.sex = sex;
	this.email = email;
}
public Employee() {
	super();
}



}
