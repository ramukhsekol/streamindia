package com.lokesh.movies.rest.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.dto.OtherMovie;
import com.lokesh.movies.service.JsoupService;
import com.lokesh.movies.util.MovieUtil;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping("/api")
public class JsoupRestController {
	
@Autowired private JsoupService jsoupService;
	
	@GetMapping(value = "/others")
	public ResponseEntity<Map<Integer, String>> others(Model model) throws UnirestException {
		Map<Integer, String> movieCountries = MovieUtil.getmovieLanguages();
		movieCountries = movieCountries.entrySet().stream().filter(data -> data.getKey() < 8).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return new ResponseEntity<Map<Integer, String>>(movieCountries, HttpStatus.OK);
	}
	
	@GetMapping(value = "/dubbed")
	public ResponseEntity<Map<Integer, String>> dubbed(Model model) throws UnirestException {
		Map<Integer, String> movieCountries = MovieUtil.getmovieLanguages();
		movieCountries = movieCountries.entrySet().stream().filter(data -> data.getKey() > 8).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return new ResponseEntity<Map<Integer, String>>(movieCountries, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{movieType}/movies/all")
	public ResponseEntity<OtherMovie> teluguMoviesByIndex(@PathVariable Integer movieType, @RequestParam String pageIndex, Model model) throws UnirestException, UnsupportedEncodingException {
		String language = MovieUtil.getMovieLanguage(movieType);
		OtherMovie  otherMovies = new OtherMovie();
		if(movieType <= 5 || (movieType >= 8 && movieType <= 11)) {
			String movieUrl =  "language/" + language.toLowerCase() ;
			if(movieType >= 9 && movieType <= 11) {
				movieUrl =  movieUrl + "/dubbed"; 
			} else if(movieType == 8) {
				movieUrl =  "rating/18"; 
			}
			List<Movie> movies = jsoupService.getAllJsoupMoviesByIndex(movieUrl, pageIndex);
			otherMovies = new OtherMovie(movies, true);
		}  else if(movieType >= 6 && movieType <= 7) {
			String movieUrl = "language/" + language.toLowerCase();
			List<Movie> movies = jsoupService.getJsoupMoviesByIndex(movieUrl, pageIndex);
			otherMovies = new OtherMovie(movies, false);
		}
		return new ResponseEntity<OtherMovie>(otherMovies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/other/movie")
	public ResponseEntity<Movie> showMovie(@RequestParam String movieId, @RequestParam boolean status, Model model) throws UnirestException, UnsupportedEncodingException {
		Movie movie = new Movie();
		if(status) {
			movie = jsoupService.getParticularMovieDetailsByMovieId(movieId);
		} else {
			movie = jsoupService.getMovieDetailsByMovieId(movieId);
		}
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
}
