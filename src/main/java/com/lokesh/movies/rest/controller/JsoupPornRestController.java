package com.lokesh.movies.rest.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.domain.Person;
import com.lokesh.movies.service.JsoupService;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping("/api")
public class JsoupPornRestController {
	
	@Autowired private JsoupService jsoupService;
	
	@GetMapping(value = "/porn/all")
	public ResponseEntity<List<Movie>> pornByIndex(@RequestParam String pageIndex) throws UnirestException, UnsupportedEncodingException {
		String movieLink = "https://pornmate.com/video/page/" + pageIndex;
		List<Movie>  movies = jsoupService.getAllJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/porn/movies/all")
	public ResponseEntity<List<Movie>> pornMoviesByIndex() throws UnirestException, UnsupportedEncodingException {
		List<Movie> movies = jsoupService.getAllJsoupPornJsonMoviesByIndex();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/porn/stars/all")
	public ResponseEntity<List<Person>> pornStarsByIndex(@RequestParam String pageIndex) throws UnirestException, UnsupportedEncodingException {
		if(StringUtils.hasText(pageIndex) && Integer.parseInt(pageIndex) <= 3) {
			List<Person> persons = jsoupService.getPornStarsByIndex(pageIndex);
			return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
		} else {
			List<Person> persons = new ArrayList<>();
			return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/person/porn")
	public ResponseEntity<List<Movie>> pornStarMovies(@RequestParam String personLink) throws UnirestException, UnsupportedEncodingException {
		String movieLink = "https://pornmate.com/star/" + personLink;
		List<Movie> movies  = jsoupService.getAllJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/porn/movie")
	public ResponseEntity<Movie> pornMovie(@RequestParam String movieLink) throws UnirestException, UnsupportedEncodingException {
		Movie movie = jsoupService.getParticularPornMovieDetailsByMovieLink(movieLink);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
}
