package com.virtusa.project.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User{
	
	@Override
	@Id
	@Column(name = "adminId")
	public int getId() {
		return super.getId();
	}
	@Override
	public void setId(int id) {
		super.setId(id);
	}
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}
	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		super.setUserName(userName);
	}
	@Override
	public String getUserPassword() {
		// TODO Auto-generated method stub
		return super.getUserPassword();
	}
	@Override
	public void setUserPassword(String userPassword) {
		// TODO Auto-generated method stub
		super.setUserPassword(userPassword);
	}
	@Override
	public long getPhoneNumber() {
		// TODO Auto-generated method stub
		return super.getPhoneNumber();
	}
	@Override
	public void setPhoneNumber(long phoneNumber) {
		// TODO Auto-generated method stub
		super.setPhoneNumber(phoneNumber);
	}

}
