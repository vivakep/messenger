package com.bsm.rest.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.bsm.rest.messenger.model.Message;
import com.bsm.rest.messenger.resources.beans.MessageResouceBean;
import com.bsm.rest.messenger.service.MessageService;;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService msgService = MessageService.getInstance();

	@GET
	public List<Message> getAllMessages(@BeanParam MessageResouceBean bean) {
		int offset = bean.getOffset();
		int size = bean.getSize();
		if (offset >= 0 && size >= 0)
			return msgService.getMessagesPaginated(offset, size);
		else
			return msgService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		Message message = msgService.getMessage(messageId);
		message.addLink(getURI(messageId, uriInfo).toString(), "self");
		message.addLink(getURIComments(messageId, uriInfo).toString(), "comments");
		return message;
	}

	private URI getURIComments(long messageId, UriInfo uriInfo) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "comments")
				.path(CommentResource.class)
				.resolveTemplate("messageId", messageId)
				.build();
		return uri;
	}

	private URI getURI(long messageId, UriInfo uriInfo) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(messageId))
				.build();
		return uri;
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = msgService.addMessage(message);
		// return Response.status(Status.CREATED).entity(newMessage).build();
		URI uri = uriInfo.getAbsolutePathBuilder()
				.path(String.valueOf(newMessage.getId()))
				.build();
		return Response.created(uri).entity(newMessage).build();
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("id") long messageId, Message message) {
		message.setId(messageId);
		return msgService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void removeMessage(@PathParam("messageId") long messageId) {
		msgService.removeMessage(messageId);
	}

	@Path("/{messageId}/comments")
	public CommentResource comments() {
		System.out.println("messageId/comments invoked");
		return new CommentResource();
	}

}
