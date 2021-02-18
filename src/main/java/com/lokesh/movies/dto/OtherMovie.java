package com.lokesh.movies.dto;

import java.util.List;

import com.lokesh.movies.domain.Movie;

public class OtherMovie {

	private List<Movie> movies;
	private boolean enabled;

	public OtherMovie() {
		super();
	}

	public OtherMovie(List<Movie> movies, boolean enabled) {
		super();
		this.movies = movies;
		this.enabled = enabled;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
