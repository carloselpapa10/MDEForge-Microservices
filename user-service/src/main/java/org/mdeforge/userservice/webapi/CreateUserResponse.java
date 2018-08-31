package org.mdeforge.userservice.webapi;

public class CreateUserResponse {

	private String idUser;

	public CreateUserResponse() {}

	public CreateUserResponse(String idUser) {
		this.idUser = idUser;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
}
