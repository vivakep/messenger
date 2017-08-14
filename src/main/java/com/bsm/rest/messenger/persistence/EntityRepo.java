package com.bsm.rest.messenger.persistence;

import java.util.HashMap;
import java.util.Map;

import com.bsm.rest.messenger.model.Message;
import com.bsm.rest.messenger.model.Profile;

public class EntityRepo {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}
}
