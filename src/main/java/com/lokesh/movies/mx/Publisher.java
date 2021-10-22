package com.lokesh.movies.mx;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Publisher {
	public List<ImageInfo> imageInfo;
	public String name;
	public int videoCount;
	public int subscriptionsCount;
	public String id;
	public Object webUrl;

	public List<ImageInfo> getImageInfo() {
		return imageInfo;
	}

	public void setImageInfo(List<ImageInfo> imageInfo) {
		this.imageInfo = imageInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(int videoCount) {
		this.videoCount = videoCount;
	}

	public int getSubscriptionsCount() {
		return subscriptionsCount;
	}

	public void setSubscriptionsCount(int subscriptionsCount) {
		this.subscriptionsCount = subscriptionsCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(Object webUrl) {
		this.webUrl = webUrl;
	}

}