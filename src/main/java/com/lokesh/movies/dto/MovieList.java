package com.lokesh.movies.dto;

import java.util.List;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.domain.MovieGenres;

public class MovieList {

	private List<Movie> romances;
	private List<Movie> famouses;
	private List<Movie> bangs;
	private List<Movie> kings;
	private List<Movie> vixens;
	private List<Movie> pornModels;
	private List<Movie> pornStars;

	private List<Movie> nowPlayings;
	private List<Movie> popularMovies;
	private List<Movie> popularShows;
	private List<MovieGenres> movieGenres;

	public List<MovieGenres> getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(List<MovieGenres> movieGenres) {
		this.movieGenres = movieGenres;
	}

	public List<Movie> getPopularShows() {
		return popularShows;
	}

	public void setPopularShows(List<Movie> popularShows) {
		this.popularShows = popularShows;
	}

	public List<Movie> getNowPlayings() {
		return nowPlayings;
	}

	public void setNowPlayings(List<Movie> nowPlayings) {
		this.nowPlayings = nowPlayings;
	}

	public List<Movie> getPopularMovies() {
		return popularMovies;
	}

	public void setPopularMovies(List<Movie> popularMovies) {
		this.popularMovies = popularMovies;
	}

	public List<Movie> getRomances() {
		return romances;
	}

	public void setRomances(List<Movie> romances) {
		this.romances = romances;
	}

	public List<Movie> getFamouses() {
		return famouses;
	}

	public void setFamouses(List<Movie> famouses) {
		this.famouses = famouses;
	}

	public List<Movie> getBangs() {
		return bangs;
	}

	public void setBangs(List<Movie> bangs) {
		this.bangs = bangs;
	}

	public List<Movie> getKings() {
		return kings;
	}

	public void setKings(List<Movie> kings) {
		this.kings = kings;
	}

	public List<Movie> getVixens() {
		return vixens;
	}

	public void setVixens(List<Movie> vixens) {
		this.vixens = vixens;
	}

	public List<Movie> getPornModels() {
		return pornModels;
	}

	public void setPornModels(List<Movie> pornModels) {
		this.pornModels = pornModels;
	}

	public List<Movie> getPornStars() {
		return pornStars;
	}

	public void setPornStars(List<Movie> pornStars) {
		this.pornStars = pornStars;
	}
}
