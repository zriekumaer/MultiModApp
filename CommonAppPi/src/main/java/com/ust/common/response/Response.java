package com.ust.common.response;

import java.util.ArrayList;
import java.util.List;

public class Response {
	
    private List<String> errors;

    public Response() { this.errors = new ArrayList<String>(); }

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
    
    
}