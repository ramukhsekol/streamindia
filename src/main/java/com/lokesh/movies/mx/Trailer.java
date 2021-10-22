package com.lokesh.movies.mx;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trailer {
	public String description;
	public String title;
	public Date releaseDate;
	public Stream stream;
	public String type;
	public int statusCode;
	public int rating;
	public Object descriptor;
	public String id;
	public List<String> languages;
	public List<LanguagesDetail> languagesDetails;
	public int duration;
	public List<String> genres;
	public List<GenresDetail> genresDetails;
	public Object secondaryGenres;
	public Object publishTime;
	public String shareUrl;
	public List<ImageInfo> imageInfo;
	public TrailerPreview trailerPreview;
	public Object trailer;
	public Object firstVideo;
	public Object container;
	public List<Object> contributors;
	public int sequence;
	public String subType;
	public List<GifVideoUrlInfo> gifVideoUrlInfo;
	public boolean canPreviewGIFVideo;
	public String webUrl;
	public boolean isOptimizedDescription;
	public Publisher publisher;
	public int childCount;
	public int videoCount;
	public Object detailKey;
	public Object inlineData;
	public Object statistics;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Stream getStream() {
		return stream;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Object getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(Object descriptor) {
		this.descriptor = descriptor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<LanguagesDetail> getLanguagesDetails() {
		return languagesDetails;
	}

	public void setLanguagesDetails(List<LanguagesDetail> languagesDetails) {
		this.languagesDetails = languagesDetails;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<GenresDetail> getGenresDetails() {
		return genresDetails;
	}

	public void setGenresDetails(List<GenresDetail> genresDetails) {
		this.genresDetails = genresDetails;
	}

	public Object getSecondaryGenres() {
		return secondaryGenres;
	}

	public void setSecondaryGenres(Object secondaryGenres) {
		this.secondaryGenres = secondaryGenres;
	}

	public Object getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Object publishTime) {
		this.publishTime = publishTime;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public List<ImageInfo> getImageInfo() {
		return imageInfo;
	}

	public void setImageInfo(List<ImageInfo> imageInfo) {
		this.imageInfo = imageInfo;
	}

	public TrailerPreview getTrailerPreview() {
		return trailerPreview;
	}

	public void setTrailerPreview(TrailerPreview trailerPreview) {
		this.trailerPreview = trailerPreview;
	}

	public Object getTrailer() {
		return trailer;
	}

	public void setTrailer(Object trailer) {
		this.trailer = trailer;
	}

	public Object getFirstVideo() {
		return firstVideo;
	}

	public void setFirstVideo(Object firstVideo) {
		this.firstVideo = firstVideo;
	}

	public Object getContainer() {
		return container;
	}

	public void setContainer(Object container) {
		this.container = container;
	}

	public List<Object> getContributors() {
		return contributors;
	}

	public void setContributors(List<Object> contributors) {
		this.contributors = contributors;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public List<GifVideoUrlInfo> getGifVideoUrlInfo() {
		return gifVideoUrlInfo;
	}

	public void setGifVideoUrlInfo(List<GifVideoUrlInfo> gifVideoUrlInfo) {
		this.gifVideoUrlInfo = gifVideoUrlInfo;
	}

	public boolean isCanPreviewGIFVideo() {
		return canPreviewGIFVideo;
	}

	public void setCanPreviewGIFVideo(boolean canPreviewGIFVideo) {
		this.canPreviewGIFVideo = canPreviewGIFVideo;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public boolean isOptimizedDescription() {
		return isOptimizedDescription;
	}

	public void setOptimizedDescription(boolean isOptimizedDescription) {
		this.isOptimizedDescription = isOptimizedDescription;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public int getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(int videoCount) {
		this.videoCount = videoCount;
	}

	public Object getDetailKey() {
		return detailKey;
	}

	public void setDetailKey(Object detailKey) {
		this.detailKey = detailKey;
	}

	public Object getInlineData() {
		return inlineData;
	}

	public void setInlineData(Object inlineData) {
		this.inlineData = inlineData;
	}

	public Object getStatistics() {
		return statistics;
	}

	public void setStatistics(Object statistics) {
		this.statistics = statistics;
	}

}
