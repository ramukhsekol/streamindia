package com.lokesh.movies.rest.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.domain.Person;
import com.lokesh.movies.dto.MovieTrailers;
import com.lokesh.movies.service.MovieService;
import com.lokesh.movies.util.MovieUtil;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieRestController {

	@Autowired
	private MovieService movieService;

	@GetMapping(value = "/movies/all")
	public ResponseEntity<Object> moviesByIndex(@RequestParam String pageIndex, @RequestParam String type,
			@RequestParam String query, @RequestParam String queryId, @RequestParam String searchType)
			throws UnirestException, UnsupportedEncodingException {
		if (searchType.equalsIgnoreCase("movie") && type.equalsIgnoreCase("personMovies")
				&& pageIndex.equalsIgnoreCase("1")) {
			List<Movie> movies = movieService.getMoviesByPersonId(queryId);
			return new ResponseEntity<Object>(movies, HttpStatus.OK);
		} else if (!type.equalsIgnoreCase("personMovies")) {
			JSONArray jsonArray = movieService.getMoviesByIndexOrSearchOrGeneric(pageIndex, type, query, queryId,
					searchType);
			Gson gson = new Gson();
			if (jsonArray != null) {
				if (searchType.equalsIgnoreCase("movie") && !type.equalsIgnoreCase("personMovies")) {
					Type responseType = new TypeToken<List<Movie>>() {
					}.getType();
					List<Movie> movies = gson.fromJson(jsonArray.toString(), responseType);
					return new ResponseEntity<Object>(movies, HttpStatus.OK);
				} else {
					Type responseType = new TypeToken<List<Person>>() {
					}.getType();
					List<Person> persons = gson.fromJson(jsonArray.toString(), responseType);
					return new ResponseEntity<Object>(persons, HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<Object>("Something went wrong, Please try again", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/movie/details")
	public ResponseEntity<Object> showMovie(@RequestParam String movieId, @RequestParam String ipAddress, Model model)
			throws UnirestException, UnsupportedEncodingException {
		MovieTrailers movie = movieService.getMovieDetailsByMovieId(movieId, "show");
		if (movie != null && movie.getMovie() != null && movie.getMovie().getRuntime() != null) {
			movie.getMovie().setConvertRunTime(MovieUtil.convertMovieTiming(movie.getMovie().getRuntime()));
		}
		String movieTicket = movieService.getMovieTicketByMovieIdAndTicketId(movie.getMovie().getImdb_id(), ipAddress);
		if (StringUtils.hasText(movieTicket)) {
			movie.getMovie().setMovieLink("https://videospider.stream/getvideo?key=" + MovieUtil.userKey + "&video_id="
					+ movie.getMovie().getImdb_id() + "&ticket=" + movieTicket);
		} else {
			movie.getMovie().setMovieLink("https://streamvideo.link/getvideo?key=" + MovieUtil.userKey + "&video_id="
					+ movie.getMovie().getImdb_id());
		}
		return new ResponseEntity<Object>(movie, HttpStatus.OK);
	}

}
