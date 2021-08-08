package com.lokesh.movies.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvSeasons {
	private String air_date;
	private Integer episode_count;
	private Long id;
	private String name;
	private Integer season_number;

	public String getAir_date() {
		return air_date;
	}

	public void setAir_date(String air_date) {
		this.air_date = air_date;
	}

	public Integer getEpisode_count() {
		return episode_count;
	}

	public void setEpisode_count(Integer episode_count) {
		this.episode_count = episode_count;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeason_number() {
		return season_number;
	}

	public void setSeason_number(Integer season_number) {
		this.season_number = season_number;
	}
}
