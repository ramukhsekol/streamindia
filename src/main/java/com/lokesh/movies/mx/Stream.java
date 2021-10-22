package com.lokesh.movies.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stream {
	public String provider;
	public Dash dash;
	public Hls hls;
	public boolean drmProtect;
	public Mxplay mxplay;
	public Object youtube;
	public Object sony;
	public Object altBalaji;
	public Object thirdParty;
	public String videoHash;
	public String adTagProvider;
	public Download download;
	public Object watermark;
	public String aspectRatio;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

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

	public boolean isDrmProtect() {
		return drmProtect;
	}

	public void setDrmProtect(boolean drmProtect) {
		this.drmProtect = drmProtect;
	}

	public Mxplay getMxplay() {
		return mxplay;
	}

	public void setMxplay(Mxplay mxplay) {
		this.mxplay = mxplay;
	}

	public Object getYoutube() {
		return youtube;
	}

	public void setYoutube(Object youtube) {
		this.youtube = youtube;
	}

	public Object getSony() {
		return sony;
	}

	public void setSony(Object sony) {
		this.sony = sony;
	}

	public Object getAltBalaji() {
		return altBalaji;
	}

	public void setAltBalaji(Object altBalaji) {
		this.altBalaji = altBalaji;
	}

	public Object getThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(Object thirdParty) {
		this.thirdParty = thirdParty;
	}

	public String getVideoHash() {
		return videoHash;
	}

	public void setVideoHash(String videoHash) {
		this.videoHash = videoHash;
	}

	public String getAdTagProvider() {
		return adTagProvider;
	}

	public void setAdTagProvider(String adTagProvider) {
		this.adTagProvider = adTagProvider;
	}

	public Download getDownload() {
		return download;
	}

	public void setDownload(Download download) {
		this.download = download;
	}

	public Object getWatermark() {
		return watermark;
	}

	public void setWatermark(Object watermark) {
		this.watermark = watermark;
	}

	public String getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

}
