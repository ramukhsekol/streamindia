package com.lokesh.movies.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mxplay {
	public Dash dash;
	public Hls hls;
	public String contentId;
	public Object validUntil;
	public int offsetTime;
	public boolean dvr;

	public Dash getDash() {
		return dash;
	}

	public void setDash(Dash dash) {
		this.dash = dash;
	}

	public Hls getHls() {
		return hls;
	}

	public void setHls(Hls hls) {
		this.hls = hls;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public Object getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Object validUntil) {
		this.validUntil = validUntil;
	}

	public int getOffsetTime() {
		return offsetTime;
	}

	public void setOffsetTime(int offsetTime) {
		this.offsetTime = offsetTime;
	}

	public boolean isDvr() {
		return dvr;
	}

	public void setDvr(boolean dvr) {
		this.dvr = dvr;
	}

}
