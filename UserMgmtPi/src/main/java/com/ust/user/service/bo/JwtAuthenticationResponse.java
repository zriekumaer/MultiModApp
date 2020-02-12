package com.ust.user.service.bo;

public class JwtAuthenticationResponse {
	
	private String accessToken;
	
	private String tokenType = "Bearer";
	private UserBO userBO;

	public JwtAuthenticationResponse(String accessToken, UserBO userBO) {
		this.accessToken = accessToken;
		this.userBO = userBO;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}