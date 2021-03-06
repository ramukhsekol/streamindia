package com.lokesh.movies.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokesh.movies.domain.Languages;
import com.lokesh.movies.service.MovieService;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping("/api")
public class MovieLanguagesRestController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping(value = "/languages")
	public ResponseEntity<List<Languages>> languages(Model model) throws UnirestException {
		List<Languages> movieLanguages = movieService.getMovieLanguages();
		return new ResponseEntity<List<Languages>>(movieLanguages, HttpStatus.OK);
	}
}
