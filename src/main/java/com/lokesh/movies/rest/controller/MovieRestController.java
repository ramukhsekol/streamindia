package com.lokesh.movies.rest.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
import com.lokesh.movies.domain.MovieGenres;
import com.lokesh.movies.domain.Person;
import com.lokesh.movies.domain.ShowImdb;
import com.lokesh.movies.domain.TvEpisodes;
import com.lokesh.movies.domain.TvSeasons;
import com.lokesh.movies.dto.MovieList;
import com.lokesh.movies.dto.MovieTrailers;
import com.lokesh.movies.service.MovieService;
import com.lokesh.movies.util.MovieUtil;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieRestController {

	@Autowired
	private MovieService movieService;
	
	
	@GetMapping(value = "/homeAllMovies")
	public ResponseEntity<MovieList> homePornMovies() throws UnirestException, UnsupportedEncodingException {
		Gson gson = new Gson();
		List<Movie> nowPlayings = movieService.getAllMovies();
		JSONArray popularMovieJsonArray = movieService.getMoviesByIndexOrSearchOrGeneric("1", "", "", "", "movie");
		JSONArray popularTvJsonArray = movieService.getMoviesByIndexOrSearchOrGeneric("1", "", "", "", "tv");
		List<MovieGenres> movieGenres = movieService.getMovieGenries("movie");
		Type responseType = new TypeToken<List<Movie>>() {}.getType();
		List<Movie> popularMovies = gson.fromJson(popularMovieJsonArray.toString(), responseType);
		List<Movie> popularShows = gson.fromJson(popularTvJsonArray.toString(), responseType);
		
		MovieList movieList = new MovieList();
		movieList.setNowPlayings(nowPlayings);
		movieList.setPopularMovies(popularMovies);
		movieList.setPopularShows(popularShows);
		movieList.setMovieGenres(movieGenres);
		return new ResponseEntity<MovieList>(movieList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/movies/all")
	public ResponseEntity<Object> moviesByIndex(@RequestParam String pageIndex, @RequestParam String type,
			@RequestParam String query, @RequestParam String queryId, @RequestParam String searchType)
			throws UnirestException, UnsupportedEncodingException {

		if (searchType.equalsIgnoreCase("movie") && type.equalsIgnoreCase("personMovies")
				&& pageIndex.equalsIgnoreCase("1")) {
			List<Movie> movies = movieService.getMoviesByPersonId(queryId).stream().map(m -> {
				m.setMedia_id(m.getMedia_type().equalsIgnoreCase("movie") ? 1 : 0);
				return m;
			}).collect(Collectors.toList());
			return new ResponseEntity<Object>(movies, HttpStatus.OK);
		} else if (!type.equalsIgnoreCase("personMovies")) {
			JSONArray jsonArray = movieService.getMoviesByIndexOrSearchOrGeneric(pageIndex, type, query, queryId,
					searchType);
			Gson gson = new Gson();
			if (jsonArray != null) {
				if ((searchType.equalsIgnoreCase("movie") || searchType.equalsIgnoreCase("tv"))
						&& !type.equalsIgnoreCase("personMovies")) {
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
	public ResponseEntity<Object> showMovie(@RequestParam String movieId, @RequestParam String searchType)
			throws UnirestException, UnsupportedEncodingException {
		if (searchType.equalsIgnoreCase("tv")) {
			MovieTrailers movie = movieService.getTvShowDetailsByShowId(movieId, "show");
			ShowImdb showImdb = movieService.getImdbByShowId(movieId);

			if (movie != null && movie.getTvShows() != null && !movie.getTvShows().getEpisode_run_time().isEmpty()) {
				movie.getTvShows().setConvertRunTime(
						MovieUtil.convertMovieTiming(movie.getTvShows().getEpisode_run_time().get(0)));
			}
			if (movie.getTvShows() != null && movie.getTvShows().getSeasons() != null
					&& !movie.getTvShows().getSeasons().isEmpty()) {
				List<TvSeasons> tvSeasons = movie.getTvShows().getSeasons().stream()
						.sorted(Comparator.comparingInt(TvSeasons::getSeason_number).reversed())
						.collect(Collectors.toList());
				if (tvSeasons != null && !tvSeasons.isEmpty()) {
					List<TvEpisodes> tvEpisodes = movieService
							.getTvEpisodesByShowIdAndSeasonId(movieId, tvSeasons.get(0).getSeason_number()).stream()
							.sorted(Comparator.comparingInt(TvEpisodes::getEpisode_number))
							.collect(Collectors.toList());
					;
					movie.getTvShows()
							.setMovieLink("https://www.2embed.ru/embed/tmdb/tv?id=" + movie.getTvShows().getId() + "&s="
									+ tvSeasons.get(0).getSeason_number() + "&e="
									+ tvEpisodes.get(0).getEpisode_number() + "&enablejsapi=1");
					if (showImdb != null && StringUtils.hasText(showImdb.getImdb_id())) {
						movie.getTvShows().setMovieLink2("https://gomostream.com/show/" + showImdb.getImdb_id() + "/"
								+ tvSeasons.get(0).getSeason_number() + "-" + tvEpisodes.get(0).getEpisode_number());
						movie.setImdbId(showImdb.getImdb_id());
					}
					movie.setTvSeasons(tvSeasons);
					movie.setTvEpisodes(tvEpisodes);
				}
			}
			return new ResponseEntity<Object>(movie, HttpStatus.OK);

		} else {
			MovieTrailers movie = movieService.getMovieDetailsByMovieId(movieId, "show");
			if (movie != null && movie.getMovie() != null && movie.getMovie().getRuntime() != null) {
				movie.getMovie().setConvertRunTime(MovieUtil.convertMovieTiming(movie.getMovie().getRuntime()));
			}
			if (movie.getCrews() != null && !movie.getCrews().isEmpty()) {
				String director = movie.getCrews().stream().filter(m -> m.getJob().equalsIgnoreCase("Director"))
						.map(d -> d.getName()).collect(Collectors.joining(", "));
				String producer = movie.getCrews().stream().filter(m -> m.getJob().equalsIgnoreCase("Producer"))
						.map(d -> d.getName()).collect(Collectors.joining(", "));
				movie.getMovie().setDirector(director);
				movie.getMovie().setProducer(producer);
			}
			
			HttpResponse<String> response = Unirest.get("https://getsuperembed.link/?video_id=" + movie.getMovie().getImdb_id()).asString();
			movie.getMovie().setMovieLink("https://www.2embed.ru/embed/imdb/movie?id=" + movie.getMovie().getImdb_id());
			movie.getMovie().setMovieLink2("https://autoembed.xyz/movie/imdb/" + movie.getMovie().getImdb_id());
			movie.getMovie().setMovieLink3(response.getBody());
			movie.getMovie().setMovieLink4("https://v2.vidsrc.me/embed/" + movie.getMovie().getImdb_id());
			movie.getMovie().setMovieLink5("https://gomostream.com/movie/" + movie.getMovie().getImdb_id());
			return new ResponseEntity<Object>(movie, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/getepisodes/all")
	public ResponseEntity<List<TvEpisodes>> showEposides(@RequestParam String showId,
			@RequestParam Integer seasonNumber, Model model) throws UnirestException, UnsupportedEncodingException {
		List<TvEpisodes> tvEpisodes = movieService.getTvEpisodesByShowIdAndSeasonId(showId, seasonNumber);
		model.addAttribute("episodes", tvEpisodes);
		return new ResponseEntity<List<TvEpisodes>>(tvEpisodes, HttpStatus.OK);
	}
}

/*
 * String movieTicket =
 * movieService.getMovieTicketByMovieIdAndTicketId(movie.getMovie().getImdb_id()
 * , ipAddress); if (StringUtils.hasText(movieTicket)) {
 * movie.getMovie().setMovieLink("https://videospider.stream/getvideo?key=" +
 * MovieUtil.userKey + "&video_id=" + movie.getMovie().getImdb_id() + "&ticket="
 * + movieTicket); } else {
 * movie.getMovie().setMovieLink("https://streamvideo.link/getvideo?key=" +
 * MovieUtil.userKey + "&video_id=" + movie.getMovie().getImdb_id()); }
 */
