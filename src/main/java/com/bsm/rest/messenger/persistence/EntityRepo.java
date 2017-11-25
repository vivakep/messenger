package com.bsm.rest.messenger.persistence;

import java.util.HashMap;
import java.util.Map;

import com.bsm.rest.messenger.model.Message;
import com.bsm.rest.messenger.model.Profile;

public class EntityRepo {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		messages.put(1L, new Message(1L, "hello world", "vivake"));
		messages.put(2L, new Message(2L, "hello world again", "rashmie"));
		messages.put(3L, new Message(3L, "hello world again and again", "pari"));
		messages.put(4L, new Message(4L, "hello world poo you!", "TQ"));
		return messages;
	}

	public static Map<Long, Profile> getProfiles() {
		profiles.put(1L, new Profile(1L, "vivake", "panagaria", "tonu"));
		profiles.put(2L, new Profile(2L, "rashmie", "panagaria", "shalu"));
		profiles.put(3L, new Profile(3L, "parinita", "jain", "pari"));
		profiles.put(4L, new Profile(4L, "marisha", "jain", "tia"));
		return profiles;
	}
}
