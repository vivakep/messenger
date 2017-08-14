package com.bsm.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bsm.rest.messenger.model.Message;
import com.bsm.rest.messenger.persistence.EntityRepo;

public class MessageService {
	private Map<Long, Message> messages = EntityRepo.getMessages();

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
		/*
		 * Message m1 = new Message(1, "hello world", "vivake"); Message m2 =
		 * new Message(2, "hello world again", "rashmie"); Message m3 = new
		 * Message(3, "hello world again and again", "pari");
		 * 
		 * List<Message> al = new ArrayList<>(); al.add(m1); al.add(m2);
		 * al.add(m3);
		 * 
		 * return al;
		 */
	}

	public Message getMessage(long l) {
		// TODO Auto-generated method stub
		return null;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long l) {
		return null;
	}

	public Message updateMessage(Message message) {
		return message;
	}

}
