package com.lokesh.movies.dto;

import java.util.List;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.domain.MovieCastCrew;
import com.lokesh.movies.domain.Trailer;
import com.lokesh.movies.domain.TvEpisodes;
import com.lokesh.movies.domain.TvSeasons;
import com.lokesh.movies.domain.TvShows;

public class MovieTrailers {

	private Movie movie;
	private List<Trailer> trailers;
	private List<MovieCastCrew> casts;
	private List<MovieCastCrew> crews;
	private TvShows tvShows;
	private String imdbId;
	private List<TvSeasons> tvSeasons;
	private List<TvEpisodes> tvEpisodes;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Trailer> getTrailers() {
		return trailers;
	}

	public void setTrailers(List<Trailer> trailers) {
		this.trailers = trailers;
	}

	public List<MovieCastCrew> getCasts() {
		return casts;
	}

	public void setCasts(List<MovieCastCrew> casts) {
		this.casts = casts;
	}

	public List<MovieCastCrew> getCrews() {
		return crews;
	}

	public void setCrews(List<MovieCastCrew> crews) {
		this.crews = crews;
	}

	public TvShows getTvShows() {
		return tvShows;
	}

	public void setTvShows(TvShows tvShows) {
		this.tvShows = tvShows;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public List<TvSeasons> getTvSeasons() {
		return tvSeasons;
	}

	public void setTvSeasons(List<TvSeasons> tvSeasons) {
		this.tvSeasons = tvSeasons;
	}

	public List<TvEpisodes> getTvEpisodes() {
		return tvEpisodes;
	}

	public void setTvEpisodes(List<TvEpisodes> tvEpisodes) {
		this.tvEpisodes = tvEpisodes;
	}

}
