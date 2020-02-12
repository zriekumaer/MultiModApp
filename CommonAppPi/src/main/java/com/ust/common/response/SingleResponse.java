package com.ust.common.response;

public class SingleResponse<T> extends Response {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}