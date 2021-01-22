package com.lokesh.movies.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.service.JsoupService;
import com.lokesh.movies.util.MovieUtil;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class JsoupController {
	
	@Autowired private JsoupService jsoupService;
	
	@GetMapping(value = "/others")
	public String others(Model model) throws UnirestException {
		Map<String, String> movieCountries = MovieUtil.getmovieLanguages();
		model.addAttribute("movieCountries", movieCountries);
		model.addAttribute("title", "others");
		return "movies/others";
	}
	
	@GetMapping(value = "/other/movies")
	public String movies(@RequestParam String movieType, Model model) throws UnirestException {
		String language = MovieUtil.getMovieLanguage(movieType);
		model.addAttribute("language", language);
		model.addAttribute("movieType", movieType);
		model.addAttribute("title", language);
		return "movies/othermovies";
	}
	
	@GetMapping(value = "/{movieType}/movies/all")
	public String teluguMoviesByIndex(@PathVariable String movieType, @RequestParam String pageIndex, Model model) throws UnirestException, UnsupportedEncodingException {
		String language = MovieUtil.getMovieLanguage(movieType);
		String apendurl = Integer.parseInt(movieType) <= 6 ? "movie" : "18";
		String MovieUrl = language.toLowerCase()+"-"+ apendurl;
		List<Movie> movies = jsoupService.getJsoupMoviesByIndex(MovieUrl, pageIndex);
		model.addAttribute("movies", movies);
		return "movies/otherappendmovies";
	}
	
	@GetMapping(value = "/other/movie")
	public String showMovie(@RequestParam String movieId, Model model) throws UnirestException, UnsupportedEncodingException {
		Movie movie = jsoupService.getMovieDetailsByMovieId(movieId);
		model.addAttribute("movie", movie);
		return "movies/showothermovie";
	}
	
	

}
