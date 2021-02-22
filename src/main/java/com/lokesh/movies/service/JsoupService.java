package com.lokesh.movies.service;

import java.util.List;

import com.lokesh.movies.domain.Movie;

public interface JsoupService {

	List<Movie> getJsoupMoviesByIndex(String movieType, String pageIndex);
	Movie getMovieDetailsByMovieId(String movieId);
	List<Movie> getAllJsoupMoviesByIndex(String movieUrl, String pageIndex);
	Movie getParticularMovieDetailsByMovieId(String movieId);
	List<Movie> getAllJsoupPornMoviesByIndex(String pageIndex);
	Movie getParticularPornMovieDetailsByMovieLink(String movieLink);
	List<Movie> getAllJsoupPornFullMoviesByIndex();
	boolean generateJsonFile(List<Movie> movies);
	List<Movie> getAllJsoupPornJsonMoviesByIndex();

}
