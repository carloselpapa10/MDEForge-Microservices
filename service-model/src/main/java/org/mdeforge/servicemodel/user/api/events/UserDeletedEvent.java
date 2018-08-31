package org.mdeforge.servicemodel.user.api.events;

import org.mdeforge.servicemodel.user.api.info.*;

public class UserDeletedEvent implements UserDomainEvent{
	
	private UserInfo userInfo;
	private RoleInfo roleInfo;

	public UserDeletedEvent() {}

	public UserDeletedEvent(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}

	public UserDeletedEvent(RoleInfo roleInfo) {
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
