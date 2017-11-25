package com.bsm.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bsm.rest.messenger.exception.DataNotFoundException;
import com.bsm.rest.messenger.model.Message;
import com.bsm.rest.messenger.persistence.EntityRepo;

public class MessageService {
	private Map<Long, Message> messages;
	private static MessageService service;

	public static MessageService getInstance() {
		service = service == null ? new MessageService() : service;
		return service;
	}

	private MessageService() {
		System.out.println("MessageService constructor called!");
		messages = EntityRepo.getMessages();
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}

	public List<Message> getMessagesPaginated(int start, int size) {
		ArrayList<Message> al = new ArrayList<>(messages.values());
		if ((start + size) > al.size())
			return al;
		return al.subList(start, start + size);
	}

	public Message getMessage(long id) {
		Message message = messages.get(id);
		if (message == null)
			throw new DataNotFoundException("Message with id: " + id + " not found");
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

	public Message updateMessage(Message message) {
		Message orig = messages.get(message.getId());
		if (message.getAuthor() != null)
			orig.setAuthor(message.getAuthor());
		if (message.getCreated() != null)
			orig.setCreated(message.getCreated());
		if (message.getMessage() != null)
			orig.setMessage(message.getMessage());
		// messages.put(message.getId(), message);
		return orig;
	}

}
