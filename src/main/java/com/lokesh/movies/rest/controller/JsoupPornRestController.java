package com.lokesh.movies.rest.controller;

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
import com.lokesh.movies.dto.MovieList;
import com.lokesh.movies.service.JsoupPornService;
import com.lokesh.movies.service.JsoupService;

@RestController
@RequestMapping("/api")
public class JsoupPornRestController {
	
	@Autowired private JsoupService jsoupService;
	@Autowired private JsoupPornService jsoupPornService;
	
	@GetMapping(value = "/homePornMovies")
	public ResponseEntity<MovieList> homePornMovies() {
		String romanceMovieLink = "https://yespornpleasexxx.com/brazzersx/page/1/";
		String bangMovieLink = "https://yespornpleasexxx.com/bangbros-3/page/1/";
		String kingMovieLink = "https://yespornpleasexxx.com/reality-kings-2/page/1/";
		String vixenMovieLink = "https://yespornpleasexxx.com/vixen/page/1/";
		String pornModelsLink = "https://www.xozilla.com/models/1/";
		String pornStarsLink = "https://www.uiporn.com/pornstars/1/";
		
		
		
		List<Movie> romances = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(romanceMovieLink, 1, 10, false);
		List<Movie> famouses = jsoupPornService.getFamousStars(1, 10, false);
		List<Movie> bangs = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(bangMovieLink, 1, 10, false);
		List<Movie> kings = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(kingMovieLink, 1, 10, false);
		List<Movie> vixens = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(vixenMovieLink, 1, 10, false);
		List<Movie> pornModels = jsoupPornService.pornModelsByPageIndex(pornModelsLink, 1, 10, true);
		List<Movie> pornStars = jsoupPornService.pornStarsByPageIndex(pornStarsLink, 1, 10, false);
		
		
		MovieList movieList = new MovieList();
		movieList.setRomances(romances);
		movieList.setFamouses(famouses);
		movieList.setBangs(bangs);
		movieList.setKings(kings);
		movieList.setVixens(vixens);
		movieList.setPornModels(pornModels);
		movieList.setPornStars(pornStars);
		return new ResponseEntity<MovieList>(movieList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/romanceMoviesByPageIndex")
	public ResponseEntity<List<Movie>> romancePornByIndex(@RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		String movieLink = "https://yespornpleasexxx.com/brazzersx/page/" + pageIndex + "/";
		List<Movie> movies = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getFamousStars")
	public ResponseEntity<List<Movie>> getFamousStars(@RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		List<Movie> movies = jsoupPornService.getFamousStars(startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/famousMoviesByPageIndex")
	public ResponseEntity<List<Movie>> romancePornByIndex(@RequestParam String movieLink, @RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		movieLink = movieLink + "/page/" + pageIndex + "/";
		List<Movie> movies = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/bangMoviesByPageIndex")
	public ResponseEntity<List<Movie>> bangMoviesByPageIndex(@RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		String movieLink = "https://yespornpleasexxx.com/bangbros-3/page/" + pageIndex + "/";
		List<Movie> movies = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/kingsMoviesByPageIndex")
	public ResponseEntity<List<Movie>> kingsMoviesByPageIndex(@RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		String movieLink = "https://yespornpleasexxx.com/reality-kings-2/page/" + pageIndex + "/";
		List<Movie> movies = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/vixenMoviesByPageIndex")
	public ResponseEntity<List<Movie>> vixenMoviesByPageIndex(@RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		String movieLink = "https://yespornpleasexxx.com/vixen/page/" + pageIndex + "/";
		List<Movie> movies = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getRomanceMovieByMovieLink")
	public ResponseEntity<Movie> getRomanceMovieByMovieLink(@RequestParam String movieLink) {
		Movie movie = jsoupPornService.getParticularPornMovieDetailsByMovieLink(movieLink, "romance");
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pornModelsByPageIndex")
	public ResponseEntity<List<Movie>> pornModelsByPageIndex(@RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		String movieLink = "https://www.xozilla.com/models/" + pageIndex + "/";
		List<Movie> movies = jsoupPornService.pornModelsByPageIndex(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pornModelMovies")
	public ResponseEntity<List<Movie>> pornModelMovies(@RequestParam String movieLink, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		List<Movie> movies = jsoupPornService.pornModelMoviesByMovieLink(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pornStarsByPageIndex")
	public ResponseEntity<List<Movie>> pornStarsByPageIndex(@RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		String movieLink = "https://www.uiporn.com/pornstars/" + pageIndex + "/";
		List<Movie> movies = jsoupPornService.pornStarsByPageIndex(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pornStarMovies")
	public ResponseEntity<List<Movie>> pornStarMovies(@RequestParam String movieLink, @RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		movieLink = movieLink + "?mode=async&function=get_block&block_id=list_videos_model_videos&from=" + pageIndex;
		List<Movie> movies = jsoupPornService.pornStarMoviesByPageIndex(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(value = "/romance/porn/all")
	public ResponseEntity<List<Movie>> romancePorn(@RequestParam String pageIndex, @RequestParam Integer startIndex, @RequestParam Integer endIndex) {
		String movieLink = "https://yespornpleasexxx.com/brazzers-2/page/" + pageIndex + "/";
		List<Movie> movies = jsoupPornService.getAllTypeJsoupPornMoviesByIndex(movieLink, startIndex, endIndex, true);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/porn/all")
	public ResponseEntity<List<Movie>> pornByIndex(@RequestParam String pageIndex) {
		String movieLink = "https://pornmate.com/video/page/" + pageIndex;
		List<Movie>  movies = jsoupService.getAllJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/porn/movies/all")
	public ResponseEntity<List<Movie>> pornMoviesByIndex() {
		List<Movie> movies = jsoupService.getAllJsoupPornJsonMoviesByIndex();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/porn/stars/all")
	public ResponseEntity<List<Person>> pornStarsByIndex(@RequestParam String pageIndex) {
		if(StringUtils.hasText(pageIndex) && Integer.parseInt(pageIndex) <= 3) {
			List<Person> persons = jsoupService.getPornStarsByIndex(pageIndex);
			return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
		} else {
			List<Person> persons = new ArrayList<>();
			return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/person/porn")
	public ResponseEntity<List<Movie>> pornStarMovies(@RequestParam String personLink) {
		String movieLink = "https://pornmate.com/star/" + personLink;
		List<Movie> movies  = jsoupService.getAllJsoupPornMoviesByIndex(movieLink);
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping(value = "/porn/movie")
	public ResponseEntity<Movie> pornMovie(@RequestParam String movieLink, @RequestParam String type) {
		Movie movie = jsoupPornService.getParticularPornMovieDetailsByMovieLink(movieLink, type);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
}
