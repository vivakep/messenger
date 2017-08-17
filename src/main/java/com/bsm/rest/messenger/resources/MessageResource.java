package com.bsm.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bsm.rest.messenger.model.Message;
import com.bsm.rest.messenger.service.MessageService;;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
public class MessageResource {
	MessageService msgService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessages() {
		return msgService.getAllMessages();
	}

	public Message getMessage(long l) {
		return msgService.getMessage(l);
	}
}
