package com.ust.common.response;

public class SingleResponse<T> extends Response {
	private T data;
	
	public SingleResponse(T t) {
		this.data = t;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}