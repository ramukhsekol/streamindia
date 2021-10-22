package com.lokesh.movies.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssocContent {
	public String id;
	public String type;
	public Object webUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(Object webUrl) {
		this.webUrl = webUrl;
	}
}
