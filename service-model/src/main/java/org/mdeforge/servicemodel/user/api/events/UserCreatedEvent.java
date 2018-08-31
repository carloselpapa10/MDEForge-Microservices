package org.mdeforge.servicemodel.user.api.events;

import org.mdeforge.servicemodel.user.api.info.*;

public class UserCreatedEvent implements UserDomainEvent{
	
	private UserInfo userInfo;
	private RoleInfo roleInfo;

	public UserCreatedEvent() {}

	public UserCreatedEvent(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}

	public UserCreatedEvent(RoleInfo roleInfo) {
		super();
		this.roleInfo = roleInfo;
	}

	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}

}
