package com.lokesh.movies.dto;

public class SeasonEpisode {
	private Integer seasonNumber;
	private Integer episodeNumber;

	public SeasonEpisode() {
		super();
	}

	public SeasonEpisode(Integer seasonNumber, Integer episodeNumber) {
		super();
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
	}

	public Integer getSeasonNumber() {
		return seasonNumber;
	}

	public void setSeasonNumber(Integer seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	public Integer getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(Integer episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

}
