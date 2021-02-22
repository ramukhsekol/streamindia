package com.lokesh.movies.rest.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.service.JsoupService;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping("/api")
public class JsoupPornRestController {
	
	@Autowired private JsoupService jsoupService;
	
	@GetMapping(value = "/porn/all")
	public ResponseEntity<List<Movie>> pornByIndex(@RequestParam String pageIndex, Model model) throws UnirestException, UnsupportedEncodingException {
		List<Movie> movies = jsoupService.getAllJsoupPornMoviesByIndex(pageIndex);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/porn/movies/all")
	public ResponseEntity<List<Movie>> pornMoviesByIndex(Model model) throws UnirestException, UnsupportedEncodingException {
		List<Movie> movies = jsoupService.getAllJsoupPornJsonMoviesByIndex();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/porn/movie")
	public ResponseEntity<Movie> pornMovie(@RequestParam String movieLink, Model model) throws UnirestException, UnsupportedEncodingException {
		Movie movie = jsoupService.getParticularPornMovieDetailsByMovieLink(movieLink);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
}
