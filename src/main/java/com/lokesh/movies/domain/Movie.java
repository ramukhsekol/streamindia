package com.lokesh.movies.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3545531840211939986L;
	private boolean adult;
	private String backdrop_path;
	private Long id;
	private String original_language;
	private String original_title;
	private String overview;
	private String popularity;
	private String poster_path;
	private String release_date;
	private String title;
	private boolean video;
	private Double vote_average;
	private Long vote_count;
	private List<Long> genre_ids;
	private String genrics;
	private Integer runtime;
	private List<MovieGenres> genres;
	private String imdb_id;
	private String convertRunTime;
	private String movieLink;
	private String movieLink2;
	private String movieLink3;
	private String movieLink4;
	private String movieLink5;

	private String staring;
	private String country;
	private String language;
	private String director;
	private String producer;
	private String writer;
	private String voteAverage;
	private String timming;
	private String media_type;
	private String name;
	private Integer media_id;
	private Integer totalMoviesPerPageIndex;

	public Movie() {
		super();
	}

	public Movie(String poster_path, String title, Double vote_average, String movieLink) {
		super();
		this.poster_path = poster_path;
		this.title = title;
		this.vote_average = vote_average;
		this.movieLink = movieLink;
	}

	public Movie(String poster_path, String title, Double vote_average, String movieLink, String timming) {
		super();
		this.poster_path = poster_path;
		this.title = title;
		this.vote_average = vote_average;
		this.movieLink = movieLink;
		this.timming = timming;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public Double getVote_average() {
		return vote_average;
	}

	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}

	public Long getVote_count() {
		return vote_count;
	}

	public void setVote_count(Long vote_count) {
		this.vote_count = vote_count;
	}

	public List<Long> getGenre_ids() {
		return genre_ids;
	}

	public void setGenre_ids(List<Long> genre_ids) {
		this.genre_ids = genre_ids;
	}

	public String getGenrics() {
		return genrics;
	}

	public void setGenrics(String genrics) {
		this.genrics = genrics;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public List<MovieGenres> getGenres() {
		return genres;
	}

	public void setGenres(List<MovieGenres> genres) {
		this.genres = genres;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
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

	public String getStaring() {
		return staring;
	}

	public void setStaring(String staring) {
		this.staring = staring;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(String voteAverage) {
		this.voteAverage = voteAverage;
	}

	public String getMovieLink2() {
		return movieLink2;
	}

	public void setMovieLink2(String movieLink2) {
		this.movieLink2 = movieLink2;
	}

	public String getTimming() {
		return timming;
	}

	public void setTimming(String timming) {
		this.timming = timming;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMedia_id() {
		return media_id;
	}

	public void setMedia_id(Integer media_id) {
		this.media_id = media_id;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Integer getTotalMoviesPerPageIndex() {
		return totalMoviesPerPageIndex;
	}

	public void setTotalMoviesPerPageIndex(Integer totalMoviesPerPageIndex) {
		this.totalMoviesPerPageIndex = totalMoviesPerPageIndex;
	}

	public String getMovieLink3() {
		return movieLink3;
	}

	public void setMovieLink3(String movieLink3) {
		this.movieLink3 = movieLink3;
	}

	public String getMovieLink4() {
		return movieLink4;
	}

	public void setMovieLink4(String movieLink4) {
		this.movieLink4 = movieLink4;
	}

	public String getMovieLink5() {
		return movieLink5;
	}

	public void setMovieLink5(String movieLink5) {
		this.movieLink5 = movieLink5;
	}

}
