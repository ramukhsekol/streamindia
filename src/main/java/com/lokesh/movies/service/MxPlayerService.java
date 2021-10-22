package com.lokesh.movies.service;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface MxPlayerService {

	JSONArray getMoviesByIndexAndType(Integer pageIndex, String type) throws UnirestException;
	JSONObject getMoviesById(String movieId) throws UnirestException;

}
