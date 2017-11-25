package com.bsm.rest.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bsm.rest.messenger.model.ExceptionModel;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException errorMessage) {
		ExceptionModel ex = new ExceptionModel(errorMessage.getMessage(), "http://bsm.com", 1025);
		return Response.status(Status.NOT_FOUND).entity(ex).build();
	}

}
