package com.lokesh.movies.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvShows {

	private String backdrop_path;
	private List<Integer> episode_run_time;
	private String first_air_date;
	private List<MovieGenres> genres;
	private Long id;
	private String last_air_date;
	private String name;
	private String original_language;
	private String original_title;
	private String overview;
	private String popularity;
	private String poster_path;
	private Integer number_of_seasons;
	private List<TvSeasons> seasons;
	private Double vote_average;
	private String genrics;
	private String convertRunTime;

	private String movieLink;
	private String movieLink2;

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public List<Integer> getEpisode_run_time() {
		return episode_run_time;
	}

	public void setEpisode_run_time(List<Integer> episode_run_time) {
		this.episode_run_time = episode_run_time;
	}

	public String getFirst_air_date() {
		return first_air_date;
	}

	public void setFirst_air_date(String first_air_date) {
		this.first_air_date = first_air_date;
	}

	public List<MovieGenres> getGenres() {
		return genres;
	}

	public void setGenres(List<MovieGenres> genres) {
		this.genres = genres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLast_air_date() {
		return last_air_date;
	}

	public void setLast_air_date(String last_air_date) {
		this.last_air_date = last_air_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginal_language() {
		return original_language;
	}

	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public Integer getNumber_of_seasons() {
		return number_of_seasons;
	}

	public void setNumber_of_seasons(Integer number_of_seasons) {
		this.number_of_seasons = number_of_seasons;
	}

	public String getGenrics() {
		return genrics;
	}

	public void setGenrics(String genrics) {
		this.genrics = genrics;
	}

	public List<TvSeasons> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<TvSeasons> seasons) {
		this.seasons = seasons;
	}

	public Double getVote_average() {
		return vote_average;
	}

	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}

	public String getConvertRunTime() {
		return convertRunTime;
	}

	public void setConvertRunTime(String convertRunTime) {
		this.convertRunTime = convertRunTime;
	}

	public String getMovieLink() {
		return movieLink;
	}

	public void setMovieLink(String movieLink) {
		this.movieLink = movieLink;
	}

	public String getMovieLink2() {
		return movieLink2;
	}

	public void setMovieLink2(String movieLink2) {
		this.movieLink2 = movieLink2;
	}

}
