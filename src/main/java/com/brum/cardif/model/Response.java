package com.brum.cardif.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Response<T> extends RepresentationModel<Response<T>>{

	private int status;
	private T data;
	private long timeStamp;
	
	
	public Response() {
		this.timeStamp = System.currentTimeMillis();
	}
}
