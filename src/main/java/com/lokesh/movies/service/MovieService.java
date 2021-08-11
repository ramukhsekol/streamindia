package com.lokesh.movies.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.JSONArray;

import com.lokesh.movies.domain.Languages;
import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.domain.MovieGenres;
import com.lokesh.movies.domain.Person;
import com.lokesh.movies.domain.ShowImdb;
import com.lokesh.movies.domain.TvEpisodes;
import com.lokesh.movies.dto.MovieTrailers;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface MovieService {

	public List<Movie> getAllMovies() throws UnirestException;
	public MovieTrailers getMovieDetailsByMovieId(String movieId, String type) throws UnirestException;
	public JSONArray getMoviesByIndexOrSearchOrGeneric(String pageIndex, String type, String query, String queryId, String SearchType) throws UnirestException, UnsupportedEncodingException;
	public List<MovieGenres> getMovieGenries(String movieType) throws UnirestException;
	public Person getPersonByPersonId(String personId) throws UnirestException;
	public List<Movie> getMoviesByPersonId(String queryId) throws UnirestException;
	public List<Languages> getMovieLanguages() throws UnirestException;
	public MovieTrailers getTvShowDetailsByShowId(String movieId, String type) throws UnirestException;
	public List<TvEpisodes> getTvEpisodesByShowIdAndSeasonId(String movieId, Integer season_number) throws UnirestException;
	public ShowImdb getImdbByShowId(String movieId) throws UnirestException;
	
	
	/*
	 * public String getMovieTicketByMovieIdAndTicketId(String imdb_id, String
	 * ipAddress) throws UnirestException;
	 */
	

}
