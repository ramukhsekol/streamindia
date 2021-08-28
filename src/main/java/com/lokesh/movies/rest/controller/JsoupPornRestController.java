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
	
	@GetMapping(value = "/romanceMoviesByPageIndex")
	public ResponseEntity<List<Movie>> romancePornByIndex(@RequestParam String pageIndex) throws UnirestException, UnsupportedEncodingException {
		String movieLink = "https://yespornpleasexxx.com/brazzers-2/page/" + pageIndex + "/";
		List<Movie> movies = jsoupService.getAllRomanceJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/bangMoviesByPageIndex")
	public ResponseEntity<List<Movie>> bangMoviesByPageIndex(@RequestParam String pageIndex) throws UnirestException, UnsupportedEncodingException {
		String movieLink = "https://yespornpleasexxx.com/bangbros-3/page/" + pageIndex + "/";
		List<Movie> movies = jsoupService.getAllRomanceJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/kingsMoviesByPageIndex")
	public ResponseEntity<List<Movie>> kingsMoviesByPageIndex(@RequestParam String pageIndex) throws UnirestException, UnsupportedEncodingException {
		String movieLink = "https://yespornpleasexxx.com/reality-kings-2/page/" + pageIndex + "/";
		List<Movie> movies = jsoupService.getAllRomanceJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/vixenMoviesByPageIndex")
	public ResponseEntity<List<Movie>> vixenMoviesByPageIndex(@RequestParam String pageIndex) throws UnirestException, UnsupportedEncodingException {
		String movieLink = "https://yespornpleasexxx.com/vixen/page/" + pageIndex + "/";
		List<Movie> movies = jsoupService.getAllRomanceJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getRomanceMovieByMovieLink")
	public ResponseEntity<Movie> getRomanceMovieByMovieLink(@RequestParam String movieLink) throws UnirestException, UnsupportedEncodingException {
		Movie movie = jsoupService.getParticularPornMovieDetailsByMovieLink(movieLink, "romance");
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getFamousStars")
	public ResponseEntity<List<Movie>> getFamousStars() throws UnirestException, UnsupportedEncodingException {
		List<Movie> movies = jsoupService.getFamousStars();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/famousMoviesByPageIndex")
	public ResponseEntity<List<Movie>> romancePornByIndex(@RequestParam String movieLink, @RequestParam String pageIndex) throws UnirestException, UnsupportedEncodingException {
		movieLink = movieLink + "/page/" + pageIndex + "/";
		List<Movie> movies = jsoupService.getAllRomanceJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pornModelsByPageIndex")
	public ResponseEntity<List<Movie>> pornModelsByPageIndex(@RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) throws UnirestException, UnsupportedEncodingException {
		String movieLink = "https://www.xozilla.com/models/" + pageIndex + "/";
		List<Movie> movies = jsoupService.pornModelsByPageIndex(movieLink, startIndex, endIndex);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pornModelMovies")
	public ResponseEntity<List<Movie>> pornModelMovies(@RequestParam String movieLink, @RequestParam Integer startIndex, @RequestParam Integer endIndex) throws UnirestException {
		List<Movie> movies = jsoupService.pornModelMoviesByMovieLink(movieLink, startIndex, endIndex);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(value = "/romance/porn/all")
	public ResponseEntity<List<Movie>> romancePorn(@RequestParam String pageIndex) throws UnirestException, UnsupportedEncodingException {
		String movieLink = "https://yespornpleasexxx.com/brazzers-2/page/" + pageIndex + "/";
		List<Movie> movies = jsoupService.getAllRomanceJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
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
	public ResponseEntity<Movie> pornMovie(@RequestParam String movieLink, @RequestParam String type) throws UnirestException, UnsupportedEncodingException {
		Movie movie = jsoupService.getParticularPornMovieDetailsByMovieLink(movieLink, type);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
}
