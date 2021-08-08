package com.lokesh.movies.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvEpisodes {
	private String air_date;
	private Integer episode_number;
	private String name;

	public String getAir_date() {
		return air_date;
	}

	public void setAir_date(String air_date) {
		this.air_date = air_date;
	}

	public Integer getEpisode_number() {
		return episode_number;
	}

	public void setEpisode_number(Integer episode_number) {
		this.episode_number = episode_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
