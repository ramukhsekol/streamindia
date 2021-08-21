package com.lokesh.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lokesh.movies.domain.Languages;
import com.lokesh.movies.service.MovieService;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class MovieLanguagesController {
	
	@Autowired private MovieService movieService;
	
	@GetMapping(value = "/languages")
	public String languages(@RequestParam String searchType,  Model model) throws UnirestException {
		List<Languages> movieLanguages = movieService.getMovieLanguages();
		model.addAttribute("movieLanguages", movieLanguages);
		model.addAttribute("title", "languages");
		model.addAttribute("searchType", searchType);
		return "movies/languages";
	}

}
