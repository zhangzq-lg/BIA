package com.lg.zzq.bia.entity;

import java.util.Set;

public class ClassCode {

	private String id;
	private String name;
	private Set<TextCode> textCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<TextCode> getTextCode() {
		return textCode;
	}

	public void setTextCode(Set<TextCode> textCode) {
		this.textCode = textCode;
	}

}
