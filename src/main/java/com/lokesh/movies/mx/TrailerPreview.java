package com.lokesh.movies.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class TrailerPreview {
	public Object fullScreenBgImage;
	public Object logoImage;
	public Object fullScreenBgImageInfo;
	public Object logoImageInfo;
	public AssocContent assocContent;

	public Object getFullScreenBgImage() {
		return fullScreenBgImage;
	}

	public void setFullScreenBgImage(Object fullScreenBgImage) {
		this.fullScreenBgImage = fullScreenBgImage;
	}

	public Object getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(Object logoImage) {
		this.logoImage = logoImage;
	}

	public Object getFullScreenBgImageInfo() {
		return fullScreenBgImageInfo;
	}

	public void setFullScreenBgImageInfo(Object fullScreenBgImageInfo) {
		this.fullScreenBgImageInfo = fullScreenBgImageInfo;
	}

	public Object getLogoImageInfo() {
		return logoImageInfo;
	}

	public void setLogoImageInfo(Object logoImageInfo) {
		this.logoImageInfo = logoImageInfo;
	}

	public AssocContent getAssocContent() {
		return assocContent;
	}

	public void setAssocContent(AssocContent assocContent) {
		this.assocContent = assocContent;
	}

}
