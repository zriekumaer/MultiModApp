package com.ust.user.service.bo;

import com.ust.common.bo.CommonBO;

public class UserBO extends CommonBO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String roleName;


    public UserBO() {
    }

    public UserBO(String pFirstName, String pLastName, String pEmail, String pPassword, String pRoleName) {
        firstName = pFirstName;
        lastName = pLastName;
        email = pEmail;
        password = pPassword;
        roleName = pRoleName;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}