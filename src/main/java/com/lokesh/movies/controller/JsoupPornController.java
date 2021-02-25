package com.lokesh.movies.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.service.JsoupService;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class JsoupPornController {
	
	@Autowired private JsoupService jsoupService;
	
	@GetMapping(value = "/others/movies/adult")
	public String others(@RequestParam String type, Model model) throws UnirestException {
		model.addAttribute("title", "others");
		model.addAttribute("type", type);
		return "movies/porn";
	}
	
	@GetMapping(value = "/porn/movies/all")
	public String teluguMoviesByIndex(@RequestParam String type, @RequestParam String pageIndex, Model model) throws UnirestException, UnsupportedEncodingException {
		List<Movie> movies = new ArrayList<>();
		if(StringUtils.hasText(type) && type.equalsIgnoreCase("full") && Integer.parseInt(pageIndex) > 1) {
			movies = new ArrayList<>();
		}else if(StringUtils.hasText(type) && type.equalsIgnoreCase("short")) {
			model.addAttribute("isFive", false);
			movies = jsoupService.getAllJsoupPornMoviesByIndex(pageIndex);
		} else if(StringUtils.hasText(type) && type.equalsIgnoreCase("full")) {
			model.addAttribute("isFive", true);
			movies = jsoupService.getAllJsoupPornJsonMoviesByIndex();
		}
		
		model.addAttribute("movies", movies);
		return "movies/otherappendpornmovies";
	}
	
	@GetMapping(value = "/porn/movie")
	@ResponseBody
	public Movie pornMovie(@RequestParam String movieLink) throws UnirestException, UnsupportedEncodingException {
		Movie movie = jsoupService.getParticularPornMovieDetailsByMovieLink(movieLink);
		return movie;
	}

}
