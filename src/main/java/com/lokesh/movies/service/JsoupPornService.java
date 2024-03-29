package com.lokesh.movies.service;

import java.util.List;

import com.lokesh.movies.domain.Movie;

public interface JsoupPornService {
	
	List<Movie> getAllTypeJsoupPornMoviesByIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag);
	Movie getParticularPornMovieDetailsByMovieLink(String movieLink, String type);
	List<Movie> getFamousStars(Integer startIndex, Integer endIndex, boolean isFlag);
	List<Movie> pornModelsByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag);
	List<Movie> pornModelMoviesByMovieLink(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag);
	List<Movie> pornStarsByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag);
	List<Movie> pornStarMoviesByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag);
	List<Movie> trendingStarsByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag, String className);
	List<Movie> trendingStarMoviesByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag);
	List<Movie> categoriesByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag);
	List<Movie> categoryMoviesByPageIndex(String movieLink, Integer startIndex, Integer endIndex, boolean isFlag);

}
