package com.lokesh.movies.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lokesh.movies.mx.MxPlayer;
import com.lokesh.movies.service.MxPlayerService;
import com.lokesh.movies.util.MovieUtil;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class MxPlayerController {
	
	@Autowired private MxPlayerService mxPlayerService;
	
	@GetMapping(value = "/mx/movies")
	public String mxMoviesByIndex(@RequestParam String type, Model model) throws UnirestException, UnsupportedEncodingException {
		model.addAttribute("type", type); 
		model.addAttribute("title", "mx");
		return "movies/mxmovies";
	}

	@GetMapping(value = "/mx/movies/all")
	public String mxMoviesByIndex(@RequestParam Integer pageIndex, @RequestParam String type, Model model) throws UnirestException, UnsupportedEncodingException {
		JSONArray jsonArray = mxPlayerService.getMoviesByIndexAndType(pageIndex, type);
		Gson gson = new Gson();
		if(jsonArray!=null) {
			Type responseType = new TypeToken<List<MxPlayer>>() {
			}.getType();
			List<MxPlayer> movies = gson.fromJson(jsonArray.toString(), responseType);
			model.addAttribute("movies", movies);
		}
		return "movies/appendmxmovies";
	}
	
	
	@GetMapping(value = "/play/mx/movie")
	public String playMxMoviesByIndex(@RequestParam String movieId, Model model) throws UnirestException, UnsupportedEncodingException {
		JSONObject jsonObject = mxPlayerService.getMoviesById(movieId);
		Gson gson = new Gson();
		if(jsonObject!=null) {
			Type responseType = new TypeToken<MxPlayer>() {
			}.getType();
			MxPlayer movie = gson.fromJson(jsonObject.toString(), responseType);

			int secondsLeft = movie.getDuration() % 3600 % 60;
		    int minutes = (int) Math.floor(movie.getDuration() % 3600 / 60);
		    int hours = (int) Math.floor(movie.getDuration() / 3600);

		    String HH = ((hours       < 10) ? "0" : "") + hours;
		    String MM = ((minutes     < 10) ? "0" : "") + minutes;
		    String SS = ((secondsLeft < 10) ? "0" : "") + secondsLeft;
			
		    String runTime = HH + "h : " + MM + "m : " + SS + 's';
			
			String director = movie.getContributors().stream().filter(m -> m.getType().equalsIgnoreCase("director")).map(d -> d.getName()).collect(Collectors.joining(", "));
			model.addAttribute("director", director);
			
			
			String genres = movie.getGenres().stream().map(Object::toString).collect(Collectors.joining(", "));
			String backgroundImage = movie.getImageInfo().stream()
					.filter(image -> image.getType().equalsIgnoreCase("bigpic"))
					.map(image -> image.getUrl()).collect(Collectors.toList()).get(0);
			model.addAttribute("backgroundImage", backgroundImage);
			model.addAttribute("genres", genres);
			model.addAttribute("runTime", runTime);
			model.addAttribute("movie", movie);
			model.addAttribute("title", "mx");
		}
		return "movies/showmxmovie";
	}
}
