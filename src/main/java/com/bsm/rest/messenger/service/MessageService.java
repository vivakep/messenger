package com.bsm.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bsm.rest.messenger.model.Message;
import com.bsm.rest.messenger.persistence.EntityRepo;

public class MessageService {
	private Map<Long, Message> messages;

	public MessageService() {
		System.out.println("MessageService constructor called!");
		messages = EntityRepo.getMessages();
		messages.put(1L, new Message(1L, "hello world", "vivake"));
		messages.put(2L, new Message(2L, "hello world again", "rashmie"));
		messages.put(3L, new Message(3L, "hello world again and again", "pari"));
		messages.put(4L, new Message(4L, "hello world poo you!", "TQ"));

	}

	public List<Message> getAllMessages() {
		/*
		 * System.out.println("get messages called"); ArrayList<Message> al = new
		 * ArrayList<>(); al.addAll(messages.values()); return al;
		 */ return new ArrayList<>(messages.values());
	}

	public Message getMessage(long id) {
		// TODO Auto-generated method stub
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.get(id);
	}

	public Message updateMessage(Message message) {
		messages.put(message.getId(), message);
		return message;
	}

}
