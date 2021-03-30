package com.lokesh.movies.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
	
	@GetMapping(value = "generatejson")
	public void genereateJson() {
		List<Movie> movies = jsoupService.getAllJsoupPornFullMoviesByIndex();
		if(movies!=null && !movies.isEmpty()) {
			jsoupService.generateJsonFile(movies);
		}
	}
	
	@GetMapping(value = "/others")
	public String others(Model model) throws UnirestException {
		Map<Integer, String> movieCountries = MovieUtil.getmovieLanguages();
		model.addAttribute("movieCountries", movieCountries);
		model.addAttribute("title", "others");
		return "movies/others";
	}
	
	@GetMapping(value = "/other/movies")
	public String movies(@RequestParam Integer movieType, Model model) throws UnirestException {
		String language = MovieUtil.getMovieLanguage(movieType);
		model.addAttribute("language", language);
		model.addAttribute("movieType", movieType);
		model.addAttribute("title", "others");
		model.addAttribute("search", "");
		return "movies/othermovies";
	}
	
	@GetMapping(value = "/other/{movieType}/movies")
	public String searchMovies(@PathVariable Integer movieType, @RequestParam String search, Model model) throws UnirestException {
		String language = MovieUtil.getMovieLanguage(movieType);
		model.addAttribute("language", language);
		model.addAttribute("movieType", movieType);
		model.addAttribute("title", "others");
		model.addAttribute("search", search);
		return "movies/othermovies";
	}
	
	@GetMapping(value = "/{movieType}/movies/all")
	public String teluguMoviesByIndex(@PathVariable Integer movieType, @RequestParam String pageIndex, @RequestParam String search, Model model) throws UnirestException, UnsupportedEncodingException {
		String language = MovieUtil.getMovieLanguage(movieType);
		if(movieType <= 5) {
			List<Movie> movies = new ArrayList<Movie>();
			if(StringUtils.hasText(search)) {
				movies = jsoupService.getAllJsoupSearchMoviesByIndex(search, pageIndex);
			} else {
				String movieUrl =  "language/" + language.toLowerCase() ;
				movies = jsoupService.getAllJsoupMoviesByIndex(movieUrl, pageIndex);
			}
			model.addAttribute("movies", movies);
			model.addAttribute("isFive", true);
		} else {
			if(StringUtils.hasText(search)) {
				List<Movie> movies = jsoupService.getAllJsoupSearchMoviesByIndex(search, pageIndex);
				model.addAttribute("movies", movies);
				model.addAttribute("isFive", true);
			} else {
				if(movieType >= 6 && movieType <= 7) {
					String movieUrl = language.toLowerCase()+"-"+ "movie";
					List<Movie> movies = jsoupService.getJsoupMoviesByIndex(movieUrl, pageIndex);
					model.addAttribute("movies", movies);
					model.addAttribute("isFive", false);
				} else if(movieType >= 9 && movieType <= 11) {
					String apendurl = movieType != 11 ? "dubbed-movie-2" : "dubbed-movie";
					String movieUrl = language.toLowerCase()+"-"+ apendurl;
					List<Movie> movies = jsoupService.getJsoupMoviesByIndex(movieUrl, pageIndex);
					model.addAttribute("movies", movies);
					model.addAttribute("isFive", false);
				} else {
					String movieUrl = language.toLowerCase()+"-"+ "18";
					List<Movie> movies = jsoupService.getJsoupMoviesByIndex(movieUrl, pageIndex);
					model.addAttribute("movies", movies);
					model.addAttribute("isFive", false);
				}
			}
		}
		return "movies/otherappendmovies";
	}
	
	@GetMapping(value = "/other/movie")
	public String showMovie(@RequestParam String movieId, @RequestParam boolean status, Model model) throws UnirestException, UnsupportedEncodingException {
		if(status) {
			Movie movie = jsoupService.getParticularMovieDetailsByMovieId(movieId);
			model.addAttribute("movie", movie);
			model.addAttribute("title", movie.getTitle());
		} else {
			Movie movie = jsoupService.getMovieDetailsByMovieId(movieId);
			model.addAttribute("movie", movie);
			model.addAttribute("title", movie.getTitle());
		}
		return "movies/showothermovie";
	}
	
	

}
