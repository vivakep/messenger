package com.bsm.rest.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class CommentResource {
	// @GET
	// public String test() {
	// return "comments resource invoked";
	// }

	@GET
	@Path("/{commentId}")
	public String getComment(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId) {
		return String.format("comment resource invoked with messageId: %d and commentId: %d", messageId, commentId);
	}
}
