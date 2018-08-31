package org.mdeforge.servicemodel.user.api.commands;

import java.util.List;
import io.eventuate.tram.commands.common.Command;
import org.mdeforge.servicemodel.user.api.info.*;

public class ValidateUserCommand implements Command{

	private UserInfo userInfo;
	private RoleInfo roleInfo;
	
	public ValidateUserCommand() {}

	public ValidateUserCommand(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}

	public ValidateUserCommand(RoleInfo roleInfo) {
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
