package com.lokesh.movies.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Download {
	public Object expiryDate;
	public boolean requireLoginToDownload;
	public boolean isEligibleForDownload;

	public Object getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Object expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isRequireLoginToDownload() {
		return requireLoginToDownload;
	}

	public void setRequireLoginToDownload(boolean requireLoginToDownload) {
		this.requireLoginToDownload = requireLoginToDownload;
	}

	public boolean isEligibleForDownload() {
		return isEligibleForDownload;
	}

	public void setEligibleForDownload(boolean isEligibleForDownload) {
		this.isEligibleForDownload = isEligibleForDownload;
	}

}