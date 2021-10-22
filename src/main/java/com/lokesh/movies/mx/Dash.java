package com.lokesh.movies.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dash {
	public Object high;
	public String base;
	public Object main;

	public Object getHigh() {
		return high;
	}

	public void setHigh(Object high) {
		this.high = high;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Object getMain() {
		return main;
	}

	public void setMain(Object main) {
		this.main = main;
	}

}
