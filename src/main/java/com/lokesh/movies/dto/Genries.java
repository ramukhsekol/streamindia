package com.lokesh.movies.dto;

import java.util.List;

import com.lokesh.movies.domain.MovieGenres;

public class Genries {
	List<MovieGenres> movieGenres;
	List<MovieGenres> tvGenres;
	public List<MovieGenres> getMovieGenres() {
		return movieGenres;
	}
	public void setMovieGenres(List<MovieGenres> movieGenres) {
		this.movieGenres = movieGenres;
	}
	public List<MovieGenres> getTvGenres() {
		return tvGenres;
	}
	public void setTvGenres(List<MovieGenres> tvGenres) {
		this.tvGenres = tvGenres;
	}
	
	

}
