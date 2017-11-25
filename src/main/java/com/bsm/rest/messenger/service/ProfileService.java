package com.bsm.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bsm.rest.messenger.model.Profile;
import com.bsm.rest.messenger.persistence.EntityRepo;

public class ProfileService {
	private Map<Long, Profile> profiles;
	private static ProfileService service;

	public static ProfileService getInstance() {
		service = service == null ? new ProfileService() : service;
		return service;
	}

	private ProfileService() {
		System.out.println("MessageService constructor called!");
		profiles = EntityRepo.getProfiles();

	}

	public List<Profile> getAllProfile() {
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(long id) {
		return profiles.get(id);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getId(), profile);
		return profile;
	}

	public Profile removeProfile(long id) {
		return profiles.remove(id);
	}

	public Profile updateProfile(Profile profile) {
		Profile orig = profiles.get(profile.getId());
		if (profile.getFirstName() != null)
			orig.setFirstName(profile.getFirstName());
		if (profile.getLastName() != null)
			orig.setLastName(profile.getLastName());
		if (profile.getProfileName() != null)
			orig.setProfileName(profile.getProfileName());
		return orig;
	}
}
