package net.apptao.highway.server.auth;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Cached;

import net.apptao.highway.server.data.PropertyBag;

@Cached
public class HwyUser extends PropertyBag {
	
	@Id 
	private Long id;

	public Long getId() {
		return id;
	}
}
