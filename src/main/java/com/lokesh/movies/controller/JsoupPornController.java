package com.lokesh.movies.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lokesh.movies.domain.Movie;
import com.lokesh.movies.domain.Person;
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
			model.addAttribute("isFive", true);
		}else if(StringUtils.hasText(type) && type.equalsIgnoreCase("short")) {
			model.addAttribute("isFive", false);
			String movieLink = "https://pornmate.com/video/page/" + pageIndex;
			movies = jsoupService.getAllJsoupPornMoviesByIndex(movieLink);
		} else if(StringUtils.hasText(type) && type.equalsIgnoreCase("full")) {
			model.addAttribute("isFive", true);
			movies = jsoupService.getAllJsoupPornJsonMoviesByIndex();
		} else if(StringUtils.hasText(type) && type.equalsIgnoreCase("romance")) {
			model.addAttribute("isFive", true);
			String movieLink = "https://yespornpleasexxx.com/brazzers-2/page/" + pageIndex + "/";
			movies = jsoupService.getAllRomanceJsoupPornMoviesByIndex(movieLink);
		}
		
		model.addAttribute("movies", movies);
		model.addAttribute("type", type);
		return "movies/otherappendpornmovies";
	}
	
	@GetMapping(value = "/porn/movie")
	@ResponseBody
	public Movie pornMovie(@RequestParam String movieLink, @RequestParam String type) throws UnirestException, UnsupportedEncodingException {
		Movie movie = jsoupService.getParticularPornMovieDetailsByMovieLink(movieLink, type);
		return movie;
	}
	
	
	@GetMapping(value = "/others/porn/stars")
	public String pornStars(Model model) throws UnirestException {
		model.addAttribute("title", "others");
		return "movies/pornstars";
	}
	
	@GetMapping(value = "/porn/stars/all")
	public String pornStarsByIndex(@RequestParam String pageIndex, Model model) throws UnirestException, UnsupportedEncodingException {
		if(StringUtils.hasText(pageIndex) && Integer.parseInt(pageIndex) <= 3) {
			List<Person> persons = jsoupService.getPornStarsByIndex(pageIndex);
			model.addAttribute("persons", persons);
		} else {
			List<Person> persons = new ArrayList<>();
			model.addAttribute("persons", persons);
		}
		model.addAttribute("title", "others");
		return "movies/appendpornstars";
	}
	
	@GetMapping(value = "/person/porn")
	public String pornStarMovies(@RequestParam String personLink, Model model) throws UnirestException, UnsupportedEncodingException {
		model.addAttribute("isFive", false);
		String movieLink = "https://pornmate.com/star/" + personLink;
		List<Movie> movies  = jsoupService.getAllJsoupPornMoviesByIndex(movieLink);
		model.addAttribute("movies", movies);
		model.addAttribute("title", "others");
		return "movies/pornstarmovies";
	}
	
	
	@GetMapping(value = "/others/porn/categories")
	public String pornCategories(Model model) throws UnirestException {
		model.addAttribute("title", "others");
		return "movies/porncategories";
	}
	
	@GetMapping(value = "/porn/categories/all")
	public String pornCategoriesByIndex(@RequestParam String pageIndex, Model model) throws UnirestException, UnsupportedEncodingException {
		List<Person> persons = jsoupService.getPornCategoriesByIndex(pageIndex);
		model.addAttribute("persons", persons);
		model.addAttribute("title", "others");
		return "movies/appendporncategories";
	}
	
	
	@GetMapping(value = "/category/porn")
	public String pornCategoryMovies(@RequestParam String categoryType, Model model) throws UnirestException, UnsupportedEncodingException {
		model.addAttribute("title", "others");
		model.addAttribute("categoryType", categoryType);
		return "movies/pornscategorymovies";
	}
	
	@GetMapping(value = "/porn/category/{categoryType}/all")
	public String pornCategoryMoviesByIndex(@PathVariable String categoryType, @RequestParam String pageIndex, Model model) throws UnirestException, UnsupportedEncodingException {
		List<Movie> movies = jsoupService.getPornCategoryMoviesByIndex(categoryType, pageIndex);
		model.addAttribute("movies", movies);
		return "movies/appendporncategorymovies";
	}
	
	
}
