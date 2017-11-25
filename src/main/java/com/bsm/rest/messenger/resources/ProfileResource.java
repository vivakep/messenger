package com.bsm.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bsm.rest.messenger.model.Profile;
import com.bsm.rest.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService profiles = ProfileService.getInstance();

	@GET
	public List<Profile> getProfiles() {
		return profiles.getAllProfile();
	}

	@GET
	@Path("{id}")
	public Profile getProfile(@PathParam("id") long id) {
		return profiles.getProfile(id);
	}

	@POST
	public Profile addProfile(Profile profile) {
		return profiles.addProfile(profile);
	}
}
