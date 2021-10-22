package com.lokesh.movies.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistics {
	public int streamCount;
	public String streamCountDisplayText;

	public int getStreamCount() {
		return streamCount;
	}

	public void setStreamCount(int streamCount) {
		this.streamCount = streamCount;
	}

	public String getStreamCountDisplayText() {
		return streamCountDisplayText;
	}

	public void setStreamCountDisplayText(String streamCountDisplayText) {
		this.streamCountDisplayText = streamCountDisplayText;
	}

}
