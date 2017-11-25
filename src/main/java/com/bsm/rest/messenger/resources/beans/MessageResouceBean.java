package com.bsm.rest.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageResouceBean {
	@QueryParam("year")
	int year;
	@QueryParam("offset")
	int offset;
	@QueryParam("size")
	int size;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
